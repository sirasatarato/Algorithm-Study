class Solution {
  late String string;
  late List<bool> check;
  final List<int> answerSet = [];

  int solution(String numbers) {
    string = numbers;
    check = List.filled(numbers.length, false);
    permutation(0, "");
    return answerSet.length;
  }

  void permutation(int depth, String makeStr) {
    if (depth == string.length) {
      if (makeStr == "") return;
      if (isPrime(int.parse(makeStr))) answerSet.add(int.parse(makeStr));
      return;
    }

    for(var i = 0; i < string.length; i++) {
      if (!check[i]) {
        check[i] = true;
        permutation(depth + 1, makeStr + string[i]);
        check[i] = false;
        permutation(depth + 1, makeStr);
      }
    }
  }

  bool isPrime(int number) {
    if (number <= 1) return false;

    for(var i = 2; i < number - 1; i++) {
      if (number % i == 0) return false;
    }

    return true;
  }
}