import 'dart:io';

main() {
  int sugar = int.parse(stdin.readLineSync()!);
  int count = 0;

  while (true) {
    if(sugar == 0) break;

    if(sugar % 5 == 0) {
      sugar -= 5;
    } else if(sugar % 3 == 0) {
      sugar -= 3;
    } else if(sugar > 5) {
      sugar -= 5;
    } else {
      count = -1;
      break;
    }

    count++;
  }

  print(count);
}