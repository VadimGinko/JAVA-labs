package by.ginko.one;

import by.ginko.one.bl.Log;
import by.ginko.one.bl.Util;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        String DB_URL = "jdbc:mysql://localhost:3306/servlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String DB_NAME = "root";
        String DB_PASSWORD = "6788393vadim";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Newspaper> list = new ArrayList<Newspaper>();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT * from newspapers");
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Newspaper def = new Newspaper();
                def.NewspaperName = res.getString("NewspaperName");
                def.NewspaperType = res.getString("NewspaperType");
                list.add(def);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Log log = new Log("log.txt");
        ServiceWeather spam = new ServiceWeather(log);
        var u = spam.read("Minsk");
        spam.a1("Minsk");
        spam.a2(22);
        spam.a3("russian");
        spam.a4(500);
        spam.closeConnection();
        spam.log.close();

//        int sum = 2;
//
//        Connection connectionFrom = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "6788393vadim");
//        connectionFrom.setAutoCommit(false);
//
//        Connection connectionTo = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/mars?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "6788393vadim");
//        connectionTo.setAutoCommit(false);
//
//        try {
//            if (sum <= 0) {
//                throw new NumberFormatException("less or equals zero");
//            }
//            Statement stFrom = connectionFrom.createStatement();
//            Statement stTo = connectionTo.createStatement();
//            ResultSet rsFrom = stFrom.executeQuery("SELECT temperature from weather");
//            ResultSet rsTo = stTo.executeQuery("SELECT temperature from weater");
//            int accountFrom = 0;
//            while (rsFrom.next()) {
//                accountFrom = rsFrom.getInt(1);
//            }
//            int resultFrom = 0;
//            if (accountFrom >= sum) {
//                resultFrom = accountFrom - sum;
//            } else {
//                throw new SQLException("Invalid balance");
//            }
//            int accountTo = 0;
//            while (rsTo.next()) {
//                accountTo = rsTo.getInt(1);
//            }
//            int resultTo = accountTo + sum;
//            stFrom.executeUpdate(
//                    "UPDATE weather SET temperature=" + resultFrom);
//            stTo.executeUpdate("UPDATE weater SET temperature=" + resultTo);
//            connectionFrom.commit();
//            connectionTo.commit();
//            System.out.println("remaining on :" + resultFrom + " temp");
//        } catch (SQLException e) {
//            System.err.println("SQLState: " + e.getSQLState() + "Error Message: " + e.getMessage());            // откат транзакции при ошибке
//        }
    }
}
