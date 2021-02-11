package leet

fun isMatch(s: String, p: String): Boolean {
    val m = s.length
    val n = p.length
    val match = Array(m + 1) { BooleanArray(n + 1) }
    match[0][0] = true

    for(i in 1..n) {
        if(p.elementAt(i - 1) == '*') {
            match[0][i] = true
        } else {
            break
        }
    }

    for (i in 1..m) {
        for(j in 1..n) {
            if(p.elementAt(j - 1) != '*') {
                match[i][j] = match[i - 1][j - 1] && (s.elementAt(i - 1) == p.elementAt(j - 1) || p.elementAt(j - 1) == '?')
            } else {
                match[i][j] = match[i][j - 1] || match[i - 1][j]
            }
        }
    }

    return match[m][n]
}
