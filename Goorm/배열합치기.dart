import 'dart:io';

main() {
  stdin.readLineSync();
  var A = stdin.readLineSync()!.split(' ').map((e) => int.parse(e)).toList();
  var B = stdin.readLineSync()!.split(' ').map((e) => int.parse(e)).toList();
  A.addAll(B);
  A.sort();
  print(A.join(' '));
}