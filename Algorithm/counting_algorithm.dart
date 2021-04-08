import 'dart:io';
import 'dart:math';

main() {
  var inputData = stdin.readLineSync()!.split(' ').map((e) => int.parse(e)).toList();
  var bucket = List<int>.filled(inputData.reduce(max) + 1, 0);
  var sorted = List<int>.filled(inputData.length, 0);

  inputData.forEach((item) {
    bucket[item]++;
  });

  for (var i = 1; i < bucket.length; i++) {
    bucket[i] += bucket[i - 1];
  }

  inputData.forEach((item) {
    sorted[--bucket[item]] = item;
  });

  return sorted;
}
