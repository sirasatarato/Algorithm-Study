package hackerrank.stacks_and_queues

class Node(var value: Int) {
    var next: Node? = null
}

class LinkList {
    var head: Node? = null
    var tail: Node? = null

    fun append(value: Int) {
        val node = Node(value)

        if (tail == null) {
            head = node
        } else {
            tail!!.next = node
        }

        tail = node
    }

    fun append(list: LinkList) {
        tail!!.next = list.head
        tail = list.tail
    }

    fun removeFirst() {
        head = head!!.next

        if (head == null) {
            tail = null
        }
    }
}

fun poisonousPlants(p: Array<Int>): Int {
    var parts: MutableList<LinkList> = mutableListOf()
    var lastpart: LinkList? = null

    for (i in p.indices) {
        if (i > 0 && p[i] <= p[i - 1]) {
            lastpart?.append(p[i])
        } else {
            val part = LinkList()
            part.append(p[i])
            parts.add(part)
            lastpart = part
        }
    }

    var day = 0
    while (parts.size > 1) {
        for (i in 1 until parts.size) parts[i].removeFirst()

        val nextParts: MutableList<LinkList> = mutableListOf()
        for (part in parts) {
            if (part.head == null) continue

            if (nextParts.isNotEmpty() && nextParts[nextParts.size - 1].tail!!.value >= part.head!!.value) {
                nextParts[nextParts.size - 1].append(part)
            } else {
                nextParts.add(part)
            }
        }

        parts = nextParts
        day++
    }

    return day
}

fun main() {
    println(poisonousPlants(arrayOf(6, 5, 8, 4, 7, 10, 9)))
}
