import java.util.Date;

public class Book {
    private Integer id;
    private String bookName;
    private Author author;
    private Genre genre;
    private String ISBN;
    private java.util.Date printDate;

    public Book(Integer id, String bookName, Author author, Genre genre, String ISBN, Date printDate) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.ISBN = ISBN;
        this.printDate = printDate;
    }

    public Book(Integer id, String bookName, Genre genre, String ISBN, Date printDate) {
        this.id = id;
        this.bookName = bookName;
        this.genre = genre;
        this.ISBN = ISBN;
        this.printDate = printDate;
    }

    public Book() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    @Override
    public String toString() {
        return "Book[" + "id: " + id + ", bookName: " + "\"" + bookName + "\"" + ", author: " + author + ", genre: " + genre +
                ", ISBN: " + ISBN +
                ", printDate: " + printDate +
                ']';
    }
}
