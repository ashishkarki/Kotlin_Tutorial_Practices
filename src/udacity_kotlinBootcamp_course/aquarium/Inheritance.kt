package udacity_kotlinBootcamp_course.aquarium

interface FishAction2 {
    fun eat()
}

interface FishColor2 {
    val color: String
}

// single object; delegation
object GoldColor : FishColor2 {
    override val color: String
        get() = "Gold"
}

object RedColor : FishColor2 {
    override val color: String
        get() = "Red"
}

// this can't be object/singleton since food argument means we call new food every time
class PrintingFishAction(val food: String) : FishAction2 {
    override fun eat() {
        println("PrintingFishAction: $food")
    }
}

class SomeUniqueFish(fishColor2: FishColor2 = GoldColor) :
    FishAction2 by PrintingFishAction("nice food"),
    FishColor2 by fishColor2
// { // we don't even need the brackets

// we comment this because of by PrintingFishAction
//    override fun eat() {
//        println("eat fish eat")
//    }

// since we re using by GoldColor delegation
//    override val color: String
//        get() = "Gold"
//}

fun main() {
    delegateExample()
}

fun delegateExample() {
    val someUniqueFish = SomeUniqueFish()
    println("Fish has color: ${someUniqueFish.color}")
    someUniqueFish.eat()
}

