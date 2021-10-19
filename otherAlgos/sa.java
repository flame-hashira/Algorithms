import java.util.*;
import java.io.*;
public class sa {
class Edge
{
int src, dest, weight;
};
int V, E;
Edge edge[];
sa(int v,int e)
{
V = v;
E = e;
edge = new Edge[E];
for (int i = 0; i < e; ++i)
edge[i] = new Edge();
}
int find(int sub[], int i)
{
if (sub[i] != i)
sub[i]
= find(sub, sub[i]);
return sub[i];
}
public void SollinMST(){
int parent[]=new int[V];
int cheapest[]=new int[V];
for (int v = 0; v < V; ++v)
{
parent[v] = v;
cheapest[v] = -1;
}
int numTrees = V;
int MSTweight = 0;
while (numTrees > 1)
{
for (int v = 0; v < V; ++v)
cheapest[v] = -1;
for (int i=0; i<E; i++)
{
int save1 = find(parent, edge[i].src);
int save2 = find(parent, edge[i].dest);
if (save1 == save2)
continue;
else
{
if (cheapest[save1] == -1 ||
edge[cheapest[save1]].weight >
edge[i].weight)
cheapest[save1] = i;
if (cheapest[save2] == -1 ||
edge[cheapest[save2]].weight >
edge[i].weight)
cheapest[save2] = i;
}
}
for (int i=0; i<V; i++)
{
if (cheapest[i] != -1)
{
int save1 = find(parent,
edge[cheapest[i]].src);
int save2 = find(parent,
edge[cheapest[i]].dest);
if (save1 == save2)
continue;
MSTweight += edge[cheapest[i]].weight;
System.out.println(edge[cheapest[i]].src+" -- "+ edge[cheapest[i]].dest +" =>6 "+edge[cheapest[i]].weight);
parent[save1]=save2;
numTrees--;
}
}
}
System.out.println("Weight of MST is "+ MSTweight);
return;
}
public static void main(String[] args)
{
int V,E;
System.out.println("Enter the number of vertix and edge in the graph");
Scanner scan = new Scanner(System.in);
V=scan.nextInt();
E=scan.nextInt();
sa graph = new sa(V, E);
System.out.println("Enter the sorce, destination and the weight of the each edge");
for(int i=0;i<E;i++) {
graph.edge[i].src = scan.nextInt();
graph.edge[i].dest = scan.nextInt();
graph.edge[i].weight = scan.nextInt();
}
long start = System.nanoTime();
graph.SollinMST();
long end = System.nanoTime();
long microseconds = (end - start) / 1000;
System.out.println("Time for MST in micro seconds is "+microseconds);
}
}
