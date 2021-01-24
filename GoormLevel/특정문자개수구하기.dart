import 'dart:io';
void main() {
  String line = stdin.readLineSync()!;
  String target = stdin.readLineSync()!;
  print(target.allMatches(line).length);
}