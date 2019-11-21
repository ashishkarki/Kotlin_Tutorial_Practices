package udacity_kotlinBootcamp_course.book

open class Book(var title: String = "some title", var author: String = "some author") {
    private var currentPage: Int = 1;

    open fun readPage() {
        currentPage++;
    }
}

class eBook(title: String, author: String, var format: String = "text") : Book(title, author) {
    private var wordCount: Int = 0;

    override fun readPage() {
        wordCount += 250;
    }
}

fun main(args: Array<String>) {
    val eBook1 = eBook(title = "my experiment with truth", author = " M G Gandhi")
}