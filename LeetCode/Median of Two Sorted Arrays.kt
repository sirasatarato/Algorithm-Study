fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val sumNums = nums1 + nums2
    val size = sumNums.size
    sumNums.sort()

    return if (size % 2 == 0) {
        val mid = (size / 2 - 0.5).toInt()
        (sumNums[mid] + sumNums[mid + 1]) / 2.0
    } else {
        sumNums[size / 2].toDouble()
    }
}