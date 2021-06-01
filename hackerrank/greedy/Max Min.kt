package hackerrank.greedy

import kotlin.math.min

fun maxMin(k: Int, arr: Array<Int>): Int {
    arr.sort()

    var min = Int.MAX_VALUE

    for (i in 0..arr.size - k) min = min(min, arr[k + i - 1] - arr[i])
    return min
}

fun main() {
    val n = readLine()!!.trim().toInt()
    val k = readLine()!!.trim().toInt()
    val arr = Array(n) { 0 }

    for (i in 0 until n) {
        val arrItem = readLine()!!.trim().toInt()
        arr[i] = arrItem
    }

    val result = maxMin(k, arr)

    println(result)
}
