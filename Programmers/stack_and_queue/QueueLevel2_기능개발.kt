package programers.stack_and_queue

fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    val times = arrayOfNulls<Int>(progresses.size)
    val list = ArrayList<Int>()

    for (i in progresses.indices) {
        times[i] = if ((100 - progresses[i]) % speeds[i] == 0) {
            (100 - progresses[i]) / speeds[i]
        } else {
            (100 - progresses[i]) / speeds[i] + 1
        }
    }

    var value = 1
    var start = times[0]

    for (i in 0 until times.size - 1) {
        if (start!! >= times[i + 1]!!) {
            value++
        } else {
            list.add(value)
            start = times[i + 1]
            value = 1
        }

        if (i == times.size - 2) list.add(value)
    }

    return list.toIntArray()
}
