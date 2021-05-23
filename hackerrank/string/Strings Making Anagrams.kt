package hackerrank.string

import kotlin.math.abs

fun makeAnagram(a: String, b: String): Int {
    if (a.isEmpty()) return b.length
    if (b.isEmpty()) return a.length

    val firstChars: CharArray = a.toCharArray()
    val secondChars: CharArray = b.toCharArray()
    val firstHelper = IntArray(26)
    val secondHelper = IntArray(26)
    val aVal = 'a'.toInt()
    var sum = 0

    firstChars.forEach { firstHelper[it.toInt() - aVal]++ }
    secondChars.forEach { secondHelper[it.toInt() - aVal]++ }

    for (i in 0..25) {
        if (firstHelper[i] != secondHelper[i]) sum += abs(firstHelper[i] - secondHelper[i])
    }

    return sum
}

fun main() {
    val a = readLine()!!

    val b = readLine()!!

    val res = makeAnagram(a, b)

    println(res)
}
