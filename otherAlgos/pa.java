import java.util.*;

class pa { 

	private static final int V = 5; 

	int minKey(int k[], Boolean mstArr[]) 
	{ 
		int minimum = Integer.MAX_VALUE, minInd = -1; 

		for (int v = 0; v < V; v++) 
			if (mstArr[v] == false && k[v] < minimum) { 
				minimum = k[v]; 
				minInd = v; 
			} 

		return minInd; 
	} 

	void printMST(int p[], int g[][]) 
	{ 
		System.out.println("Edge \tWeight"); 
		for (int i = 1; i < V; i++) 
			System.out.println(p[i] + " - " + i + "\t" + g[i][p[i]]); 
	} 

	void primMST(int g[][]) 
	{ 
		int p[] = new int[V]; 
		int k[] = new int[V]; 
        Boolean mstArr[] = new Boolean[V]; 
        
		for (int i = 0; i < V; i++) { 
			k[i] = Integer.MAX_VALUE; 
			mstArr[i] = false; 
		} 

		k[0] = 0;
		p[0] = -1; 

		for (int c = 0; c < V - 1; c++) { 
			int u = minKey(k, mstArr); 
            mstArr[u] = true; 
            
			for (int v = 0; v < V; v++) 
				if (g[u][v] != 0 && mstArr[v] == false && g[u][v] < k[v]) { 
					p[v] = u; 
					k[v] = g[u][v]; 
				} 
		} 
		printMST(p, g); 
	} 

	public static void main(String[] args) 
	{ 
		pa t = new pa(); 
		int g[][] = new int[][] { { 0, 2, 0, 8, 5 }, 
									{ 2, 0, 1, 10, 9 }, 
									{ 0, 1, 0, 0, 13 }, 
									{ 8, 10, 0, 0, 5 }, 
									{ 5, 9, 13, 5, 0 } }; 

         
        final long startTime = System.nanoTime();
        t.primMST(g); 
        final long duration = (System.nanoTime() - startTime);
		long microsec = duration/1000;
		System.out.println("The duration is : " + microsec + " microseconds.");
	} 
} 
