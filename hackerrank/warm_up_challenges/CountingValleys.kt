package hackerrank.warm_up_challenges

import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

/*
 * Complete the 'countingValleys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */

fun countingValleys(steps: Int, path: String): Int {
    var height = 0
    val hikes = IntArray(steps) { if (path[it] == 'U') ++height else --height }

    var count = 0
    var isValley = false
    hikes.forEach {
        if (isValley) {
            if (it >= 0) isValley = false
        } else {
            if (it < 0) {
                isValley = true
                count++
            }
        }
    }

    return count
}

fun main(args: Array<String>) {
    val steps = readLine()!!.trim().toInt()

    val path = readLine()!!

    val result = countingValleys(steps, path)

    println(result)
}
