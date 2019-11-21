package udacity_kotlinBootcamp_course.aquarium

open class Aquarium(var length: Int = 10, var width: Int = 10, var height: Int = 10) {

    // this is how we create custom getter and setter
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height += 10
        }

    fun calculateVolume() = width * height * length / 1000

    open var waterVolume = volume * 0.9;

    // this is how we create a new constructor with different arguments
    constructor(noOfFish: Int) : this() {
        height -= 2;
    }
}

class TankTower() : Aquarium() {

    override var volume: Int
        get() = (width * length * height * 0.85 / 1000).toInt()
        set(value) {
            height += value
        }

    override var waterVolume = volume * 0.9;
}