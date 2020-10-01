import java.util.Random;
public class RadixSort {
    public static void main(String[] args){
        Random rand = new Random();
        int size=2000;
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

        for(int i=1;max/i>0;i*=10)
        {
            sort(a,i,size);
        }

        duration = (System.nanoTime() - start)/1000.0;
        System.out.println("Time is " + duration);
    }

    static void sort(int[] a,int exp,int size){
        int []c = new int[10];
        int []b = new int[size];
        for(int i=0;i<size;i++)
        {
            c[(a[i]/exp)%10]++;
        }

        for(int i=1;i<10;i++)
        {
            c[i]=c[i-1]+c[i];
        }

        for(int i=size-1;i>=0;i--)
        {
            b[c[(a[i]/exp)%10]-1] = a[i];
            c[(a[i]/exp)%10]--;
        }

        for(int i=0;i<size;i++)
        {
            a[i] = b[i];
        }
    }
}
