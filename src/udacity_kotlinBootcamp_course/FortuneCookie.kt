package udacity_kotlinBootcamp_course

fun main(args: Array<String>) {
    for (i in 1..10) {
        val myFortune = getFortuneCookie()
        println("Your fortune is: $myFortune")

        if (myFortune == "You are cool") break
    }
}

fun getFortuneCookie(): String {
    val fortunes: List<String> = listOf("Great day", "You are cool", "Find the challenge", "Be patient")

    return when (val birthday = getBirthday()) {
        28 or 31 -> fortunes[1]
        in 1..10 -> fortunes[fortunes.size - 1]
        else -> fortunes[birthday.rem(fortunes.size)]
    }
}

fun getBirthday(): Int {
    print("Enter your birthday: ")

    return readLine()?.toIntOrNull() ?: 1
}