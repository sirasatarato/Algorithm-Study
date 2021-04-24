import 'dart:io';

import 'dart:math';

main() {
  int x = int.parse(stdin.readLineSync()!);
  List<int> dp = List.filled(x + 1, 0);
  dp[0] = 1;

  for (int i = 2; i <= x; i++) {
    dp[i] = dp[i - 1] + 1;
    if (i % 2 == 0) dp[i] = min(dp[i], dp[i ~/ 2] + 1);
    if (i % 3 == 0) dp[i] = min(dp[i], dp[i ~/ 3] + 1);
  }

  print(dp[x]);
}