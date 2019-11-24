package udacity_kotlinBootcamp_course.beyond_basics

import java.util.*

class Puppy {

    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(12))
    }
}

fun main() {
    val puppy = Puppy()
    val someBook = Book(author = "Ashish", title = "Someone noone", year = "2021", pages = 120)

    while (someBook.pages > 0) {
        puppy.playWithBook(someBook)
        println("pages remaining: ${someBook.pages}")
    }
}