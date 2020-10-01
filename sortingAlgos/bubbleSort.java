import java.util.Scanner;

public class bubbleSort {
    public static void sort(int []a,int n)
    {

        int count=0;
        while(count!=n-1)
        {
            for(int i=0;i<n-1;i++)
            {
                if(a[i]>a[i+1])
                {
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                }
                else
                    count++;
            }
            if(count<n-1)
                count=0;
        }

    }
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int [] a = new int [n];
        for(int i=0;i<n;i++)
        {
            a[i]=scan.nextInt();
        }
        sort(a,n);
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}
