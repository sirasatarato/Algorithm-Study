package hackerrank.search

import java.util.*
import kotlin.math.max

fun maximumSum(a: Array<Long>, m: Long): Long {
    val sums = LongArray(a.size)
    var s: Long = 0

    for (i in sums.indices) {
        s = addMod(s, a[i], m)
        sums[i] = s
    }

    var result = Arrays.stream(sums).max().asLong
    val sortedSums: NavigableSet<Long> = TreeSet()

    for (sum in sums) {
        val higher = sortedSums.higher(sum)
        if (higher != null) result = max(result, addMod(sum, -higher, m))
        sortedSums.add(sum)
    }

    return result
}

fun addMod(x: Long, y: Long, modulus: Long): Long = ((x + y) % modulus + modulus) % modulus

fun main() {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val firstMultipleInput = readLine()!!.trimEnd().split(" ")
        val m = firstMultipleInput[1].toLong()
        val a = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()
        val result = maximumSum(a, m)

        println(result)
    }
}
