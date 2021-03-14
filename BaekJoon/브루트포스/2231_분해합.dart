import 'dart:io';

main() {
  int n = int.parse(stdin.readLineSync()!);

  var result = List.generate(n, (index) => index + 1).firstWhere((element) {
    var digits = element.toString().split('').map((e) => int.parse(e));
    int sum = element + digits.reduce((a, b) => a + b);
    return sum == n;
  });

  print(result);
}