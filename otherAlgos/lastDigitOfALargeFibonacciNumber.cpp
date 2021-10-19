#include <bits/stdc++.h>

using namespace std;
int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie (NULL);
  long int n;
  cin>>n;
  long int fib[n+1];
  fib[0] = 0;
  fib[1] = 1;
  if (n==0)
    cout<<"0"<<endl;
  else if (n==1)
    cout<<"1"<<endl;
  else
  {
    for(long long int i=2;i<=n;i++)
    {
      fib[i] = (fib[i-1] + fib[i-2]) % 10;
    }
    cout << fib[n] <<endl;
  }
  return 0;
}
