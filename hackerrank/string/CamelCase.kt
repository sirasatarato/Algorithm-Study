package hackerrank.string

fun camelcase(s: String): Int = s.filter{ it.isUpperCase() }.length + 1

fun main() = println(camelcase(readLine()!!))
