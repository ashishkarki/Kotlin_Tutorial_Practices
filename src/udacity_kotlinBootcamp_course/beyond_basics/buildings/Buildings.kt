package udacity_kotlinBootcamp_course.beyond_basics.buildings

open class BaseBuildingMaterial(val numberNeeded: Int = 1) {}

class Wood(numberNeeded: Int = 4) :
    BaseBuildingMaterial(numberNeeded = numberNeeded) {}

class Brick(numberNeeded: Int = 8) :
    BaseBuildingMaterial(numberNeeded = numberNeeded) {}

class Building<T : BaseBuildingMaterial>(private val baseBuildingMaterial: T) {
    private val baseMaterialsNeeded = 100

    private val actualMaterialsNeeded = baseBuildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println(
            "Type of material: ${baseBuildingMaterial::class.simpleName}, " +
                    "no of material: $actualMaterialsNeeded"
        )
    }
}

fun main() {
    val woodBuilding = Building<Wood>(Wood())

    woodBuilding.build()
}