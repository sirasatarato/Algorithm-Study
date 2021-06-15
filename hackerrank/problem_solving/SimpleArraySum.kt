package hackerrank.problem_solving

fun simpleArraySum(arr: Array<Int>): Int = arr.sum()

fun main() {
    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    val result = simpleArraySum(arr)

    println(result)
}