package udacity_kotlinBootcamp_course.game

enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
    var path = mutableListOf<Directions>(Directions.START)

    var north = { path.add(Directions.NORTH) }
    var south = { path.add(Directions.SOUTH) }
    var east = { path.add(Directions.EAST) }
    var west = { path.add(Directions.WEST) }

    var end = {
        path.add(Directions.END)
        println("Game Over!!")
        println("path is $path")
        path.clear()
        false
    }
}

fun main() {
    val game = Game()
    println("Initial path: ${game.path}")

    game.north()
    game.south()
    game.east()
    game.west()
    game.end()

    println("Final path: ${game.path}")
}