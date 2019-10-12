import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MainRunner {
    public static void main(String[] args) throws SQLException {
        ConnectionRunner runner = new ConnectionRunner();
        //читаем всех авторов из базы
        List<Author> authorList = CRUD.readAuthorsFromDB(runner);
        //читаем все книги из базы и сетаем авторов
        Set<Book> bookSet = CRUD.readBooksFromDB(runner, authorList);
        print(authorList);
        print(bookSet);
        //берем все книги автора по его id
        Set<Book> authorBook1 = CRUD.bookForAuthor(runner, 1);
        Set<Book> authorBook2 = CRUD.bookForAuthor(runner, 2);
        Set<Book> authorBook3 = CRUD.bookForAuthor(runner, 3);
        Set<Book> authorBook4 = CRUD.bookForAuthor(runner, 4);

        //добавляем к каждому автору его книги
        authorList.get(0).setBooks(authorBook1);
        authorList.get(1).setBooks(authorBook2);
        authorList.get(2).setBooks(authorBook3);
        authorList.get(3).setBooks(authorBook4);


        runner.closeConnection();
    }

    public static void print(Collection collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
    }
}


