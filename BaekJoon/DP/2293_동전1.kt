package baekjoon

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()
    val k = scanner.nextInt()
    val dp = IntArray(k + 1)
    val coins = IntArray(n) { scanner.nextInt() }

    dp[0] = 1

    for (i in 0 until n) {
        for (j in 1..k) {
            if (j - coins[i] >= 0) {
                dp[j] += dp[j - coins[i]]
            }
        }
    }

    print(dp[k])
}

/*
* 3 10
* 1
* 2
* 5
* */

/*
* 1 1 1 1 1 1 1 1 1 1
* 1 1 1 1 1 1 1 1 2
* 1 1 1 1 1 1 2 2
* 1 1 1 1 2 2 2
* 1 1 2 2 2 2
* 2 2 2 2 2
* 1 1 1 1 1 5
* 1 1 1 2 5
* 1 2 2 5
* 5 5
* */