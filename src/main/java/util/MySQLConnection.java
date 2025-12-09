package util;

import java.sql.*;

public class MySQLConnection {

            private static final String url = "jdbc:mysql://jakeslimenetworks.nn.pe:3306/jakeslim_fitnessapp";
            private static final String user = "jakeslim_rasull";
            private static final String password = "6y@d#BmbiZR(Z#7P";

            public static Connection getConnection() throws SQLException{
                return DriverManager.getConnection(url, user, password);
            }
}
