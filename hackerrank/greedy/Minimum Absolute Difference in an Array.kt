package hackerrank.greedy

import kotlin.math.abs

fun minimumAbsoluteDifference(arr: Array<Int>): Int {
    var min = Int.MAX_VALUE

    arr.sort()

    for (i in 0 until arr.size - 1) {
        val currentMin: Int = abs(arr[i] - arr[i + 1])
        min = min.coerceAtMost(currentMin)
    }

    return min
}

fun main() {
    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    val result = minimumAbsoluteDifference(arr)

    println(result)
}
