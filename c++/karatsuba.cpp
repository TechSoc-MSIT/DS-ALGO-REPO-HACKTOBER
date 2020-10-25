#define ll long long

#define FAST                        \
  ios_base::sync_with_stdio(false); \
  cin.tie(NULL);                    \
  cout.tie(NULL);

#include <bits/stdc++.h>

using namespace std;

int makeStrLenghtEqual(string &str1, string &str2)
{
  int l1 = str1.length();
  int l2 = str2.length();

  if (l1 < l2)
  {
    for (int i(0); i < l2 - l1; i++)
    {
      str1 = '0' + str1;
    }
    return l2;
  }
  else if (l1 > l2)
  {
    for (int i(0); i < l1 - l2; i++)
    {
      str2 = '0' + str2;
    }
  }
  return l1;
}

string addBits(string a, string b)
{
  int len = makeStrLenghtEqual(a, b);
  int carry = 0;
  string res;

  for (int i = len - 1; i >= 0; i--)
  {
    int bit1 = a[i] - '0';
    int bit2 = b[i] - '0';

    int sum = (bit1 ^ bit2 ^ carry) + '0';

    res = (char)sum + res;

    carry = (bit1 & bit2) | (bit1 & carry) | (bit2 & carry);
  }

  if (carry)
  {
    res = '1' + res;
  }

  return res;
}

size_t karatsubaFastMultiply(string num1, string num2)
{
  auto multiplyOneBit = [&num1, &num2] { return (num1[0] - '0') * (num2[0] - '0'); };

  int n = makeStrLenghtEqual(num1, num2);

  if (n == 0)
    return 0;
  if (n == 1)
    return multiplyOneBit();

  int p1 = n / 2;
  int p2 = n - p1;

  string num1l = num1.substr(0, p1);
  string num1r = num1.substr(p1, p2);

  string num2l = num2.substr(0, p1);
  string num2r = num2.substr(p1, p2);

  size_t prod1 = karatsubaFastMultiply(num1l, num2l);
  size_t prod2 = karatsubaFastMultiply(num1r, num2r);
  size_t prod3 = karatsubaFastMultiply(addBits(num1l, num1r), addBits(num2l, num2r));

  return prod1 * (1 << (2 * p2)) + (prod3 - prod1 - prod2) * (1 << p2) + prod2;
}

int main()
{
  FAST;

  string s1, s2;

  cin >> s1 >> s2;

  cout << karatsubaFastMultiply(s1, s2);

  return 0;
}
