package hackerrank.dictionaries_and_hashmaps


fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val freqes: MutableMap<Int, Int> = HashMap()
    val qts = IntArray(queries.size + 1)
    val result: MutableList<Int> = ArrayList()
    var freq: Int
    var cmd: Int
    var v: Int

    for (query in queries) {
        cmd = query[0]
        v = query[1]
        if (cmd == 1) {
            freq = freqes.getOrDefault(v, 0)
            freqes[v] = freq + 1
            qts[freq]--
            qts[freq + 1]++
        } else if (cmd == 2) {
            freq = freqes.getOrDefault(v, 0)
            if (freq > 0) {
                freqes[v] = freq - 1
                qts[freq]--
                qts[freq - 1]++
            }
        } else if (cmd == 3) {
            if (v > qts.size) result.add(0) else result.add(if (qts[v] > 0) 1 else 0)
        }
    }
    return result.toTypedArray()
}

fun main() {
    val q = readLine()!!.trim().toInt()
    val queries = Array(q) { Array(2) { 0 } }

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val ans = freqQuery(queries)

    println(ans.joinToString("\n"))
}
