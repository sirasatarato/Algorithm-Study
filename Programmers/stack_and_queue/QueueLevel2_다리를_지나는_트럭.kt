package programers.stack_and_queue

import java.util.LinkedList
import java.util.Queue

fun soluti(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var answer = 0
    val queue: Queue<Int> = LinkedList()

    var max = 0
    for (widget in truck_weights) {
        while (true) {
            if (queue.isEmpty()) {
                queue.offer(widget)
                max += widget
                answer++
                break
            } else if (queue.size == bridge_length) {
                max -= queue.poll()
            } else {
                answer++
                if (max + widget > weight) {
                    queue.offer(0)
                } else {
                    queue.offer(widget)
                    max += widget
                    break
                }
            }
        }
    }

    return answer + bridge_length
}

fun main() {
    print(soluti(100, 100, intArrayOf(10)))
}