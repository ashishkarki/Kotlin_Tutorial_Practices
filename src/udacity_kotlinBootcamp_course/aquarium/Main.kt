package udacity_kotlinBootcamp_course.aquarium

fun main(args: Array<String>) {
    buildAquarium()
}

private fun buildAquarium() {
    val myAquarium = Aquarium()

    println("volume using function: ${myAquarium.calculateVolume()}")
    println("Volume using getter before setting: ${myAquarium.volume}")
    myAquarium.volume = 5
    println("Volume using getter after setting: ${myAquarium.volume}")

    // aquarium with parameters
    val aquariumWithParams = Aquarium(length = 20, width = 20, height = 20)
    println("Volume using parameters: ${aquariumWithParams.volume}")

    // using a different argument constructor
    val aquariumWithNoOfFish = Aquarium(noOfFish = 20)
    println("Volume using noOfFish constructor: ${aquariumWithNoOfFish.volume}")
}