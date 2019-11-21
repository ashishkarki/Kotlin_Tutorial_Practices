package udacity_kotlinBootcamp_course.aquarium

class Aquarium(var length: Int = 10, var width: Int = 10, var height: Int = 10) {

    // this is how we create custom getter and setter
    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height += 10
        }

    fun calculateVolume() = width * height * length / 1000

    var waterVolume = volume * 0.9;

    // this is how we create a new constructor with different arguments
    constructor(noOfFish: Int) : this() {
        height -= 2;
    }
}