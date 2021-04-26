import 'dart:io';

import 'dart:math';

main() {
  final int T = int.parse(stdin.readLineSync()!);
  final input = List.generate(T, (_) => int.parse(stdin.readLineSync()!));
  final int maxNumber = input.reduce(max);
  var testCase = List.generate(maxNumber + 1, (_) => List.filled(2, 0));
  testCase[0][0] = 1;
  testCase[1][1] = 1;

  for (var i = 2; i <= maxNumber; i++) {
    testCase[i][0] = testCase[i - 1][0] + testCase[i - 2][0];
    testCase[i][1] = testCase[i - 1][1] + testCase[i - 2][1];
  }

  input.forEach((i) {
    print('${testCase[i][0]} ${testCase[i][1]}');
  });
}
