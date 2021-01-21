fun findKthLargest(nums: IntArray, k: Int): Int {
    nums.sortDescending()
    return nums[k - 1]
}

fun main() {
    print(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}