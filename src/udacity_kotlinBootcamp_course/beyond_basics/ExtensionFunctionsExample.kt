package udacity_kotlinBootcamp_course.beyond_basics

fun String.hasSpaces(): Boolean {
    val found: Char? = this.find { it == ' ' }
    return found != null
}

fun String.hasSpacesShort() = find { it == ' ' } != null

fun hasSpacesImpl() {
    println("This has spaces".hasSpaces())
    println("This has spaces".hasSpacesShort())
}

open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant(color = "Green", size = size)

// extension function to AquariumPlant; can only be applied to non-private members
fun AquariumPlant.isRed() = color == "Red"

// we can also define extension properties
val AquariumPlant.isBlue: Boolean
    get() = color == "Blue"

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

// example of nullable extension function i.e the receiver or the AquariumPlant could be null
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

fun main() {
    hasSpacesImpl()

    val plant = GreenLeafyPlant(size = 50)
    plant.print()

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()

    val blueAquariumPlant = AquariumPlant(color = "Blue", size = 50)
    println("isBlue: ${blueAquariumPlant.isBlue}")

    val nullableAquariumPlant: AquariumPlant? = null // AquariumPlant(color = "White", size = 20)
    nullableAquariumPlant.pull()
}