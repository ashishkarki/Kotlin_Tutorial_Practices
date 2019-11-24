package udacity_kotlinBootcamp_course.beyond_basics

val book1 = Book(author = "Dalai Lama", title = "Book of Joy", year = "2005")
val book2 = Book(author = "Shiv Khera", title = "You can Win", year = "2010")
val book3 = Book(author = "William Shakespear", title = "Hamlet", year = "1830")

val allBooks = setOf(book1, book2, book3)
val library = mapOf(
    "Dalai Lama" to book1,
    "Shiv Khera" to book2,
    "William Skakespear" to book3
)

val moreBooks = mutableMapOf<String, Book>()

fun collectionUser() {
    println("allBooks: $allBooks")
    println("library: $library")
    println("moreBooks: $moreBooks")

    val isHamletPresent = library.any { it.value.title == "Hamlet" }
    println("isHamletPresent: $isHamletPresent")

    moreBooks["Ashish K"] = Book(author = "Ashish K", title = "Hero to Zero", year = "2021")
    moreBooks.getOrPut("Ram Kale") { Book(author = "Ram Kale", title = "Laddu lal", year = "0001") }
    println("moreBooks: $moreBooks")
}

fun main() {
    collectionUser()
}