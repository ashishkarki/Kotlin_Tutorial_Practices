package udacity_kotlinBootcamp_course

import java.util.*


fun main(args: Array<String>) {
    lambdaExamples()
}

val randomNumber = 5
fun lambdaExamples() {
    val rollDiceLambda = { sides: Int -> if (sides == 0) 0 else Random().nextInt(sides) + 1 }
    println("rolling random die: ${rollDiceLambda(randomNumber)}")

    val rollDiceLambdaWithType: (Int) -> Int = { sides -> if (sides == 0) 0 else Random().nextInt(sides) + 1 }
    println("rolling random die: ${rollDiceLambdaWithType(randomNumber)}")

    fun rollDiceFunctionType(sides: Int) = if (sides == 0) 0 else Random().nextInt(sides) + 1
    println("rolling random die: ${rollDiceFunctionType(randomNumber)}")

    gamePlay(rollDiceLambda)
    gamePlay(rollDiceLambdaWithType)
    gamePlay(::rollDiceFunctionType)

    gamePlay(rollDiceLambdaWithType(randomNumber))
}

fun gamePlay(rollOfADice: (Int) -> Int) {
    println("game  play accepting lambda: ${rollOfADice.invoke(randomNumber)}")
}

fun gamePlay(diceRoll: Int) {
    // do something with the dice roll
    println("game  play accepting simple Int: $diceRoll")
}