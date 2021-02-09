package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.Arrays

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine(), " ")
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val memories = IntArray(N)
    val costs = IntArray(N)

    st = StringTokenizer(br.readLine(), " ")
    for (i in 0 until N) memories[i] = st.nextToken().toInt()
    st = StringTokenizer(br.readLine(), " ")
    for (i in 0 until N) costs[i] = st.nextToken().toInt()

    val dp = IntArray(10001)
    Arrays.fill(dp, -1)

    for (i in 0 until N) {
        val cost = costs[i]

        for (j in 10000 downTo cost) {
            if (dp[j - cost] != -1 && dp[j - cost] + memories[i] > dp[j]) {
                dp[j] = dp[j - cost] + memories[i]
            }
        }

        if (dp[cost] < memories[i]) dp[cost] = memories[i]
    }

    for (i in 0..10000) {
        if (dp[i] >= M) {
            println(i)
            break
        }
    }
}