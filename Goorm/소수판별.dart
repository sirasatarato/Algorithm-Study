import 'dart:io';

void main() {
  var line = int.parse(stdin.readLineSync()!);

  if(line % 2 == 0 && line != 2) {
    print('False');
    return;
  }

  for(int i = 3; i < line; i += 2) {
    if(line % i == 0) {
      print('False');
      return;
    }
  }

  print('True');
}