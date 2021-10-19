#include<stdio.h>
int main()
{
 int n,i,j,k,t;
 printf("Enter the number of elements:");
 scanf("%d",&n);
 long int a[n];
 for(i=0;i<n;i++)
 {
  printf("a[%d]:",i);
  scanf("%li",&a[i]);
 }
 for(i=0;i<n;i++)
 {
  int c=0,k=0;
  for(j=0;j<n;j++)
  {
   if(i==j)
   continue;
   else
   {
    if(a[i]==a[j])
    {
        if(i>j)
            k++;
     else
     printf("%li ",a[i]);
     c++;

    }

   }

  }
   if(c==0 && k==0)
    printf("%li ",a[i]);
 }
 return 0;
}
