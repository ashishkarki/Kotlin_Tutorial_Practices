package udacity_kotlinBootcamp_course.spice.decorations

import udacity_kotlinBootcamp_course.Curry
import udacity_kotlinBootcamp_course.spice.SpicinessLevel

fun main() {
    makeSpiceContainers()
}

fun makeSpiceContainers() {
    val spiceCabinet = listOf(
        SpiceContainer(Curry("Yellow Curry", SpicinessLevel.MILD)),
        SpiceContainer(Curry("Red Curry", SpicinessLevel.HOT)),
        SpiceContainer(Curry("Green Curry", SpicinessLevel.LOW))
    )

    for (spice in spiceCabinet) println("spice label is ${spice.label}")
}

data class SpiceContainer(val spice: udacity_kotlinBootcamp_course.Spice) {
    val label = spice.name
}