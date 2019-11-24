package udacity_kotlinBootcamp_course.beyond_basics

const val max_books_to_borrow = 10

class Book(val author: String, val title: String, val year: String, var pages: Int = 50) {

    companion object BookConstants {
        const val BASE_URL = "https://goodlibrary.com"
    }

    fun canBorrow(userBorrowedNumber: Int): Boolean {
        return userBorrowedNumber <= max_books_to_borrow
    }

    fun printUrl() {
        println("Book URL is ${BookConstants.BASE_URL + title + ".html"}")
    }
}

fun Book.weight() = pages * 1.5

fun Book.tornPages(numOfTornPages: Int = 0) = if (pages >= numOfTornPages) pages -= numOfTornPages else pages = 0

fun getAuthorTitlePair(book: Book): Pair<String, String> {
    return (book.author to book.title)
}

fun getAuthTitleYearTriple(book: Book): Triple<String, String, String> {
    return Triple(book.author, book.title, book.year)
}

fun main() {
    val myBook = Book("Ashish Karki", "How did I become so handsome", "2020")

    val (author, title) = getAuthorTitlePair(myBook)
    println("author is $author and title is $title")
    val bookAuthorTitle = getAuthorTitlePair(myBook)
    println("author is ${bookAuthorTitle.first} and title is ${bookAuthorTitle.second}")

    val (author2, title2, year2) = getAuthTitleYearTriple(myBook)
    println("author is $author2 and title is $title2 published in year: $year2")
    val bookAuthorTitleYear = getAuthTitleYearTriple(myBook)
    println(
        "author is ${bookAuthorTitleYear.first} and title is ${bookAuthorTitleYear.second} " +
                "published in year: ${bookAuthorTitleYear.third}"
    )
}