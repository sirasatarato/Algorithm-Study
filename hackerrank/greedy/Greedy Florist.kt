package hackerrank.greedy

import java.util.*

fun getMinimumCost(k: Int, c: Array<Int>): Int {
    val friends = IntArray(k) { c.size / k }

    for (i in 0 until c.size % k) friends[i] += 1
    c.sort()

    var sum = 0
    var idx = 0

    while (idx < c.size) {
        for (j in 0 until k) {
            if (friends[j] > 0) sum += (--friends[j] + 1) * c[idx++]
        }

    }
    return sum
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val minimumCost = getMinimumCost(k, c)

    println(minimumCost)
}