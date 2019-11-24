package udacity_kotlinBootcamp_course.beyond_basics

fun main() {
    val numbers = listOf(11, 12, 13, 14, 15, 16, 20)

    println("reversed number long kotlin way: ${reverseListLongKotlinWay(numbers)}")
    println("reversed number easy kotlin way: ${numbers.reversed()}")
}

fun reverseListLongKotlinWay(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in list.size - 1 downTo 0) {
        result.add(list[i])
    }

    return result
}