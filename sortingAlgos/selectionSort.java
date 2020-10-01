import java.util.Scanner;
public class selectionSort {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int i,j,temp,n=10;
        int a[] = new int[n];
        for(i=0;i<n;i++)
        {
        	a[i] = sc.nextInt();
        }
        for(i=0;i<n-1;i++)
        {
            for(j=i+1;j<n;j++)
            {
                if(a[j] < a[i])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for(i=0;i<n;i++)
        {
        	System.out.print(a[i]+" ");
        }
	}
}
