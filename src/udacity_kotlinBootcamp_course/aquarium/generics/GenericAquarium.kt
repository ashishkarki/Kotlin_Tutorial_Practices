package udacity_kotlinBootcamp_course.aquarium.generics

import udacity_kotlinBootcamp_course.aquarium.Aquarium

open class WaterSupply(var needsProcessing: Boolean)

class TapWater : WaterSupply(needsProcessing = true) {
    fun addChemicalCleaners() = apply { needsProcessing = false }
}

class GenericAquarium<out T : WaterSupply>(val waterSupply: T) {
    fun addWater() {
        // if this false, it throws exception and doesn't execute next statement
        check(!waterSupply.needsProcessing) { "water needs processing" }

        println("adding water from $waterSupply")
    }
}

fun isWaterClean(aquarium: GenericAquarium<WaterSupply>) {
    println("is water clean: ${aquarium.waterSupply.needsProcessing}")
}

fun genericExample() {
    val aquarium: GenericAquarium<TapWater> = GenericAquarium(TapWater())
    // println("generic aquarium: ${aquarium.addWater()}")

    isWaterClean(aquarium)
}

fun main() {
    genericExample()
}