package programers

import java.util.Collections

import java.util.PriorityQueue

fun solution(priorities: IntArray, location: Int): Int {
    var answer = 0
    val pq = PriorityQueue(Collections.reverseOrder<Int>())

    priorities.forEach {
        pq.offer(it)
    }

    while (pq.isNotEmpty()) {
        for (i in priorities.indices) {
            if (pq.peek() == priorities[i]) {
                pq.poll()
                answer++

                if (location == i) {
                    pq.clear()
                    break
                }
            }
        }
    }

    return answer
}