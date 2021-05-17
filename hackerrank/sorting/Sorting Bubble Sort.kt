package hackerrank.sorting

fun countSwaps(a: Array<Int>) {
    val n = a.size
    var count = 0

    for (i in 0 until n) {
        for (j in 0 until n - 1) {
            if (a[j] > a[j + 1]) {
                swap(a, j)
                count++
            }
        }
    }

    println("Array is sorted in $count swaps.")
    println("First Element: ${a[0]}")
    println("Last Element: ${a[n - 1]}")
}

fun swap(arr: Array<Int>, i: Int) {
    val temp = arr[i]
    arr[i] = arr[i + 1]
    arr[i + 1] = temp
}

fun main() {
    countSwaps(readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray())
}
