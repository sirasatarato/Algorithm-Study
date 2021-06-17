package hackerrank.dynamic_programming

import kotlin.math.max

fun candies(arr: Array<Int>): Long {
    var sum: Long = 0
    val dpUp = IntArray(arr.size) { 1 }
    val dpDown = IntArray(arr.size) { 1 }

    for (i in 1 until arr.size) {
        if (arr[i - 1] < arr[i]) dpUp[i] = dpUp[i - 1] + 1
    }

    for (i in arr.size - 2 downTo 0) {
        if (arr[i + 1] < arr[i]) dpDown[i] = dpDown[i + 1] + 1
    }

    for (i in arr.indices) {
        sum += max(dpUp[i], dpDown[i]).toLong()
    }

    return sum
}

fun main() {
    val n = readLine()!!.trim().toInt()
    val arr = Array(n) { 0 }

    for (i in 0 until n) {
        val arrItem = readLine()!!.trim().toInt()
        arr[i] = arrItem
    }

    println(candies(arr))
}
