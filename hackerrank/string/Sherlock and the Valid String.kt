package hackerrank.string

import kotlin.math.abs

fun isValid(s: String): String {
    val map: MutableMap<Char, Int> = HashMap()
    s.forEach {
        map.putIfAbsent(it, 0)
        map.computeIfPresent(it) { _, v: Int -> v + 1 }
    }

    val map2: MutableMap<Int, Int> = HashMap()
    map.values.forEach {
        map2.putIfAbsent(it, 0)
        map2.computeIfPresent(it) { _, v: Int -> v + 1 }
    }

    val keys: List<Int> = map2.keys.toList()
    val values: List<Int> = map2.values.toList()

    if (values.size == 1) return "YES"
    if (values.size == 2) {
        var oneValueKey = 0
        for (i in values.indices) if (values[i] == 1) oneValueKey = keys[i]
        if (values.contains(1) && (abs(keys[0] - keys[1]) == 1 || oneValueKey == 1)) return "YES"
    }

    return "NO"
}

fun main() {
    val s = readLine()!!
    val result = isValid(s)

    println(result)
}
