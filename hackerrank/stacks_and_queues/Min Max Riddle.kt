package hackerrank.stacks_and_queues

import java.util.*
import kotlin.math.max

fun riddle(arr: Array<Long>): Array<Long> {
    val lefts = winSize(arr.toLongArray(), true)
    val rights = winSize(arr.toLongArray(), false)
    val numberToWinSize: SortedMap<Int, Int> = TreeMap(Collections.reverseOrder())

    for (i in arr.indices) {
        numberToWinSize[arr[i].toInt()] =
            max(numberToWinSize.getOrDefault(arr[i].toInt(), -1), lefts[i].toInt() + rights[i].toInt() + 1)
    }

    val iter: Iterator<Int> = numberToWinSize.keys.iterator()
    var number = iter.next()
    val result = LongArray(arr.size)

    for (i in result.indices) {
        while (numberToWinSize[number]!! <= i) {
            number = iter.next()
        }

        result[i] = number.toLong()
    }

    return result.toTypedArray()
}

fun winSize(arr: LongArray, isLeft: Boolean): LongArray {
    val results = LongArray(arr.size)
    val indices = Stack<Int>()

    for (i in if (isLeft) arr.indices else arr.indices.reversed()) {
        while (!indices.isEmpty() && arr[i] <= arr[indices.peek()]) {
            indices.pop()
        }

        if (isLeft) {
            results[i] = (i - if (indices.isEmpty()) 0 else indices.peek() + 1).toLong()
        } else {
            results[i] = ((if (indices.isEmpty()) arr.size else indices.peek()) - i - 1).toLong()
        }

        indices.push(i)
    }

    return results
}

fun main() {
    val arr = readLine()!!.split(" ").map { it.trim().toLong() }.toTypedArray()
    val res = riddle(arr)

    println(res.joinToString(" "))
}
