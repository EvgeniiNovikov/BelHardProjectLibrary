import java.sql.*;

public class ConnectionRunner {
    private static final String HOST = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "220028";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    static {
        System.out.println("ВАЖНО! Дата задается в таком формате yyyy-mm-dd");
    }

    public ConnectionRunner() {
        try {
            connection = DriverManager.getConnection(HOST, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
