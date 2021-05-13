package hackerrank.dictionaries_and_hashmaps

import java.util.regex.Pattern

fun twoStrings(s1: String, s2: String): String = if (Pattern.compile("[$s2]").matcher(s1).find()) "YES" else "NO"

fun main() {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s1 = readLine()!!

        val s2 = readLine()!!

        val result = twoStrings(s1, s2)

        println(result)
    }
}
