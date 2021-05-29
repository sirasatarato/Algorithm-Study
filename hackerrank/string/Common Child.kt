package hackerrank.string

fun commonChild(s1: String, s2: String): Int {
    val l = Array(s1.length + 1) { IntArray(s2.length + 1) }
    for (i in 0..s1.length) {
        for (j in 0..s2.length) {
            if (i == 0 || j == 0) l[i][j] = 0 else if (s1.elementAt(i - 1) == s2.elementAt(j - 1)) {
                l[i][j] = l[i - 1][j - 1] + 1
            } else {
                l[i][j] = Math.max(l[i - 1][j], l[i][j - 1])
            }
        }
    }
    
    return l[s1.length][s2.length]
}

fun main() {
    val s1 = readLine()!!
    val s2 = readLine()!!
    val result = commonChild(s1, s2)

    println(result)
}