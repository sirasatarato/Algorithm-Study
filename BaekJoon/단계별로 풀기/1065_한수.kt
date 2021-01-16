import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val count = (1..n).filter(::solution).count()

    bw.write("$count")
    bw.flush()
    bw.close()
}

fun solution(n: Int): Boolean {
    return if(n < 100) true
    else {
        val first = n / 100
        val second = n / 10 % 10
        val third = n % 10

        first - second == second - third
    }
}