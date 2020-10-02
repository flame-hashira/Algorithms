import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class BinarySearch {
    
    public static int binarySearch(int arr[] , int left , int right , int key) {

        if (right >= left) { 
            int mid = left + (right - left) / 2; 

            if (arr[mid] == key) 
                return mid; 

            if (arr[mid] > key) 
                return binarySearch(arr, left, mid - 1, key); 
  
            return binarySearch(arr, mid + 1, right, key); 
        } 

        return -1; 
    }


    public static void main(String args []) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int n;
        System.out.print("Enter the size of the array : ");
        n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int r = n + 200;
        for(int i=0;i<n;i++)
        {
            a[i] = i;
        }
        for(int i=0;i<n;i++)
        {
            b[i] = n-i;
        }
        for(int i=0;i<n;i++)
        {
            c[i] = rand.nextInt(r);
        }
        int keyA = 0;
        int keyB = n-1;
        int keyC = (n-1)/2;

        int[] a1 = new int [n];
        int[] b1 = new int [n];
        int[] c1 = new int [n];


        for(int j = 0; j < 15; j++)
        {
            for(int i = 0 ; i < n ; i++)
            {
                a1[i] = a[i];
            }
            for(int i = 0 ; i < n ; i++)
            {
                b1[i] = b[i];
            }
            for(int i = 0 ; i < n ; i++)
            {
                c1[i] = c[i];
            }
            final long startTimeA = System.nanoTime();
            int responseA = binarySearch(a1,0,n-1,keyA);
            final long durationA = (System.nanoTime() - startTimeA);

            final long startTimeB = System.nanoTime();
            Arrays.sort(b1,0,n-1);
            int responseB = binarySearch(b1,0,n-1,keyB);
            final long durationB = (System.nanoTime() - startTimeB);

            final long startTimeC = System.nanoTime();
            Arrays.sort(c1,0,n-1);
            int responseC = binarySearch(c1,0,n-1,keyC);
            final long durationC= (System.nanoTime() - startTimeC);

            if(responseA == -1)
                System.out.println("Element not found in the array a[]");
            else
                System.out.println("Element found at index " + responseA + " of the array a[]");

            if(responseB == -1)
                System.out.println("Element not found in the array b[]");
            else
                System.out.println("Element found at index " + responseB + " of the array b[]");

            if(responseC == -1)
                System.out.println("Element not found in the array c[]");
            else
                System.out.println("Element found at index " + responseC + " of the array c[]");

            System.out.println("The time required to run the algorithm of binarySearch for a[] is " + durationA + " nanoseconds.");
            System.out.println("The time required to run the algorithm of binarySearch for b[] is " + durationB + " nanoseconds.");
            System.out.println("The time required to run the algorithm of binarySearch for c[] is " + durationC + " nanoseconds.");
        }
        
    }
}