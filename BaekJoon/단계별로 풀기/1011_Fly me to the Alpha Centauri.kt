import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val T = br.readLine().toInt()

    for (i in 0 until T) {
        val st = StringTokenizer(br.readLine(), " ")
        val X = st.nextToken().toInt()
        val Y = st.nextToken().toInt()
        val distance = Y - X
        val max = sqrt(distance.toDouble()).toInt()

        when {
            max.toDouble() == sqrt(distance.toDouble()) -> {
                sb.append(max * 2 - 1).append('\n')
            }
            distance <= max * max + max -> {
                sb.append(max * 2).append('\n')
            }
            else -> {
                sb.append(max * 2 + 1).append('\n')
            }
        }
    }

    println(sb)
}