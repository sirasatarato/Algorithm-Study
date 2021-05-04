package hackerrank.warm_up_challenges

fun jumpingOnClouds(c: Array<Int>): Int {
    var count = 0
    var currentIndex = 0

    while (currentIndex != c.lastIndex) {
        if (currentIndex + 2 <= c.lastIndex && c[currentIndex + 2] == 0) currentIndex++

        currentIndex++
        count++
    }

    return count
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()
    val c = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    val result = jumpingOnClouds(c)

    println(result)
}
