package hackerrank.dynamic_programming

import java.util.*
import kotlin.math.max

fun maxSubsetSum(arr: Array<Int>): Int {
    if (arr.size == 1) return arr.single()

    val dp = IntArray(arr.size)
    dp[0] = arr[0]
    dp[1] = max(arr[0], arr[1])

    for (i in 2 until arr.size) {
        dp[i] = maxOf(arr[i], dp[i - 1], dp[i - 2] + arr[i])
    }

    return dp.last()
}

fun main() {
    val scan = Scanner(System.`in`)
    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    val res = maxSubsetSum(arr)

    println(res)
}
