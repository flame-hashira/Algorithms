import java.util.Random;
public class countingSort {
    public static void main(String[] args){
        Random rand = new Random();
        int size=10000;
        double start,duration;
        int []a=new int[size];
        int []b=new int[size];
        for(int i=0;i<size;i++)
        {
            a[i] = rand.nextInt(size);
        }
        start = System.nanoTime();
        //fn to find max element
        int max = a[0];
        for(int i=1;i<size;i++)
        {
            if(max < a[i]){
                max = a[i];
            }
        }

        int[] c = new int[max+1];

        //to calculate frequency
        for(int i=0;i<size;i++)
        {
            c[a[i]]++;
        }

        for(int i=1;i<=max;i++)
        {
            c[i]=c[i-1]+c[i];
        }

        for(int i=size-1;i>=0;i--)
        {
            b[c[a[i]]-1] = a[i];
            c[a[i]]--;
        }

        for(int i=0;i<size;i++)
        {
            a[i] = b[i];
        }
        duration = (System.nanoTime() - start)/1000.0;
        System.out.println("Time is " + duration);
    }

}
