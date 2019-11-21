package udacity_kotlinBootcamp_course.spice

enum class SpicinessLevel {
    LOW, MILD, MEDIUM, HOT
}

class Spice(val name: String, private val spiciness: SpicinessLevel = SpicinessLevel.MILD) {

    val heat: Int
        get() {
            return when (spiciness) {
                SpicinessLevel.LOW -> 2
                SpicinessLevel.MILD -> 5
                SpicinessLevel.MEDIUM -> 7
                SpicinessLevel.HOT -> 10
                else -> 0
            }
        }

    init {
        println("Spice name is ${this.name}, spicy level is ${this.heat}")
    }
}

fun main() {
    val spice1 = Spice(name = "Cardamom", spiciness = SpicinessLevel.MILD)
    val spice2 = Spice(name = "Turmeric", spiciness = SpicinessLevel.LOW)
    val spice3 = Spice(name = "Chilly", spiciness = SpicinessLevel.HOT)

    val spices = listOf<Spice>(spice1, spice2, spice3)

    println("Creating a list of spices that are <= mild: " +
            "${spices.filter { it.heat <= 5 }.map { it.name }}"
    )
}

fun makeSalt() = Spice(name = "Salt", spiciness = SpicinessLevel.LOW)