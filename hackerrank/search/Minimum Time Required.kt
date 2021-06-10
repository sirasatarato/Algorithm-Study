package hackerrank.search

import java.util.*
import kotlin.math.floor

fun minTime(machines: Array<Long>, goal: Long): Long {
    machines.sort()
    return binarySearchIter(machines.toLongArray(), goal, 1, machines[machines.size - 1] * goal)
}

fun binarySearchIter(machines: LongArray, goal: Long, min: Long, max: Long): Long {
    var minDay = min
    var maxDay = max
    var mid: Long
    var prd: Long

    while (minDay < maxDay) {
        prd = 0
        mid = (minDay + maxDay) / 2

        machines.forEach { prd += floor((mid / it).toDouble()).toLong() }

        if (prd >= goal) {
            maxDay = mid
        } else if (prd < goal) {
            minDay = mid + 1
        }
    }

    return minDay
}


fun main() {
    val scan = Scanner(System.`in`)
    val nGoal = scan.nextLine().split(" ")
    val goal = nGoal[1].trim().toLong()
    val machines = scan.nextLine().split(" ").map{ it.trim().toLong() }.toTypedArray()
    val ans = minTime(machines, goal)

    println(ans)
}
