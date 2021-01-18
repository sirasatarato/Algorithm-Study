class Solution {
    fun isPalindrome(x: Int) = x.toString() == x.toString().reversed()
}

fun main() {
    println(Solution().isPalindrome(121))
}