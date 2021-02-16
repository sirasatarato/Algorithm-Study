package leet

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val row = Array(9) { BooleanArray(9) }
    val col = Array(9) { BooleanArray(9) }
    val box = Array(9) { BooleanArray(9) }

    for(i in 0..9) {
        for(j in 0..9) {
            if(board[i][j] != '.') {
                val num = board[i][j].toInt() - 1
                val k = i / 3 * 3 + j / 3
                if(row[i][num] || col[j][num] || box[k][num]) {
                    return false
                }

                row[i][num] = true
                col[j][num] = true
                box[k][num] = true
            }
        }
    }

    return true
}