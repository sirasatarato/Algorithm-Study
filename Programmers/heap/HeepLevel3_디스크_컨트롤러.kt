package programers.heap

import java.util.LinkedList
import java.util.PriorityQueue

data class Job(var requestTime: Int, var workingTime: Int)

fun solution(jobs: Array<IntArray>): Int {
    val waiting = LinkedList<Job>()
    val pq = PriorityQueue { j1: Job, j2: Job -> j1.workingTime - j2.workingTime }

    for (job in jobs) {
        waiting.offer(Job(job[0], job[1]))
    }

    waiting.sortWith { j1: Job, j2: Job -> j1.requestTime - j2.requestTime }

    var answer = 0
    var cnt = 0
    var time = waiting.peek().requestTime

    while (cnt < jobs.size) {
        while (!waiting.isEmpty() && waiting.peek().requestTime <= time) {
            pq.offer(waiting.pollFirst())
        }
        if (!pq.isEmpty()) {
            val job = pq.poll()
            time += job.workingTime
            answer += time - job.requestTime
            cnt++
        } else {
            time++
        }
    }

    return answer / cnt
}
