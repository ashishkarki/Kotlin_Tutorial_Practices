package udacity_kotlinBootcamp_course.aquarium

abstract class AquariumFish {
    abstract val fishColor: String
}

interface FishAction {
    fun eat()
}

class Dolphin : AquariumFish(), FishAction {
    override val fishColor = "bluish"

    override fun eat() {
        println("eat some weeds..")
    }
}

class Shark : AquariumFish(), FishAction {
    override val fishColor = "golden"

    override fun eat() {
        println("hunt other fish")
    }
}