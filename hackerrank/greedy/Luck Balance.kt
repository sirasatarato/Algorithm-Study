package hackerrank.greedy

import java.util.*

fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
    var maxLuck = 0
    var important = 0

    val luckList: MutableList<Int> = ArrayList()

    for (i in contests.indices) {
        if (contests[i][1] == 1) {
            important++
            luckList.add(contests[i][0])
        } else {
            maxLuck += contests[i][0]
        }
    }

    luckList.sort()

    for (i in 0 until important - k) maxLuck -= luckList.removeAt(0)
    for (i in luckList.indices) maxLuck += luckList[i]

    return maxLuck
}

fun main() {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")

    val n = firstMultipleInput[0].toInt()

    val k = firstMultipleInput[1].toInt()

    val contests = Array(n) { Array(2) { 0 } }

    for (i in 0 until n) {
        contests[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = luckBalance(k, contests)

    println(result)
}
