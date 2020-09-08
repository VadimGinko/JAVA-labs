package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectClass {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank?autoReconnect=true&useSSL=false";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "6788393vadim";


    public static Connection getConnection() throws IOException, SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
        }
        catch (SQLException e)
        {   }
        return connection;
    }
    public static void closeConnection(Connection s) throws SQLException {
        s.close();
    }
}
