fun twoSum(nums: IntArray, target: Int): IntArray {
    val answer = IntArray(2)

    for (i in nums) {
        if ((target - i) in nums) {
            answer[0] = nums.indexOf(i)

            if (i * 2 == target) {
                val index = nums.indexOf(i)
                answer[1] = nums.slice(index + 1 until nums.size).indexOf(i) + index + 1
            } else {
                answer[1] = nums.indexOf(target - i)
            }
        }
    }

    return answer
}