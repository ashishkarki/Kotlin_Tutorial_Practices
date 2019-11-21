package udacity_kotlinBootcamp_course.aquarium

class Aquarium {

    var width: Int = 10
    var height: Int = 10
    var length: Int = 10

    // this is how we create custom getter and setter
    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height += 100
        }

    fun calculateVolume() = width * height * length / 1000
}