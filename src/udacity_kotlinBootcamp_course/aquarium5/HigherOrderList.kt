package udacity_kotlinBootcamp_course.aquarium5

fun List<Int>.myList(block: Int.() -> Int): List<Int> {
    val result = mutableListOf<Int>()

    for (item in this) {
        if (block(item) == 0) result.add(item)
    }

    return result
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    print(numbers.myList { rem(3) })
    //println("divisible by 3: ${numbers.myList { it.rem(3) }}")
}