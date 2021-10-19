#include<stdio.h>
#include<math.h>
int angstrom(int n)
{
    int b,sum=0,a=n,c=0;
    int k=n;
    while(a!=0)
    {
        a=a/10;
        c++;
    }

    while(k!=0)
    {
        b=k%10;
        k=k/10;
        sum=sum+pow(b,c);
    }
    //printf("%d %d",sum,c);
    if(sum==n)
        return 1;
    else
        return 0;
}
int main()
{
    int n;
    scanf("%d",&n);
    printf("%d",angstrom(n));


    return 0;
}
