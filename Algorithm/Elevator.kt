import java.lang.NumberFormatException
import java.util.*

class Elevator {
    var elevator = 0
    var input = 0
    var count = 0

    fun talking() {
        var count1 = 0
        var count2: Int
        var register = ""
        val random = Random()
        val scanner = Scanner(System.`in`)

        elevator = random.nextInt(60)
        println("현재 층은 $elevator")

        val str = scanner.nextLine()
        try {
            while (count < str.length) {
                count++
                count1++
                count2 = count1 - 1
                if (count1 < 0) {
                    count = 0
                }
                val st = str.substring(count2, count1)
                register += st
                input = register.toInt()
                println(input)
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }
        reputation()
    }

    private fun reputation() {
        while (elevator < input) {
            elevator++
            println("현재 층은: $elevator")
        }
        while (elevator > input) {
            elevator--
            println("현재 층은: $elevator")
        }
        if (elevator == input) {
            println("현재 층은 $input")
        }
    }
}

fun main() {
    val e = Elevator()
    e.talking()
}