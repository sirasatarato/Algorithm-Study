package hackerrank

import java.util.*

fun bubbleSort(arr: IntArray): Int {
    var count = 0
    var swap = true

    while (swap) {
        swap = false
        for (i in 0 until arr.size - 1) {
            if (arr[i] > arr[i + 1]) {
                val temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp
                count++

                swap = true
            }
        }
    }
    return count
}

fun main() {
    val scanner = Scanner(System.`in`)
    val intArray = IntArray(scanner.nextInt()) { scanner.nextInt() }
    val count = bubbleSort(intArray)

    println("Array is sorted in $count swaps.")
    println("First Element: ${intArray.first()}")
    println("Last Element: ${intArray.last()}")
}