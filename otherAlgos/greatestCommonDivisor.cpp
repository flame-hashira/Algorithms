#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ll a,b;
  cin>>a>>b;
  while(b!=0)
  {
    ll temp = b;
    b = a % b;
    a = temp;
  }
  cout<<a<<endl;
  return 0;
}
