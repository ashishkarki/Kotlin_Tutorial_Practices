package udacity_kotlinBootcamp_course

import java.util.*

fun main(args: Array<String>) {
    println("Hello from Kotlin main with args: ${args[0]}")

    dayOfWeek()
    expressionPractice()

    feedTheFish()

    swim(5)
    swim(20, "medium")
    swim(10, speed = "slow")

    println(canAddFish(10.0, listOf(3, 3, 3)))
    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1, 1, 3), 3))
    println(canAddFish(10.0, listOf(), 7, true))
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println("Today is $day and the food eats $food")

    shouldChangeWater("Monday")
    shouldChangeWater("Monday", 28, 60)
    shouldChangeWater("Sunday", dirty = 50) // if skipping default params, provide param names
}

fun canAddFish(
    tankSize: Double,
    currentFish: List<Int>,
    fishSize: Int = 2,
    hasDecorations: Boolean = true
): Boolean {
    /* var effectiveTankSize: Double = tankSize.toDouble()
    if (hasDecorations) effectiveTankSize *= 0.8;

    val deductFishSize = { a: Int -> effectiveTankSize -= a } // Kotlin's version of consumer
    currentFish.forEach(deductFishSize)

    return effectiveTankSize >= fishSize*/

    // OR, more concise
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
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

fun isTooHot(temperature: Int) = temperature > 20
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = 20
): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true

        else -> false
    }
}

fun swim(time: Int, speed: String = "fast") {
    println("The swimming speed is $speed for time of $time")
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