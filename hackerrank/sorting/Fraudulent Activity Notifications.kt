package hackerrank.sorting

fun calMedian(tmpArr: IntArray, d: Int): Double {
    var count = 0
    var result = 0.0

    if (d % 2 != 0) {
        for (i in tmpArr.indices) {
            count += tmpArr[i]

            if (count > d / 2) {
                result = i.toDouble()
                break
            }
        }
    } else {
        var ftmpC = 0
        var stmpC = 0

        for (i in tmpArr.indices) {
            count += tmpArr[i]

            if (ftmpC == 0 && count >= d / 2) ftmpC = i
            if (stmpC == 0 && count >= d / 2 + 1) {
                stmpC = i
                break
            }
        }

        result = (ftmpC + stmpC) / 2.0
    }

    return result
}

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var count = 0
    val tmpArr = IntArray(201)
    for (i in 0 until d) tmpArr[expenditure[i]]++

    for (i in d until expenditure.size) {
        val median = calMedian(tmpArr, d)

        if (median * 2 <= expenditure[i]) count++
        tmpArr[expenditure[i - d]]--
        tmpArr[expenditure[i]]++
    }

    return count
}

fun main() {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")
    val d = firstMultipleInput[1].toInt()
    val expenditure = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    val result = activityNotifications(expenditure, d)

    println(result)
}
