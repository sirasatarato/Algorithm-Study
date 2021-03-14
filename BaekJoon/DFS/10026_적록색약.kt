package baekjoon

import java.io.BufferedReader
import java.util.StringTokenizer
import java.io.InputStreamReader

lateinit var grid: Array<CharArray?>
lateinit var pictures: Array<IntArray>
lateinit var patient: Array<IntArray>
var moveX = intArrayOf(0, 1, 0, -1)
var moveY = intArrayOf(-1, 0, 1, 0)
var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    n = st.nextToken().toInt()
    pictures = Array(n) { IntArray(n) }
    patient = Array(n) { IntArray(n) }
    grid = arrayOfNulls(n)
    for (i in 0 until n) grid[i] = br.readLine().toCharArray()

    var count = 0
    var patientCount = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (pictures[i][j] == 0) {    // 아직 방문하지 않은 색깔인 경우
                count++
                dfs(i, j, grid[i]!![j], count)
            }
            if (patient[i][j] == 0) {    // 아직 방문하지 않은 색깔인 경우
                patientCount++
                patientDFS(i, j, grid[i]!![j], count)
            }
        }
    }

    println("$count $patientCount")
}

// They is 적록색약
private fun patientDFS(y: Int, x: Int, color: Char, count: Int) {
    patient[y][x] = count
    for (i in 0..3) {
        val nextX = x + moveX[i]
        val nextY = y + moveY[i]

        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue
        // 이미 탐색한 곳인 경우 넘기기
        if (patient[nextY][nextX] != 0) continue

        val nextColor = grid[nextY]!![nextX]
        if (nextColor == color) {
            patientDFS(nextY, nextX, nextColor, count)
        } else if (color == 'R' && nextColor == 'G' || color == 'G' && nextColor == 'R') {
            patientDFS(nextY, nextX, nextColor, count)
        }
    }
}

// They ain't 적록색약
private fun dfs(y: Int, x: Int, color: Char, count: Int) {
    pictures[y][x] = count

    for (i in 0..3) {
        val nextX = x + moveX[i]
        val nextY = y + moveY[i]

        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue
        // 이미 탐색한 곳인 경우 넘기기
        if (pictures[nextY][nextX] != 0) continue

        val nextColor = grid[nextY]!![nextX]
        if (nextColor == color) dfs(nextY, nextX, nextColor, count)
    }
}