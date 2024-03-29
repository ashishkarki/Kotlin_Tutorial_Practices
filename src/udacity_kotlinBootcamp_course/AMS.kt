package udacity_kotlinBootcamp_course

import java.util.*
import kotlin.system.measureNanoTime

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

    waysToFilterExample()
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println("Today is $day and the food eats $food")

    shouldChangeWater("Monday")
    shouldChangeWater("Monday", 28, 60)
    shouldChangeWater("Sunday", dirty = 50) // if skipping default params, provide param names

    dirtyProcessor()
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
val isTooHotLambda = { temperature: Int -> temperature > 20 }
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"
fun getDirtySensorReading() = 20

fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = getDirtySensorReading()
): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true

        else -> false
    }
}

fun waysToFilterExample() {
    val decorations = listOf<String>("hearts", "chimes", "bells", "toys", "flowerpot")

    // using eager way, where every element is evaluated
    val eager = measureNanoTime { decorations.map { "$it-mapped" }.filter { it[0] == 'b' } }
    println("using eager way: $eager")

    // using a sequence is lazy way and is only started after a terminal operation like filter
    val lazy = measureNanoTime { decorations.asSequence().map { "$it-mapped" }.filter { it[0] == 'b' } }
    println("using lazy way: $lazy")
    // println("using lazy way to list: ${lazy.toList()}")
}

// following are lambdas and function type examples
var dirty = 20

val waterFilterLambda: (Int) -> Int = { dirtyLocal -> dirtyLocal / 2 } // lambda
fun feedFish(dirtyLocal: Int) = dirtyLocal + 10  // function type

// lambdas can be passed as parameters to other functions
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilterLambda)

    // since feedFish is a function reference, we use :: to let kotlin know we are only
    // passing a reference and not trying to execute the function
    dirty = updateDirty(dirty, ::feedFish)

    // lamdas can directly be created and passed into functions
    dirty = updateDirty(dirty, { dirty ->
        dirty + 50
    })

    // or, the above can be written using last parameter syntax, where lambdas sits outside function's paren
    dirty = updateDirty(dirty) { dirty -> dirty + 50 }
}
////////////////

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