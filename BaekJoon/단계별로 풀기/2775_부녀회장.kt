import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val apt = Array(15) { IntArray(15) }
    for (i in 0..14) {
        apt[i][1] = 1
        apt[0][i] = i
    }

    for (i in 1..14) {
        for (j in 2..14) {
            apt[i][j] = apt[i][j - 1] + apt[i - 1][j]
        }
    }

    for (i in 0 until scanner.nextInt()) {
        val k = scanner.nextInt()
        val n = scanner.nextInt()
        println(apt[k][n])
    }
}
