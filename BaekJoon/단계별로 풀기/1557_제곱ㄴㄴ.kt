package baekjoon

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlin.math.sqrt


private const val MAX = 42000
private var mobiusFunction: IntArray = intArrayOf()

fun main() {
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val K = br.readLine().toInt()
        mobiusFunction = IntArray(MAX + 1)
        mobiusFunctionList
        var left: Long = 0
        var right: Long = 1700000000
        while (true) {
            val mid = (left + right) / 2
            if (getCountOfSquareFreeNumber(mid) < K) {
                left = mid
            } else if (getCountOfSquareFreeNumber(mid) > K) {
                right = mid
            } else {
                right = if (isMultipleOfSquareNumber(mid)) {
                    mid
                } else {
                    println(mid)
                    break
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
        println(e.message)
    }
}

val mobiusFunctionList: Unit
    get() {
        mobiusFunction[1] = 1
        for (i in 1..MAX) {
            var j = 2 * i
            while (j <= MAX) {
                mobiusFunction[j] -= mobiusFunction[i]
                j += i
            }
        }
    }

fun getCountOfSquareFreeNumber(x: Long): Int {
    var countOfSquareFreeNumber = 0
    var i = 1
    while (i <= sqrt(x.toDouble())) {
        countOfSquareFreeNumber += (x / (i * i) * mobiusFunction[i]).toInt()
        i++
    }
    return countOfSquareFreeNumber
}

fun isMultipleOfSquareNumber(x: Long): Boolean {
    var i = 2
    while (i <= sqrt(x.toDouble())) {
        if (x % (i * i) == 0L) {
            return true
        }
        i++
    }
    return false
}