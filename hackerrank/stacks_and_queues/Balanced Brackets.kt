package hackerrank.stacks_and_queues

import java.util.*

fun isBalanced(s: String): String {
    val stack: Deque<Char> = ArrayDeque()

    for (i in s.indices) {
        val x: Char = s.elementAt(i)

        if (x == '(' || x == '[' || x == '{') {
            stack.push(x)
            continue
        }

        if (stack.isEmpty()) return "NO"
        val check: Char = stack.pop()

        when (x) {
            ')' -> {
                if (check == '{' || check == '[') return "NO"
            }
            '}' -> {
                if (check == '(' || check == '[') return "NO"
            }
            ']' -> {
                if (check == '(' || check == '{') return "NO"
            }
        }
    }

    return if(stack.isEmpty()) "YES" else "NO"
}

fun main() {
    repeat(readLine()!!.trim().length) { println(isBalanced("")) }
}
