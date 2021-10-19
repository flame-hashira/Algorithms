import java.util.*;

class ka {
	
	class Edge implements Comparable<Edge> 
	{
		int origin;
		int end;
		int cost;

		public int compareTo(Edge compEdge)
		{
			return this.cost - compEdge.cost;
		}
	};

	Edge edge[]; 
	int V, E;

	ka(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	class sub 
	{
		int parent, rank;
    };


	int search(sub subs[], int i)
	{
		if (subs[i].parent != i)
			subs[i].parent = search(subs, subs[i].parent);

		return subs[i].parent;
	}

	void Union(sub subs[], int a, int b)
	{
		int ar = search(subs, a);
		int yr = search(subs, b);
		if (subs[ar].rank < subs[yr].rank)
			subs[ar].parent = yr;
		else if (subs[ar].rank > subs[yr].rank)
			subs[yr].parent = ar;
		else 
		{
			subs[yr].parent = ar;
			subs[ar].rank++;
		}
	}

	void kMST()
	{ 
		int e = 0; 
		int i = 0; 
		Edge res[] = new Edge[V];

		for (i = 0; i < V; ++i)
			res[i] = new Edge();

		Arrays.sort(edge);

		sub subs[] = new sub[V];

		for (i = 0; i < V; ++i)
			subs[i] = new sub();

		for (int v = 0; v < V; ++v) 
		{
			subs[v].parent = v;
			subs[v].rank = 0;
		}

		i = 0; 

		while (e < V - 1) 
		{
			
			Edge nedge = new Edge();
			nedge = edge[i++];

			int a = search(subs, nedge.origin);
			int b = search(subs, nedge.end);

			
			if (a != b) {
				res[e++] = nedge;
				Union(subs, a, b);
			}

		}

		System.out.println("Edges in the constructed MST are : ");
		int minimumCost = 0;
		for (i = 0; i < e; ++i)
		{
			System.out.println(res[i].origin + " -- "
							+ res[i].end
							+ " == " + res[i].cost);
			minimumCost += res[i].cost;
		}
		System.out.println("The total cost of MST is " + minimumCost);
	}


	public static void main(String[] args)
	{

		int V = 6; 
		int E = 9; 
		ka graph = new ka(V, E);

		
		graph.edge[0].origin = 0;
		graph.edge[0].end = 1;
		graph.edge[0].cost = 3;

		
		graph.edge[1].origin = 0;
		graph.edge[1].end = 2;
		graph.edge[1].cost = 9;

		
		graph.edge[2].origin = 1;
		graph.edge[2].end = 4;
		graph.edge[2].cost = 10;

		
		graph.edge[3].origin = 1;
		graph.edge[3].end = 3;
		graph.edge[3].cost = 2;

		
		graph.edge[4].origin = 2;
		graph.edge[4].end = 4;
		graph.edge[4].cost = 8;

		graph.edge[5].origin = 1;
		graph.edge[5].end = 2;
		graph.edge[5].cost = 7;

		graph.edge[6].origin = 3;
		graph.edge[6].end = 5;
		graph.edge[6].cost = 4;

		graph.edge[7].origin = 4;
		graph.edge[7].end = 5;
		graph.edge[7].cost = 7;

		graph.edge[8].origin = 3;
		graph.edge[8].end = 4;
		graph.edge[8].cost = 12;

		final long startTime = System.nanoTime();
		graph.kMST();
		final long duration = (System.nanoTime() - startTime);
		long microsec = duration/1000;
		System.out.println("The duration is : " + microsec + " microseconds.");
	}
}

