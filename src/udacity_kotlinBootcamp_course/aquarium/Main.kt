package udacity_kotlinBootcamp_course.aquarium

fun main(args: Array<String>) {
    buildAquarium()
    makeFish()

    // testing feedFish
    val sampleFish = Dolphin()
    feedFish(sampleFish)
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

// one the classes that implement FishAction interface can can be passed to this function
private fun feedFish(fish: FishAction) {
    fish.eat()
}

private fun makeFish() {
    val shark = Shark()
    val dolphin = Dolphin()

    println("Colors for shark is ${shark.fishColor}, dolphin is ${dolphin.fishColor}")

    shark.eat()
    dolphin.eat()

}