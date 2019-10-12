import java.sql.*;
import java.sql.Date;
import java.util.*;

public class CRUD {
    //добавляем поле в таблице Author
    public static void insertAuthorDBFields(Connection connection, String name, String date) {
        String authorDB = "INSERT INTO author (name, birth_date) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(authorDB);
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, Date.valueOf(date));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //удаляем автора из таблицы Author
    public static void deleteAuthorFromDB(Connection connection, int id) {
        String authorId = "DELETE FROM author WHERE id=" + id + "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(authorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //обновляем поле в таблице Author по его id
    public static void updateAuthorIntoDb(Connection connection, String name, String date, int id) {
        String authorDB = "UPDATE author SET name='" + name + "', birth_date='" + date + "'WHERE id=" + id + ";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(authorDB);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //добавляем поле в таблице Book
    public static void insertBookDBFields(Connection connection, String book_name, int author_id, int genre_id, String isbn, String date) {
        String bookDB = "INSERT INTO book (book_name, author_id, genre_id, isbn, print_date) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(bookDB);
            preparedStatement.setString(1, book_name);
            preparedStatement.setInt(2, author_id);
            preparedStatement.setInt(3, genre_id);
            preparedStatement.setString(4, isbn);
            preparedStatement.setDate(5, Date.valueOf(date));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //удаляем книгу из таблицы Book по id
    public static void deleteFromBookDB(Connection connection, int id) {
        String bookDelete = "DELETE FROM book WHERE id=" + id + ";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(bookDelete);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //обновляем поле в таблице Book по его id
    public static void updateBookFromDB(Connection connection, String book_name, int author_id, int genre_id, String isbn, String date, int id) {
        String updateBook = "UPDATE book SET book_name='" + book_name + "', author_id=" + author_id +
                ", genre_id=" + genre_id + ", isbn=" + isbn + ", print_date='" + date + "' WHERE id=" + id + ";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateBook);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //обновление жанра
    public static void updateGenreFromDB(Connection connection, Genre genre, int id) {
        String updateGenre = "UPDATE genre SET name='" + genre + "' WHERE id=" + id + ";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateGenre);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //удаляем жанр из таблицы genre
    public static void deleteGenreFromDB(Connection connection, int id) {
        String deleteGenre = "DELETE from genre WHERE id=" + id + ";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteGenre);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //читаем авторов из базы
    public static List<Author> readAuthorsFromDB(ConnectionRunner connection) {
        List<Author> authors = new LinkedList<Author>();
        String selectAuthors = "SELECT * FROM author;";
        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(selectAuthors);
            while (resultSet.next()) {
                Author author = new Author();
                Set<Book> books = new HashSet<>();
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
                author.setBirthDate(resultSet.getDate("birth_date"));
                author.setBooks(books);
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    //читаем книги из базы и сетаем авторов
    public static Set<Book> readBooksFromDB(ConnectionRunner connection, List<Author> list) {
        Set<Book> books = new LinkedHashSet<>();
        String selectBooks = "SELECT * FROM book;";
        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(selectBooks);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setAuthor(list.get(resultSet.getInt("author_id") - 1));
                book.setBookName(resultSet.getString("book_name"));
                book.setGenre(Genre.get(resultSet.getString("genre_id")));
                book.setISBN(resultSet.getString("isbn"));
                book.setPrintDate(resultSet.getDate("print_date"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    //читаем книги по id автора
    public static Set<Book> bookForAuthor(ConnectionRunner connection, int authorId) {
        Set<Book> books = new LinkedHashSet<>();
        String bookDB = "select * from book where author_id=" + authorId + ";";
        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(bookDB);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setGenre(Genre.get(resultSet.getString("genre_id")));
                book.setISBN(resultSet.getString("isbn"));
                book.setPrintDate(resultSet.getDate("print_date"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

}
