#include<stdio.h>
#include<stdlib.h>
#define MAX_CHAR 255
#define MAX_SIZE 100
int main()
{
    char s[MAX_SIZE];
    int i;
    gets(s);
    int ascii,freq[MAX_CHAR];
    for(i=0;i<MAX_CHAR;i++)
    {
        freq[i]=0;
    }
    i=0;
    while(s[i]!='\0')
    {
        ascii=(int)s[i];
        freq[ascii]+=1;
        i++;
    }
    int max=0;
    int equal,j=0;
    for(i=0;i<MAX_CHAR;i++)
    {
       /* if(freq[i]==freq[max])
        {
            equal[]
        }
        */

        if(freq[i]>freq[max])
        {
            max=i;
        }

    }
    printf("The most ocurring character is %c : %d times",max,freq[max]);

}
