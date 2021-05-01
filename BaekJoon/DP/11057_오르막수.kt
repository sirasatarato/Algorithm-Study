package baekjoon

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val d = Array(n + 1) { IntArray(10) }

    for (i in 0..9) d[1][i] = 1

    for (i in 2..n) {
        for (j in 0..9) {
            for (k in j..9) d[i][j] += d[i - 1][k] % 10007
        }
    }

    var sum = 0
    for (i in 0..9) {
        sum += d[n][i]
        sum %= 10007
    }

    println(sum)
}