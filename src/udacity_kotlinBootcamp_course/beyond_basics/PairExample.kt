package udacity_kotlinBootcamp_course.beyond_basics

fun main() {
    val (tool, use) = giveMeAPair() // this is called de-structuring
    println("tool : $tool, use: $use")
}

fun giveMeAPair(): Pair<String, String> {
    return ("fishnet" to "catching")
}