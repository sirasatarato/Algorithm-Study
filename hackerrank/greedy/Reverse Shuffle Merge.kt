package hackerrank.greedy

import java.util.*

fun reverseShuffleMerge(s: String): String {
    val addCnt = IntArray(26)
    val st = Stack<Char>()
    var rslt = ""
    
    for (i in s.indices) addCnt[s[i] - 'a']++
    for (i in addCnt.indices) addCnt[i] /= 2

    val skipCnt = addCnt.clone()
    for (i in s.indices.reversed()) {
        while (!st.empty() && st.peek() > s[i] && addCnt[s[i] - 'a'] > 0 && skipCnt[st.peek() - 'a'] > 0) {
            val c = st.pop()
            addCnt[c - 'a']++
            skipCnt[c - 'a']--
        }
        if (addCnt[s[i] - 'a'] > 0) {
            st.push(s[i])
            addCnt[s[i] - 'a']--
        } else {
            skipCnt[s[i] - 'a']--
        }
    }

    while (!st.empty()) rslt = st.pop().toString() + rslt

    return rslt
}

fun main() {
    val s = readLine()!!
    val result = reverseShuffleMerge(s)
    println(result)
}
