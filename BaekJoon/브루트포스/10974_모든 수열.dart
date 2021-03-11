import 'dart:io';

main() {
  int n = int.parse(stdin.readLineSync()!);
  var sequence = List.generate(n, (index) => index + 1);

  do {
    print(sequence.sublist(0, n).map((e) => '$e ').reduce((a, b) => a + b).trim());
  } while (permutation(sequence));
}

bool permutation(List<int> sequence) {
  int i = sequence.length - 1;
  while (i > 0 && sequence[i - 1] >= sequence[i]) {
    i -= 1;
  }

  if (i <= 0) return false;

  int j = sequence.length - 1;
  while (sequence[j] <= sequence[i - 1]) {
    j -= 1;
  }

  int temp = sequence[i - 1];
  sequence[i - 1] = sequence[j];
  sequence[j] = temp;

  j = sequence.length - 1;
  while (i < j) {
    temp = sequence[i];
    sequence[i] = sequence[j];
    sequence[j] = temp;

    i++;
    j--;
  }

  return true;
}
