package udacity_kotlinBootcamp_course

import java.util.*

fun main(args: Array<String>) {
    println("Hello from Kotlin main with args: ${args[0]}")

    dayOfWeek()
    expressionPractice()

    feedTheFish()
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println("Today is $day and the food eats $food")
}

fun fishFood(day: String): String {
    return when (day) {
        "Sunday" -> "cereal"
        "Monday" -> "dumplings"
        "Tuesday" -> "pellets"
        // likewise for others
        "Saturday" -> "lettuce"
        else -> "fish don't eat today"
    }
}

fun randomDay(): String {
    val weeksDays = listOf<String>("Sunday", "Monday", "Tuesday", "Wednesday", "Thurs", "Fri", "Sat")
    return weeksDays[Random().nextInt(7)]
}

fun expressionPractice() {
    val isUnit = println("What is this??")
    println(isUnit)

    var temp = 51
    val message = "You are ${if (temp > 20) "hot" else "safe"} fish"
    println(message)
}

fun dayOfWeek() {
    println("What day is today?")

    val dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    println(
        when (dayOfWeek) {
            1 -> "Sunday"
            3 -> "Tuesday"
            else -> "Something is wrong"
        }
    )
}