package udacity_kotlinBootcamp_course

/**
 * Exercise: Greetings, Kotlin

Create a main() function that takes an argument representing the time in 24-hour format (values between and including 0 -> 23).

In the main() function, check if the time is before midday (<12), then print "Good morning, Kotlin"; otherwise, print "Good night, Kotlin".
 */

fun main(args: Array<String>) {
    longCheck(args)

    usingStringTemplate(args)
}

fun longCheck(args: Array<String>) {
    args?.let { it ->
        if (it.isNotEmpty()) {
            val time = it[0].toInt()

            if (time < 12) println("Good morning, Kotlin")
            else println("Good night, Kotlin")
        } else {
            println("hey, args is empty")
        }
    }
}

fun usingStringTemplate(args: Array<String>) {
    val msg = "Good ${if (args[0].toInt() < 12) "morning" else "night"}, Kotlin"
    println(msg)
}