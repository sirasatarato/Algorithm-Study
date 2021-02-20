internal class Dijkstra(private val node: Int) {
    private val maps: Array<IntArray> = Array(node + 1) { IntArray(node + 1) }

    fun input(i: Int, j: Int, w: Int) {
        maps[i][j] = w
        maps[j][i] = w
    }

    fun dijkstra(v: Int) {
        val distance = IntArray(node + 1) { Int.MAX_VALUE }
        val check = BooleanArray(node + 1)

        distance[v] = 0
        check[v] = true

        for (i in 1 until node + 1) {
            if (!check[i] && maps[v][i] != 0) {
                distance[i] = maps[v][i]
            }
        }
        for (a in 0 until node - 1) {
            var min = Int.MAX_VALUE
            var minIndex = -1

            for (i in 1 until node + 1) {
                if (!check[i] && distance[i] != Int.MAX_VALUE && distance[i] < min) {
                    min = distance[i]
                    minIndex = i
                }
            }

            check[minIndex] = true
            for (i in 1 until node + 1) {
                if (!check[i] && maps[minIndex][i] != 0) {
                    if (distance[i] > distance[minIndex] + maps[minIndex][i]) {
                        distance[i] = distance[minIndex] + maps[minIndex][i]
                    }
                }
            }
        }

        for (i in 1 until node + 1) {
            print(distance[i].toString() + " ")
        }
        println()
    }

}

fun main() {
    val dijkstra = Dijkstra(8)
    dijkstra.input(1, 2, 3)
    dijkstra.input(1, 5, 4)
    dijkstra.input(1, 4, 4)
    dijkstra.input(2, 3, 2)
    dijkstra.input(3, 4, 1)
    dijkstra.input(4, 5, 2)
    dijkstra.input(5, 6, 4)
    dijkstra.input(4, 7, 6)
    dijkstra.input(7, 6, 3)
    dijkstra.input(3, 8, 3)
    dijkstra.input(6, 8, 2)
    dijkstra.dijkstra(1)
}