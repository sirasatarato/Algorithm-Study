package hackerrank

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val da = scanner.nextInt()
    val ma = scanner.nextInt()
    val ya = scanner.nextInt()

    val de = scanner.nextInt()
    val me = scanner.nextInt()
    val ye = scanner.nextInt()

    println(
        if (ya > ye) 10000
        else if (ya == ye) {
            if (ma > me) (ma - me) * 500
            else if (ma == me && da > de) (da - de) * 15
            else 0
        } else 0
    )
}
