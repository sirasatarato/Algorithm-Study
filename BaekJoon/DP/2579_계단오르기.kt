package baekjoon

import java.lang.Integer.max
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val cost = IntArray(n + 1)
    val dp = IntArray(n + 1)

    for(i in 1..n) cost[i] = scanner.nextInt()

    dp[1] = cost[1]
    if (n >= 2) dp[2] = cost[1] + cost[2]

    for (i in 3..n) {
        dp[i] = max(dp[i - 2] , dp[i - 3] + cost[i - 1]) + cost[i]
    }

    println(dp[n])
}