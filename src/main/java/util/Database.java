// Rasull
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String url = "jdbc:sqlite:exercises.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
