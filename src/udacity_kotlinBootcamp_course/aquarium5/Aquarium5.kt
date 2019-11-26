package udacity_kotlinBootcamp_course.aquarium5

data class Fish(var name: String)

fun fishExample() {
    val fish = Fish(name = "sparky")

    myWith(fish.name) {
        println(this.capitalize())
    }

    // other examples of built in higher order functions are run and apply
    // both of these functions can be applied to any type of object
    // run returns the result of applying the function
    println(fish.run { name })
    // whereas apply returns the object after applying the function
    println(fish.apply { "Stinky" })

    val fish2 = Fish(name = "sparky").apply { name = "stinky" }
    println(fish2.name)

    // let returns a copy of the changed object; useful for chaining manipulations together
    println(
        fish.let { it.name.capitalize() }
            .let { it + "fish" }
            .let { it.length }
           // .let { it + 31 }
    )
}

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun main() {
    fishExample()
}