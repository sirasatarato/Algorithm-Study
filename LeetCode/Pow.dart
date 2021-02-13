double myPow(double x, int n) {
  if(n < 0) {
    x = 1 / x;
    n = -n;
  }

  double ans = 1;
  double current = x;
  for(int i = n; i != 0; i = i ~/ 2) {
    if((i % 2) == 1) ans *= current;

    current *= current;
  }

  return ans;
}