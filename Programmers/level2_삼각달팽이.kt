package programers

class Solution {
    fun solution(n: Int): IntArray {
        val arr = Array(n) { IntArray(n) }
        val max = getMax(n)

        for (i in 0 until n) {
            for (j in 0..i) {
                arr[i][j] = -1
            }
        }

        val answer = IntArray(max)

        var i = 0
        var j = 0
        var k = 1

        arr[i][j] = k

        while (k < max) {
            while (i + 1 < n && k < max && arr[i + 1][j] < 0) {
                arr[++i][j] = ++k
            }

            while (j + 1 < n && k < max && arr[i][j + 1] < 0) {
                arr[i][++j] = ++k
            }

            while (i - 1 > 0 && i - 1 > 0 && k < max && arr[i - 1][j - 1] < 0) {
                arr[--i][--j] = ++k
            }
        }

        k = 0

        for (i in 0 until n) {
            for (j in 0..i) {
                answer[k++] = arr[i][j]
            }
        }

        return answer
    }

    fun getMax(n: Int): Int = if(n == 1) 1 else getMax(n - 1) + n
}