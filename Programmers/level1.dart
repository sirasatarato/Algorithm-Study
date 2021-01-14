class Solution {
  String solution(String s) {
    List<int> characters =
    s.split('').map((title) => title.codeUnitAt(0)).toList();
    characters.sort();
    characters = characters.reversed.toList();
    String answer = '';

    for(var i = 0; i <= s.length - 1; i++) {
      answer += String.fromCharCode(characters[i]);
    }
    return answer;
  }
}

class Solution {
  List<num> solution(int x, int n) {
    List<num> answer = [x];
    for (var i = 2; i <= n; i++) {
      answer.add(answer.first * i);
    }

    return answer;
  }
}