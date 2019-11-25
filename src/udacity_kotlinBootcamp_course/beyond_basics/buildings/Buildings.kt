package udacity_kotlinBootcamp_course.beyond_basics.buildings

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood(numberNeeded: Int = 4) : BaseBuildingMaterial(numberNeeded = numberNeeded)

class Brick(numberNeeded: Int = 8) : BaseBuildingMaterial(numberNeeded = numberNeeded)

class Building<out T : BaseBuildingMaterial>(private val baseBuildingMaterial: T) {
    private val baseMaterialsNeeded = 100

    val actualMaterialsNeeded = baseBuildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println(
            "Type of material: ${baseBuildingMaterial::class.simpleName}, " +
                    "no of material: $actualMaterialsNeeded"
        )
    }
}

// generic function example
fun <W : BaseBuildingMaterial> isSmallBuilding(building: Building<W>) {
    println("kind of building: ${if (building.actualMaterialsNeeded < 500) "small" else "large"}")
}

fun main() {
    val woodBuilding = Building(Wood())
    woodBuilding.build()

    val brickBuilding = Building(Brick())
    brickBuilding.build()

    isSmallBuilding(Building(Wood()))
}