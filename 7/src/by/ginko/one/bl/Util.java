package by.ginko.one.bl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "pass";


    public static Connection getConnection(Log log) throws IOException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
            log.Writelog("Connection OK");
        }
        catch (SQLException | IOException e)
        {
            log.Writelog("Connection LOST");
        }
        return connection;
    }
    public static void closeConnection(Connection s) throws SQLException {
        s.close();
    }
}
