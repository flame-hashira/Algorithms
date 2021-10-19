#include<stdio.h>
int exponential(int a,int b)
{int i;
 if(b==1)
 {
   return a;
 }
 else
 {
  return (a*exponential(a,b-1));
 }
}
int main()
{int x,y;
 printf("Enter the base and exponent:");
 scanf("%d %d",&x,&y);
 printf("%d\n",exponential(x,y));
 return 0;
}
