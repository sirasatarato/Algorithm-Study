package programers.sort

fun solution(citations: IntArray): Int {
    var result = 0
    val sortedList = citations.sortedDescending()

    for (i in 0..(citations.max() ?: 0)) {
        val index = sortedList.indexOfLast { it >= i } + 1
        if (index > result) result = i
    }

    return result
}