package udacity_kotlinBootcamp_course

import udacity_kotlinBootcamp_course.spice.SpicinessLevel

interface SpiceColor {
    val color: String
}

abstract class Spice(
    val name: String,
    val spiciness: SpicinessLevel = SpicinessLevel.MILD,
    color: SpiceColor
) : SpiceColor by color {

    private val heat: Int
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

    abstract fun prepareSpice()
}

interface Grinder {
    fun grind()
}

object YellowSpiceColor : SpiceColor {
    override val color: String
        get() = "Yellow"
}

class Curry(
    name: String = "curry",
    spiciness: SpicinessLevel,
    spiceColor: SpiceColor = YellowSpiceColor
) :
    Spice(name, spiciness, spiceColor),
    Grinder {
    override fun prepareSpice() {

    }

    override fun grind() {

    }
}

fun main() {
    val curry = Curry(spiciness = SpicinessLevel.MEDIUM)
    println("curry name ${curry.name}, spiciness: ${curry.spiciness}, color: ${curry.color}")
}