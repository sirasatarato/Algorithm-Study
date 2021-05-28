package hackerrank.string

fun superReducedString(s: String): String {
    val remains = CharArray(s.length)
    var top = -1

    for (c in s.toCharArray()) {
        if (top < 0 || c != remains[top]) {
            remains[++top] = c
        } else {
            --top
        }
    }

    return if (top < 0) "Empty String" else String(remains, 0, top + 1)
}

fun main() {
    val s = readLine()!!
    val result = superReducedString(s)
    println(result)
}