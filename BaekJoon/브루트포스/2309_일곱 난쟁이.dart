import 'dart:io';

main() {
  print(findDwarf(9));
}

List<int>? findDwarf(int size) {
  List<int> dwarf = List.generate(size, (index) => int.parse(stdin.readLineSync()!));
  int sum = dwarf.reduce((a, b) => a + b);

  for(int i = 0; i < size - 1; i++) {
    for(int j = i + 1; j < size; j++) {
      if(sum - dwarf[i] - dwarf[j] == 100) {
        dwarf.removeAt(i);
        dwarf.removeAt(j);
        dwarf.sort();

        return dwarf;
      }
    }
  }
}