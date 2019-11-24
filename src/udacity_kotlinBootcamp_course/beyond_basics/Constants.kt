package udacity_kotlinBootcamp_course.beyond_basics

/**
 * Diff between val and const val is that val can be assigned at execution time whereas
 * const val is assigned during compile time itself. No matter, both of these are constants
 */

val runTimeConstant = someFxn()
const val compileTimeConstant = "top-level constant, cannot be used inside a class"

// also, const can only be declared inside an object declaration
object Constants {
    const val someConstant = "Constant can only be within an object"
}

// to declare const within a class, we have to put it inside a companion object
class SomeClass {

    companion object {
        const val anotherConstant = "within a class, put const inside companion object"
    }
}

fun someFxn(): String {
    return "Some String constant"
}