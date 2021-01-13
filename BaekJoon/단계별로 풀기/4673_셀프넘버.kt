fun main() {
    val list = MutableList(10000) { it }

    for (i in list.toList()) {
        val element = getUnSelfNumber(i)
        if(element < 10000) {
            list.remove(element)
        }
    }

    list.forEach(::println)
}

fun getUnSelfNumber(num: Int): Int {
    var sum = 0
    var copyNum = num

    while (copyNum > 0) {
        sum += copyNum % 10
        copyNum /= 10
    }

    return num + sum
}