import java.io.BufferedReader
import java.io.InputStreamReader

private var N = 0
private var m = 0
private lateinit var map: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().trim { it <= ' ' }.toInt()
    map = Array(N) { IntArray(N) }

    for (i in 0 until N) {
        val element = br.readLine()

        for (j in 0 until N) {
            map[i][j] = element[j].toInt() - 48
        }
    }
    divide(0, 0, N)
}

private fun check(row: Int, col: Int, n: Int): Boolean {
    val std = map[row][col]

    for (i in row until row + n) {
        for (j in col until col + n) {
            if (std != map[i][j]) {
                return false
            }
        }
    }

    m = std
    return true
}

private fun divide(row: Int, col: Int, n: Int) {
    if (check(row, col, n)) {
        print(m)
    } else {
        print("(")

        val s = n / 2
        for (i in 0..1) {
            for (j in 0..1) {
                divide(row + s * i, col + s * j, s)
            }
        }
        print(")")
    }
}