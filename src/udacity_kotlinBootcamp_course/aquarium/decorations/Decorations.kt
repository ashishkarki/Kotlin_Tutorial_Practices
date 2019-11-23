package udacity_kotlinBootcamp_course.aquarium.decorations

fun main() {
    makeDecorations()
}

fun makeDecorations() {
    val decoration1 = Decorations("Granite")
    println("decoration1: $decoration1")

    val decoration2 = Decorations("Slate")
    println("decoration2: $decoration2")

    val decoration3 = Decorations("Slate")
    println("decoration3: $decoration3")

    println("decoration1.equals(decoration2): ${decoration1 == decoration2}")
    println("decoration2.equals(decoration3): ${decoration2 == decoration3}")

    val decoration4 = decoration3.copy();
    println("decoration3.equals(decoration4): ${decoration3 == decoration4}")

    val decorations5 = Decorations2(rockType = "Crystal", wood = "wood", diver = "diver")
    println("decorations5: $decorations5")

    val (rock: String, wood: String, diver: String) = decorations5 // this is called decomposition
    println("rock: $rock, wood: $wood, diver: $diver")
}

data class Decorations(val rockType: String) {}

data class Decorations2(val rockType: String, val wood: String, val diver: String) {}