package hackerrank.dictionaries_and_hashmaps

fun countTriplets(arr: Array<Long>, r: Long): Long {
    val leftMap: MutableMap<Long, Long> = HashMap()
    val rightMap: MutableMap<Long, Long> = HashMap()

    arr.forEach {
        rightMap[it] = rightMap.getOrDefault(it, 0L) + 1
    }

    var count: Long = 0
    for (element in arr) {
        var c1: Long = 0
        var c3: Long = 0
        rightMap[element] = rightMap.getOrDefault(element, 0L) - 1

        if (leftMap.containsKey(element / r) && element % r == 0L) c1 = leftMap[element / r]!!
        if (rightMap.containsKey(element * r)) c3 = rightMap[element * r]!!

        count += c1 * c3
        leftMap[element] = leftMap.getOrDefault(element, 0L) + 1
    }

    return count
}

fun main() {
    val nr = readLine()!!.trimEnd().split(" ")
    val r = nr[1].toLong()
    val arr = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()
    val ans = countTriplets(arr, r)

    println(ans)
}
