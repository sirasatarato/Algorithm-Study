List<int> grayCode(int n) {
  List<int> results = [0];

  for(int i = 0; i < n; i++) {
    int inc = 1 << i;
    for(int j = results.length - 1; j >= 0; j--) {
      results.add(results[j] + inc);
    }
  }

  return results;
}