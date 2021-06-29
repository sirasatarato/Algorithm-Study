package hackerrank.stacks_and_queues

import java.util.*

val X_OFFSETS = intArrayOf(-1, 0, 1, 0)
val Y_OFFSETS = intArrayOf(0, 1, 0, -1)

fun minimumMoves(grid: Array<String>, startX: Int, startY: Int, goalX: Int, goalY: Int): Int {
    if (startX == goalX && startY == goalY) return 0

    val queue = LinkedList<Pair<Int, Int>>().apply { offer(Pair(startX, startY)) }
    val size: Int = grid.size
    val moves = Array(size) { IntArray(size) { -1 } }
    moves[startX][startY] = 0

    while (true) {
        val head: Pair<Int, Int> = queue.poll()

        for (i in X_OFFSETS.indices) {
            var nextX = head.first
            var nextY = head.second

            while (isOpen(grid, nextX + X_OFFSETS[i], nextY + Y_OFFSETS[i])) {
                nextX += X_OFFSETS[i]
                nextY += Y_OFFSETS[i]

                if (nextX == goalX && nextY == goalY) {
                    return moves[head.first][head.second] + 1
                }

                if (moves[nextX][nextY] < 0) {
                    moves[nextX][nextY] = moves[head.first][head.second] + 1
                    queue.offer(Pair(nextX, nextY))
                }
            }
        }
    }
}

fun isOpen(grid: Array<String>, x: Int, y: Int): Boolean {
    return x >= 0 && x < grid.size && y >= 0 && y < grid.size && grid[x][y] == '.'
}

fun main() {
    val n = readLine()!!.trim().toInt()
    val grid = Array(n) { "" }

    for (i in 0 until n) {
        val gridItem = readLine()!!
        grid[i] = gridItem
    }

    val firstMultipleInput = readLine()!!.trimEnd().split(" ")
    val startX = firstMultipleInput[0].toInt()
    val startY = firstMultipleInput[1].toInt()
    val goalX = firstMultipleInput[2].toInt()
    val goalY = firstMultipleInput[3].toInt()
    val result = minimumMoves(grid, startX, startY, goalX, goalY)

    println(result)
}
