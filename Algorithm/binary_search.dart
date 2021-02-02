class BinarySearch {
  static void binarySearch(int target, List<int> list) {
    int mid;
    int left = 0;
    int right = list.length - 1;

    while (right >= left) {
      mid = (right + left) ~/ 2;

      if (target == list[mid]) {
        print("$target is in the array with index value: $mid");
        break;
      }

      if (target < list[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
  }
}

void main() {
  List<int> list = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  BinarySearch.binarySearch(2, list);
}
