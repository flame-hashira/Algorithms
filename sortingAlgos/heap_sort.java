import java.util.Random;
public class heap_sort {
    public static void main(String[] args){
        Random rand = new Random();
        int size=10000;
        int[] a = new int[size+1];
        int[] b = new int[size+1];
        int[] c = new int[size+1];
        long start_a=0,end_a=0,start_b=0,end_b=0,start_c=0,end_c=0;
        double sort_a=0,sort_b=0,sort_c=0;
        for(int j=0;j<15;j++)
        {
            for(int i=1;i<=size;i++)
            {
                a[i]=i;
                b[i] = size-i+1;
                c[i] = rand.nextInt(size+1000);
            }
            start_a = System.nanoTime();
            heap_sort(a,size);
            end_a = System.nanoTime();
            sort_a +=(end_a-start_a)/1000.0;
            start_b = System.nanoTime();
            heap_sort(b,size);
            end_b = System.nanoTime();
            sort_b +=(end_b-start_b)/1000.0;
            start_c = System.nanoTime();
            heap_sort(a,size);
            end_c = System.nanoTime();
            sort_c +=(end_c-start_c)/1000.0;
        }
        sort_a = sort_a/15.0;
        sort_b = sort_b/15.0;
        sort_c = sort_c/15.0;
        System.out.println("Average Time for Array a is " + sort_a);
        System.out.println("Average Time for Array b is " + sort_b);
        System.out.println("Average Time for Array c is " + sort_c);
    }

    static void heap_sort(int []a,int size)
    {
        int[] tem_a = new int[size+1];
        for(int i=1;i<=size;i++)
        {
            tem_a[i] = a[i];
            heapify(a,i);
        }
        int last = size;
        while(last>1)
        {
            a[1] = a[1] + a[last];
            a[last] = a[1] -a[last];
            a[1] = a[1] - a[last];
            last--;
            check_next_max(a,last,1);
        }
    }

    static void check_next_max(int [] a,int last,int curr)
    {
        int larger = curr;
        int left_child = curr*2;
        int right_child = left_child+1;
        if(left_child<=last && a[left_child] > a[larger])
        {
            larger = left_child;
        }
        if(right_child<=last && a[right_child]>a[larger])
        {
            larger = right_child;
        }
        if(larger!=curr)
        {
            a[curr]=a[curr]+a[larger];
            a[larger] = a[curr]-a[larger];
            a[curr] = a[curr]-a[larger];
            check_next_max(a, last, larger);
        }
    }
    static void heapify(int [] a,int curr)
    {
        int par = curr/2;
        if(par>=1 && a[par]< a[curr])
        {
            a[par] = a[par]+a[curr];
            a[curr] = a[par]-a[curr];
            a[par] = a[par]-a[curr];
            heapify(a,par);
        }
    }
}