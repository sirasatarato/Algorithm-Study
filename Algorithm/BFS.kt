import java.util.*

class Graph(private val V: Int) {
    private val adj: Array<LinkedList<Int>> = Array(V) { LinkedList() }

    init {
        for (i in 0 until V) adj[i] = LinkedList<Int>()
    }

    // 노드를 연결 v->w
    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
    }

    fun startBFS(startNode: Int) {
        var node = startNode
        val visited = BooleanArray(V)
        val queue = LinkedList<Int>()

        // 현재 노드를 방문한 것으로 표시하고 큐에 삽입(enqueue)
        visited[node] = true
        queue.add(node)

        // Queue가 empty될 때까지 반복
        while (queue.size != 0) {
            // 방문한 Node를 Queue에서 dequeue하고 값을 출력
            node = queue.poll()
            print("$node ")

            // 방문한 Node와 인접한 모든 Node를 가져온다.
            val i: Iterator<Int> = adj[node].listIterator()
            while (i.hasNext()) {
                val n = i.next()
                // 방문하지 않은 Node라면 방문한 것으로 표시하고 enqueue
                if (!visited[n]) {
                    visited[n] = true
                    queue.add(n)
                }
            }
        }
    }
}

fun main() {
    val g = Graph(4)
    g.addEdge(0, 1)
    g.addEdge(0, 2)
    g.addEdge(1, 0)
    g.addEdge(1, 2)
    g.addEdge(2, 0)
    g.addEdge(2, 1)
    g.addEdge(2, 3)
    g.addEdge(3, 2)
    g.startBFS(2)
}