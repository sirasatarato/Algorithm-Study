package hackerrank

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    val arr = Array(6) { IntArray(6) }
    var maxNumber = Int.MIN_VALUE

    for (i in 0 until 6) arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toIntArray()

    for(i in 0 until 4) {
        for(j in 0 until 4) {
            val sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]
            if (maxNumber < sum) maxNumber = sum
        }
    }

    print(maxNumber)
}