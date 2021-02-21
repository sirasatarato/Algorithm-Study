package leet

fun firstMissingPositive(nums: IntArray): Int {
    if(nums.isEmpty()) return 1

    for(i in nums.indices) {
        var num = nums[i]
        while (nums[i] in 1..nums.size && nums[num - 1] != num) {
            nums[i] = nums[num - 1]
            nums[num - 1] = num
            num = nums[i]
        }
    }

    for(i in nums.indices) {
        if (nums[i] != i + 1) return i + 1
    }

    return nums.size + 1
}