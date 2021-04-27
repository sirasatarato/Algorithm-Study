package hackerrank.warm_up_challenges

import java.util.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val hashSet = HashSet<Int>()
    var count = 0

    for (i in 0 until n) {
        val element = ar[i]
        if (hashSet.contains(element)) {
            hashSet.remove(element)
            count++
        } else {
            hashSet.add(element)
        }
    }

    return count

//  return ar.groupBy { it }.map { (_, v) -> (v.size / 2) }.sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}

// 실행시간 비교
// HashSet: 230700ns
// groupBy: 3576600ns