package hackerrank.sorting

fun maximumToys(prices: Array<Int>, k: Int): Int {
    var sum = 0
    var count = 0

    for (i in prices.filter { it <= k }.sorted()) {
        if(sum + i > k) break
        sum += i
        count++
    }

    return count
}

fun main() {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")
    val k = firstMultipleInput[1].toInt()
    val prices = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    val result = maximumToys(prices, k)

    println(result)
}