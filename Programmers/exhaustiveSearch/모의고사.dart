import 'dart:math';

List<int> solution(List<int> answers) {
  var score = [0, 0, 0];
  var person1 = [1, 2, 3, 4, 5];
  var person2 = [2, 1, 2, 3, 2, 4, 2, 5];
  var person3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

  for(int i = 0; i < answers.length; i++) {
    if (answers[i] == person1[i % 5]) {
      score[0]++;
    }

    if (answers[i] == person2[i % 8]) {
      score[1]++;
    }

    if (answers[i] == person3[i % 10]) {
      score[2]++;
    }
  }

  int maxScore = max(score[0], max(score[1], score[2]));
  List<int> result = [];

  for(int i = 0; i <= 2; i++) {
    if (score[i] == maxScore) {
      result.add(i + 1);
    }
  }

  return result;
}