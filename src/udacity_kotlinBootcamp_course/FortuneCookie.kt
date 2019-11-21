package udacity_kotlinBootcamp_course

fun main(args: Array<String>) {
    loopWithFor(10)
    loopWithRepeat(10)
    loopWithWhile(times = 10)
}

fun loopWithRepeat(times: Int) {
    println("from inside loopWithRepeat")
    repeat(times) {
        val myFortune = fortuneGetterPrinter()

        if (myFortune == "You are cool") return
    }
}

fun loopWithFor(times: Int) {
    println("from inside loopWithFor")
    for (i in 1..times) {
        val myFortune = fortuneGetterPrinter()

        if (myFortune == "You are cool") break
    }
}

fun loopWithWhile(times: Int) {
    println("from inside loopWithWhile")
    var i = 1
    while (i <= times) {
        val myFortune = fortuneGetterPrinter()

        if (myFortune == "You are cool") break

        i++
    }
}

fun fortuneGetterPrinter(): String {
    val myFortune = getFortuneCookie()
    println("Your fortune is: $myFortune")

    return myFortune
}

fun getFortuneCookie(): String {
    val fortunes: List<String> = listOf("Great day", "You are cool", "Find the challenge", "Be patient")

    return when (val birthday = getBirthday()) {
        28, 31 -> fortunes[1]
        in 1..10 -> fortunes[fortunes.size - 1]
        else -> fortunes[birthday.rem(fortunes.size)]
    }
}

fun getBirthday(): Int {
    print("Enter your birthday: ")

    return readLine()?.toIntOrNull() ?: 1
}