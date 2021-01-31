import java.util.*

class DFS(private val V: Int) {
    private val adj: Array<LinkedList<Int>> = Array(V) { LinkedList() }

    init {
        for (i in 0 until V) adj[i] = LinkedList<Int>()
    }

    // 노드를 연결 v->w
    fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
    }

    // DFS에 의해 사용되는 함수
    private fun DFSUtil(v: Int, visited: BooleanArray) {
        visited[v] = true
        print("$v ")

        // 방문한 노드와 인접한 모든 노드를 가져온다.
        val i: Iterator<Int> = adj[v].listIterator()
        while (i.hasNext()) {
            val n: Int = i.next()
            // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
            if (!visited[n]) DFSUtil(n, visited) // 순환 호출
        }
    }

    fun startDFSWithNode(v: Int) {
        val visited = BooleanArray(V)

        DFSUtil(v, visited)  // v를 시작 노드로 DFSUtil 순환 호출
    }

    fun startDFS() {
        val visited = BooleanArray(V)

        // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
        for (i in 0 until V) {
            if (!visited[i]) DFSUtil(i, visited)
        }
    }
}

fun main() {
    val g = DFS(4)
    g.addEdge(0, 1)
    g.addEdge(0, 2)
    g.addEdge(1, 2)
    g.addEdge(2, 0)
    g.addEdge(2, 3)
    g.addEdge(3, 3)
    g.startDFSWithNode(2) // 주어진 노드를 시작 노드로 DFS 탐색
    g.startDFS() // 비연결형 그래프의 경우
}