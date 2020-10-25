#include <bits/stdc++.h>

using std::multiset;
using std::vector;

int get_max_fraction(vector<int> weights, vector<int> values)
{
  int index(-1);
  double max_val(0.00);

  for (int i = 0; i < values.size(); i++)
  {
    if (weights[i] > 0 && (double)values[i] / weights[i] > max_val)
    {
      max_val = (double)values[i] / weights[i];
      index = i;
    }
  }

  return index;
}

double get_optimal_value(int capacity, vector<int> weights, vector<int> values)
{
  double value = 0.0;
  int n = values.size();

  for (int i = 0; i < n; i++)
  {
    if (capacity == 0)
      return value;

    int index = get_max_fraction(weights, values);


    int a = std::min(weights[index], capacity);

    value += (double)a * (double)values[index] / weights[index];


    weights[index] -= a;
    capacity -= a;
  }

  return value;
}

int main()
{
  int n;
  int capacity;
  std::cin >> n >> capacity;
  vector<int> values(n);
  vector<int> weights(n);
  for (int i = 0; i < n; i++)
  {
    std::cin >> values[i] >> weights[i];
  }

  double optimal_value = get_optimal_value(capacity, weights, values);

  std::cout.precision(10);
  std::cout << optimal_value << std::endl;
  return 0;
}
