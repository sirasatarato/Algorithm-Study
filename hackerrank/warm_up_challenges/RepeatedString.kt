package hackerrank.warm_up_challenges

fun repeatedString(s: String, n: Long): Long {
    val lastForN = n % s.length
    var numberOfRepetitions = n / s.length
    if (n % s.length != 0L) numberOfRepetitions++

    val numberOfAs = s.filter { it == 'a' }.length
    var occurrences = numberOfAs * numberOfRepetitions

    if (lastForN != 0L) {
        occurrences -= numberOfAs
        occurrences += IntRange(0, lastForN.toInt() - 1).filter { s[it] == 'a' }.size
    }

    return occurrences
}

fun main() {
    val s = readLine()!!
    val n = readLine()!!.trim().toLong()
    val result = repeatedString(s, n)

    println(result)
}
