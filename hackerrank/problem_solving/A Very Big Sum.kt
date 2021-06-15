package hackerrank.problem_solving

fun aVeryBigSum(ar: Array<Long>): Long = ar.sum()

fun main() {
    val ar = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()
    val result = aVeryBigSum(ar)

    println(result)
}
