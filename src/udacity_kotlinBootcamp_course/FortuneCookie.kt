package udacity_kotlinBootcamp_course

fun main(args: Array<String>) {
    for (i in 1..10) {
        val myFortune = getFortuneCookie()
        print("Your fortune is: $myFortune")

        if (myFortune == "You are cool") break
    }
}

fun getFortuneCookie(): String {
    val fortunes: List<String> = listOf("Great day", "You are cool", "Find the challenge", "Be patient")

    print("Enter your birthday")
    val birthday: Int = readLine()?.toIntOrNull() ?: 1
    return fortunes[birthday.rem(fortunes.size)]
}