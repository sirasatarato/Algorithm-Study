package programers.sort

class Solution {
    fun solution(numbers: IntArray): String {
        if (numbers.sum() == 0) return "0"

        return numbers.map { it.toString() }.sortedWith(Comparator { a, b ->
            return@Comparator (b + a).toInt() - (a + b).toInt()
        }).reduce { acc, s -> acc + s }
    }
}