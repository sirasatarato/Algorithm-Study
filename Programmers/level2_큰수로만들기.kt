fun makeBigNumber(number: String, k: Int): String {
    val stringBuilder = StringBuilder()
    var cnt: Int = number.length - k
    var idx = 0
    var left = 0
    var right: Int = number.length - cnt
    var max: Int

    while (cnt > 0) {
        max = -1
        for (j in left..right) {
            val num: Int = number.elementAt(j) - '0'
            if (num > max) {
                idx = j
                max = num
            }
        }
        stringBuilder.append(number.elementAt(idx))
        left = idx + 1
        right = number.length - --cnt
    }

    return stringBuilder.toString()
}
