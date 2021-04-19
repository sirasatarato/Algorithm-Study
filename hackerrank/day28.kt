package hackerrank

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val nameList = mutableListOf<String>()

    for (NItr in 1..scanner.nextLine().toInt()) {
        val firstNameEmailID = scanner.nextLine().split(" ")
        val firstName = firstNameEmailID[0]
        val emailID = firstNameEmailID[1]

        if(emailID.contains("@gmail.com")) nameList.add(firstName)
    }

    nameList.sorted().forEach(::println)
}
