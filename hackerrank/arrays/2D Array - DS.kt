package hackerrank.arrays

import kotlin.math.max

fun hourglassSum(arr: Array<IntArray>): Int {
    val hourglass = Array(4) { Array(4) { 0 } }

    for (i in 0..3) {
        for (j in 0..3) {
            hourglass[i][j] = arr[i].slice(j..j + 2).sum() + arr[i + 1][j + 1] + arr[i + 2].slice(j..j + 2).sum()
        }
    }

    return hourglass.flatten().reduce(::max)
}

fun main() {
    val arr = Array(6) { IntArray(6) }

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toIntArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
