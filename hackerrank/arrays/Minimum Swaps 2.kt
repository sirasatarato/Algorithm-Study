package hackerrank.arrays

import java.util.*

fun minimumSwaps(arr: Array<Int>): Int {
    var count = 0
    var i = 0

    while (i < arr.size) {
        if (arr[i] == i + 1) {
            i++
            continue
        }

        val tmp = arr[i]
        arr[i] = arr[tmp - 1]
        arr[tmp - 1] = tmp
        count++
    }

    return count
}

fun main() {
    val scan = Scanner(System.`in`)
    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    val res = minimumSwaps(arr)

    println(res)
}
