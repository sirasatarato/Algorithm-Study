package hackerrank.sorting

fun countInversions(arr: Array<Int>): Long {
    if (arr.size <= 1) return 0

    val n: Int = arr.size
    val mid = n shr 1
    val left: Array<Int> = arr.copyOfRange(0, mid)
    val right: Array<Int> = arr.copyOfRange(mid, n)
    var inversions = countInversions(left) + countInversions(right)

    val range = n - mid
    var iLeft = 0
    var iRight = 0

    for (i in 0 until n) {
        if (iLeft < mid && (iRight >= range || left[iLeft] <= right[iRight])) {
            arr[i] = left[iLeft++]
            inversions += iRight.toLong()
        } else if (iRight < range) {
            arr[i] = right[iRight++]
        }
    }

    return inversions
}

fun main() {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        val result = countInversions(arr)

        println(result)
    }
}
