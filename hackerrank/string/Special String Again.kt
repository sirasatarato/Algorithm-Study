package hackerrank.string

import kotlin.math.min

fun substrCount(n: Int, s: String): Long {
    val arr = s.toCharArray()
    val list: MutableList<Pair<Char, Int>> = ArrayList()
    var cur = arr[0]
    var cnt = 1

    for (i in 1 until n) {
        if (arr[i] == cur) {
            cnt++
        } else {
            list.add(Pair(cur, cnt))
            cnt = 1
        }

        cur = arr[i]
    }
    list.add(Pair(cur, cnt))

    var rslt = 0
    for (i in list.indices) {
        val v: Int = list[i].second
        rslt += v * (v + 1) / 2
    }

    for (i in 1 until list.size - 1) {
        if (list[i - 1].first == list[i + 1].first && list[i].second == 1) {
            rslt += min(list[i - 1].second, list[i + 1].second)
        }
    }
    return rslt.toLong()
}

fun main() {
    val n = readLine()!!.trim().toInt()
    val s = readLine()!!

    println(substrCount(n, s))
}
