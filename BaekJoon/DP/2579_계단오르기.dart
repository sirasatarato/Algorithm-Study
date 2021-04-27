import 'dart:io';

import 'dart:math';

void main() {
  var n = int.parse(stdin.readLineSync()!);
  var cost = List.filled(n + 1, 0);
  var dp = List.filled(n + 1, 0);

  for(var i = 1; i <= n; i++) cost[i] = int.parse(stdin.readLineSync()!);

  dp[1] = cost[1];
  if (n >= 2) dp[2] = cost[1] + cost[2];

  for (var i = 3; i <= n; i++) {
    dp[i] = max(dp[i - 2] , dp[i - 3] + cost[i - 1]) + cost[i];
  }

  print(dp[n]);
}