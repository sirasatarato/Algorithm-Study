package baekjoon

import java.util.*

data class Dot(var x: Int, var y: Int)

var dx = intArrayOf(1, -1, 0, 0)
var dy = intArrayOf(0, 0, 1, -1)

fun bfs(a: Array<IntArray>, check: Array<IntArray>, d: Dot) {
    val q: Queue<Dot> = LinkedList()
    q.offer(d)
    check[d.x][d.y] = 1
    while (!q.isEmpty()) {
        val dP = q.poll()
        val x = dP.x
        val y = dP.y
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx >= a.size || nx < 0 || ny >= a[nx].size || ny < 0) continue
            if (a[nx][ny] == 0) continue
            if (check[nx][ny] == Int.MAX_VALUE && a[nx][ny] == 1) {
                check[nx][ny] = Math.min(check[x][y] + 1, check[nx][ny])
                q.offer(Dot(nx, ny))
            }
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val m = scanner.nextInt()
    val map = Array(n) { IntArray(m) }
    val check = Array(n) { IntArray(m) }

    for (i in map.indices) {
        val str = scanner.next()

        for (j in map[i].indices) {
            map[i][j] = str[j] - '0'
        }
    }

    for (ints in check) {
        Arrays.fill(ints, Int.MAX_VALUE)
    }

    val d = Dot(0, 0)
    bfs(map, check, d)
    println(check[n - 1][m - 1])
}