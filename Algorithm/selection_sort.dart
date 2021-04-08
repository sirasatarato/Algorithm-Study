main() => print(selectionSort([5, 1, 9, 3, 2, 4]));

List selectionSort(List<int> list) {
  int min;

  for (int i = 0; i < list.length - 1; i++) {
    min = i;

    for (int j = i + 1; j < list.length; j++) {
      if (list[min] > list[j]) {
        min = j;
      }
    }

    swap(list, i, min);
  }

  return list;
}

void swap(List list, int i, int j) {
  int temp = list[i];
  list[i] = list[j];
  list[j] = temp;
}
