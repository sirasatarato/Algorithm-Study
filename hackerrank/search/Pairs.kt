package hackerrank.search

fun pairs(k: Int, arr: Array<Int>): Int {
    val map = HashMap<Int, Int>()
    var count = 0

    arr.forEach { if (map.containsKey(it)) map[it]?.plus(1) else map[it] = 1 }
    map.forEach { if(map.containsKey(it.key + k)) count++ }

    return count
}

fun main() {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")
    val k = firstMultipleInput[1].toInt()
    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    val result = pairs(k, arr)

    println(result)
}
