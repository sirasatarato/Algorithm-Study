package hackerrank.dictionaries_and_hashmaps

import java.util.*

fun sherlockAndAnagrams(s: String): Int {
    val map = HashMap<String, Int>()

    for (i in s.indices) {
        for (j in i until s.length) {
            val key = s.substring(i, j + 1).toCharArray().sorted().joinToString()
            map[key] = if (map.containsKey(key)) map[key]!! + 1 else 1
        }
    }

    var anagramPairCount = 0
    for (key in map.keys) {
        val n = map[key]!!
        anagramPairCount += n * (n - 1) / 2
    }

    return anagramPairCount
}

fun main() {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!
        val result = sherlockAndAnagrams(s)

        println(result)
    }
}
