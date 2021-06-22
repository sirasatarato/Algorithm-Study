package hackerrank.stacks_and_queues

fun main() {
    val list = mutableListOf<Int>()
    val result = mutableListOf<Int>()

    repeat(readLine()!!.toInt()) {
        val input = readLine()!!

        when (input.first().toInt() - 48) {
            1 -> list.add(input.split(' ').last().toInt())
            2 -> list.removeAt(0)
            3 -> result.add(list.first())
        }
    }

    result.forEach(::println)
}