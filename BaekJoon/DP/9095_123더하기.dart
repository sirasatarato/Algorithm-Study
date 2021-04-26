import 'dart:io';

import 'dart:math';

main() {
  final int caseCount = int.parse(stdin.readLineSync()!);
  List<int> cases = List.generate(caseCount, (i) => int.parse(stdin.readLineSync()!));
  int maxOfNum = cases.reduce(max);

  List<int> numbers = List.generate(maxOfNum, (it) => pow(2, it).toInt() );
  for (int i = 3; i < numbers.length; i++) numbers[i] = numbers[i - 1] + numbers[i - 2] + numbers[i - 3];

  cases.map((e) => e - 1).forEach((e) => print(numbers[e]));
}