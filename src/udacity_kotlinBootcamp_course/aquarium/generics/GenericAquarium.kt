package udacity_kotlinBootcamp_course.aquarium.generics

open class WaterSupply(var needsProcessing: Boolean)

class TapWater : WaterSupply(needsProcessing = true) {
    fun addChemicalCleaners() = apply { needsProcessing = false }
}

class LakeWater : WaterSupply(needsProcessing = false) {
    inline fun <reified T : Boolean> isOfType() = needsProcessing is T
}

class GenericAquarium<T : WaterSupply>(val waterSupply: T) {
    fun addWater() {
        // if this false, it throws exception and doesn't execute next statement
        check(!waterSupply.needsProcessing) { "water needs processing" }

        println("adding water from $waterSupply")
    }
}

//inline fun <reified R : WaterSupply> GenericAquarium<WaterSupply>.hasWaterSupplyOfType() =
//    waterSupply is R
inline fun <reified R : WaterSupply> GenericAquarium<*>.hasWaterSupplyOfType() =
    waterSupply is R

fun <T : WaterSupply> isWaterClean(aquarium: GenericAquarium<T>) { // generic function
    println("is water clean: ${aquarium.waterSupply.needsProcessing}")
}

fun genericExample() {
    val aquarium = GenericAquarium(LakeWater())
    // println("generic aquarium: ${aquarium.addWater()}")

    isWaterClean(aquarium)

    println("is of type: ${aquarium.hasWaterSupplyOfType<TapWater>()}")
    println(
        "is of type using generic type for extension function: " +
                "${aquarium.waterSupply.isOfType<Boolean>()}"
    )
}

fun main() {
    genericExample()
}