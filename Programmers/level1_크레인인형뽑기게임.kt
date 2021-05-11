package programers

import java.util.*

fun solution(board: Array<IntArray>, moves: IntArray): Int {
    val basket = Stack<Int>()
    var count = 0

    for(move in moves.map { it - 1 }) {
        val index = board.indexOfFirst { it[move] != 0 }
        if (index == -1) continue

        if (basket.isNotEmpty() && basket.peek() == board[index][move]) {
            basket.pop()
            count += 2
        } else {
            basket.push(board[index][move])
        }

        board[index][move] = 0
    }

    return count
}

fun main() {
    val intArray = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 3),
        intArrayOf(0, 2, 5, 0, 1),
        intArrayOf(4, 2, 4, 4, 2),
        intArrayOf(3, 5, 1, 3, 1),
    )

    println(solution(intArray, intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)))
}