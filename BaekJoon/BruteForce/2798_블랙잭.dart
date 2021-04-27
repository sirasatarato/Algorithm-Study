import 'dart:io';

main() {
  var firstLine = readIntList();
  var N = firstLine[0];
  var M = firstLine[1];
  List<int> nums = readIntList().take(firstLine[0]).toList();

  print(search(nums, N, M));
}

int search(List<int> nums, int N, int M) {
  int result = 0;
  for (int i = 0; i < N - 2; i++) {
    for (int j = i + 1; j < N - 1; j++) {
      for (int k = j + 1; k < N; k++) {
        int temp = nums[i] + nums[j] + nums[k];

        if (M == temp) return temp;

        if (result < temp && temp < M) result = temp;
      }
    }
  }

  return result;
}

List<int> readIntList() =>
    stdin.readLineSync()!.split(' ').map((e) => int.parse(e)).toList();
