package udacity_kotlinBootcamp_course

fun main(args: Array<String>) {
    println(whatShouldIDoToday())
}

fun whatShouldIDoToday(mood: String = getUserMood(), weather: String = "Sunny", temperature: Int = 24): String {
    fun happySunny(mood: String, weather: String) = mood == "happy" && weather == "Sunny"
    fun sadRainyTempZero(mood: String, weather: String, temperature: Int) =
        mood == "sad" && weather == "rainy" && temperature == 0

    fun temp35(temperature: Int) = temperature > 35

    return when {
        happySunny(mood, weather) -> "go for a walk"
        sadRainyTempZero(mood, weather, temperature) -> "stay in bed"
        temp35(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}

fun getUserMood(): String {
    print("what is your mood?")
    return readLine().toString()
}