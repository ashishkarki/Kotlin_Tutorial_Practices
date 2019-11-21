package udacity_kotlinBootcamp_course.aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {
    val size: Int

    init {
        println("First init block")
    }

    init {
        size = if (friendly) volumeNeeded
        else volumeNeeded * 2
    }

    // second constructor; all inits are called in their sequence before this
    constructor() : this(friendly = false, volumeNeeded = 9) {
        println("Printing from secondary constructor")
    }

    init {
        println("Final fish size is ${this.size}")
    }

    init {
        println("You can have as many init blocks. This is the last init block")
    }
}

fun main() {
    val fish1 = Fish(volumeNeeded = 10)
    println("fish1 is friendly: ${fish1.friendly} and volume needed: ${fish1.size}")

    val fish2 = Fish()
    println("fish2 is friendly: ${fish2.friendly} and volume needed: ${fish2.size}")
}