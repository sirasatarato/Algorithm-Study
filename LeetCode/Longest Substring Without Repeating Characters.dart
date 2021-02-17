import 'dart:math';

int lengthOfLongestSubstring(String s) {
  int n = s.length, ans = 0;
  List<int> index = List.filled(128, 0);

  for(int i = 0, j = 0; j < n; j++) {
    i = max(index[s.codeUnitAt(j)], i);
    ans = max(ans, j - i + 1);
    index[s.codeUnitAt(j)] = j + 1;
  }

  return ans;
}