#include <bits/stdc++.h>

#define ll long long

#define FAST                        \
  ios_base::sync_with_stdio(false); \
  cin.tie(NULL);                    \
  cout.tie(NULL);

using namespace std;

int power(int x, uint y, uint m)
{
  if (y == 0)
    return 1;
  int p = power(x, y / 2, m) % m;
  p = (p * p) % m;

  return (y % 2 == 0) ? p : (x * p) % m;
}

void modInverse(int a, int m)
{
  if (__gcd(a, m) != 1)
    cout << "Inverse doesn't exist";

  else
  {
    cout << power(a, m - 2, m);
  }
}

int main()
{
  FAST;

  int a = 3, m = 11;
  modInverse(a, m);

  return 0;
}
