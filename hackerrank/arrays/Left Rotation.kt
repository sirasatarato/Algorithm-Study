package hackerrank.arrays

fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    val rotArr = Array(a.size) { 0 }
    val count = a.size - d

    for (i in a.indices) rotArr[(i + count) % a.size] = a[i]

    return rotArr
}

fun main(args: Array<String>) {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")

    val n = firstMultipleInput[0].toInt()

    val d = firstMultipleInput[1].toInt()

    val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}
