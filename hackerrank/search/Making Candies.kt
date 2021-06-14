package hackerrank.search

import java.math.BigInteger
import kotlin.math.min

fun minimumPasses(m: Long, w: Long, p: Long, n: Long): Long {
    if (BigInteger.valueOf(m).multiply(BigInteger.valueOf(w)) > BigInteger.valueOf(n)) return 1

    var minPass = Long.MAX_VALUE
    var currentPass = 0L
    var production = 0L
    var machine = m
    var worker = w

    while (true) {
        val remainPass = divideToCeil(n - production, machine * worker)
        minPass = min(minPass, currentPass + remainPass)

        if (remainPass == 1L) break

        if (production < p) {
            val extraPass = divideToCeil(p - production, machine * worker)
            currentPass += extraPass
            production += extraPass * machine * worker

            if (production >= n) {
                minPass = min(minPass, currentPass)
                break
            }
        }

        production -= p
        if (machine <= worker) {
            machine++
        } else {
            worker++
        }
    }

    return minPass
}

fun divideToCeil(x: Long, y: Long): Long = x / y + (if(x % y == 0L) 0L else 1L)

fun main() {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")
    val m = firstMultipleInput[0].toLong()
    val w = firstMultipleInput[1].toLong()
    val p = firstMultipleInput[2].toLong()
    val n = firstMultipleInput[3].toLong()
    val result = minimumPasses(m, w, p, n)

    println(result)
}
