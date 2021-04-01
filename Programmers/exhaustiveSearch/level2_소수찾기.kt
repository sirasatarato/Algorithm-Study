package programers.exhaustiveSearch

class Solution {
    lateinit var string: String
    lateinit var check: BooleanArray
    private val answerSet = mutableSetOf<Int>()

    fun solution(numbers: String): Int {
        string = numbers
        check = BooleanArray(string.length)
        permutation(0, "")
        return answerSet.size
    }

    private fun permutation(depth: Int, makeStr: String) {
        if (depth == string.length) {
            if (makeStr == "") return
            if (isPrime(makeStr.toInt())) answerSet.add(makeStr.toInt())
            return
        }

        for (i in string.indices) {
            if (!check[i]) {
                check[i] = true
                permutation(depth + 1, makeStr + string[i])
                check[i] = false
                permutation(depth + 1, makeStr)
            }
        }
    }

    private fun isPrime(number: Int): Boolean {
        if (number <= 1) return false

        for (i in 2..number - 2) {
            if (number % i == 0) {
                return false
            }
        }

        return true
    }
}