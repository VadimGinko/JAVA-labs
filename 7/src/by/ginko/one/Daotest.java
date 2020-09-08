package by.ginko.one;

import java.sql.SQLException;

public interface Daotest {
    Weather read(String region) throws SQLException;
    void a1(String region) throws SQLException;
    void a2(int temp) throws SQLException;
    void a3(String language) throws SQLException;
    void a4(int area) throws SQLException;
}
