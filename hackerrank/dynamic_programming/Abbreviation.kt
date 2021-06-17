package hackerrank.dynamic_programming

fun abbreviation(a: String, b: String): String {
    val dp = Array(a.length + 1) { BooleanArray(b.length + 1) }
    dp[0][0] = true

    for (i in 1 until a.length + 1) {
        for (j in 0 until b.length + 1) {
            if (j > 0 && dp[i - 1][j - 1] && isEqual(
                    a[i - 1],
                    b[j - 1]
                ) || Character.isLowerCase(a[i - 1]) && dp[i - 1][j]
            ) {
                dp[i][j] = true
            }
        }
    }
    return if (dp[a.length][b.length]) "YES" else "NO"
}

fun isEqual(a: Char, b: Char): Boolean {
    return a == b || Character.toUpperCase(a) == b
}

fun main() {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val a = readLine()!!
        val b = readLine()!!
        val result = abbreviation(a, b)

        println(result)
    }
}
