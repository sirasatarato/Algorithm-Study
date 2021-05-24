package hackerrank.string

fun alternatingCharacters(s: String): Int {
    var count = 0

    s.reduce { a, b ->
        if(a == b) count++
        b
    }

    return count
}

fun main() {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!
        val result = alternatingCharacters(s)

        println(result)
    }
}
