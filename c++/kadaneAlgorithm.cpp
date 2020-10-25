#define ll long long

#define FAST                        \
  ios_base::sync_with_stdio(false); \
  cin.tie(NULL);                    \
  cout.tie(NULL);

#include <bits/stdc++.h>

using namespace std;

int main()
{
  FAST;

  int arr[] = {11, 1, -23, 4, 43};
  int n = sizeof(arr) / sizeof(arr[0]);

  auto maxSubSum = [&arr, &n]() {
    int max = INT_MIN, maxTillNow = 0;

    for (int i = 0; i < n; i++)
    {
      maxTillNow = maxTillNow + arr[i];
      if (max < maxTillNow)
        max = maxTillNow;

      if (maxTillNow < 0)
        maxTillNow = 0;
    }
    return max;
  };

  cout << maxSubSum() << endl;

  return 0;
}
