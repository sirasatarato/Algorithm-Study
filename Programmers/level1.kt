class Solution {
    fun solution(s: String): String {
        val characters = s.toCharArray()
        characters.sort()
        var answer = ""
        for(c in characters.toList().asReversed()) {
            answer += c
        }
        return answer
    }
}

class Solution {
    fun solution(x: Int, n: Int): LongArray {
        val answer = mutableListOf(x.toLong())
        for (i in 2..n) {
            answer.add(i - 1, answer.first() * i)
        }

        return answer.toLongArray()
    }
}