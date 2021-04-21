package programers.exhaustiveSearch

fun solution(brown: Int, red: Int): IntArray {
    return (1..red)
        .filter { red % it == 0 }
        .first { brown == (red / it * 2) + (it * 2) + 4 }
        .let { intArrayOf(red / it + 2, it + 2) }
}