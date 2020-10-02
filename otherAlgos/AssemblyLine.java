import java.io.*;

class AssemblyLine
{
	static int noOflines = 2;
	static int noOfStations = 15;
	static int min(int num1, int num2)
	{
		return num1 < num2 ? num1 : num2;
	}
	static int assembly(int arr[][], int t[][], int e[], int x[])
	{
	int t1[]= new int [noOfStations];
	int t2[] =new int[noOfStations] ;
	int i;
	t1[0] = e[0] + arr[0][0];
	t2[0] = e[1] + arr[1][0];

	for (i = 1; i < noOfStations; ++i)
	{
		t1[i] = min(t1[i - 1] + arr[0][i] , t2[i - 1] + t[1][i] + arr[0][i]);
		t2[i] = min(t2[i - 1] + arr[1][i] , t1[i - 1] + t[0][i] + arr[1][i]);
	}

	return min(t1[noOfStations-1] + x[0], t2[noOfStations-1] + x[1]);
}



	public static void main (String[] args)
	{

	//Range is from 5-15

		int a[][] = {{2, 10, 13, 7, 10, 12, 7, 6, 11, 8, 13, 6, 14, 8, 7} , {11, 6, 15, 12, 6, 7, 14, 12, 7, 5, 8, 10, 9, 15, 9}};
		int t[][] = {{4, 9, 8, 5, 6, 7, 14, 15, 11, 5, 6, 11, 8, 9, 8} , {5, 9, 12, 8, 6, 9, 5, 5, 12, 6, 9, 10, 9, 5, 6}};
		int e[] = {10, 12}, x[] = {15, 7};

		System.out.println(assembly(a, t, e, x));

	}
}
 
