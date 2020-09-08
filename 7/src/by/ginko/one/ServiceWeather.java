package by.ginko.one;

import by.ginko.one.bl.Log;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.ginko.one.bl.Util.getConnection;

public class ServiceWeather implements Daotest {
    Log log;
    Connection connection;

    final String zapros1 = "Вывести сведения о погоде в заданном регионе.";
    final String zapros2 = "Вывести даты, когда в заданном регионе шел снег и температура была\n" +
            "ниже заданной отрицательной.";
    final String zapros3 = "Вывести информацию о погоде за прошедшую неделю в регионах,\n" +
            "жители которых общаются на заданном языке.";
    final String zapros4 = "Вывести среднюю температуру за прошедшую неделю в регионах с\n" +
            "площадью больше заданной.";

    ServiceWeather(Log log) throws IOException {
        this.log = log;
        connection = getConnection(log);
        if(log != null)
            log.Writelog("соединение установлено");
    }

    @Override
    public Weather read(String region) throws SQLException {
        Weather spam = new Weather();
        PreparedStatement preparedStatement = null;
        String zap = String.format("Select region, date, temperature, precipitation FROM weather where region = '%s';", region);
        try{
            preparedStatement = connection.prepareStatement(zap);
            ResultSet i = preparedStatement.executeQuery();
            log.Writelog("Запрос: "+ zapros1 + " выполнен");
            i.next();
            spam.temperature = i.getInt("temperature");
            spam.region = i.getString("region");
            spam.date = String.valueOf(i.getDate("date"));
            spam.precipitation = i.getString("precipitation");
        }
        catch (SQLException | IOException e)
        {
            System.out.println("тылох");
        }
        finally {
            if(preparedStatement != null)
                preparedStatement.close();
            return spam;
        }
    }

    @Override
    public void a1(String region) throws SQLException {
        PreparedStatement preparedStatement = null;
        String zap = String.format("Select temperature FROM weather where region = '%s';", region);
        try{
            preparedStatement = connection.prepareStatement(zap);
            ResultSet i = preparedStatement.executeQuery();
            log.Writeline();
            log.Writelog("Запрос: "+ zapros1 + " выполнен");
            log.Writelog("Результаты: ");
            while(i.next())
            {
                var res = i.getLong("temperature");
                log.Writelog(String.valueOf(res));
            }
            log.Writeline();
        }
        catch (SQLException | IOException e)
        {
            System.out.println("тылох");
        }
        finally {
            if(preparedStatement != null)
                preparedStatement.close();
        }
    }

    @Override
    public void a2(int temp) throws SQLException {
        PreparedStatement preparedStatement = null;
        String zap = String.format("Select date FROM weather WHERE precipitation = 'snow' and temperature < %s", temp);
        try{
            preparedStatement = connection.prepareStatement(zap);
            ResultSet i = preparedStatement.executeQuery();
            log.Writeline();
            log.Writelog("Запрос: "+ zapros1 + " выполнен");
            log.Writelog("Результаты: ");
            while(i.next())
            {
                var date = i.getDate("date");
                log.Writelog(String.valueOf(date));
            }
            log.Writeline();
        }
        catch (SQLException | IOException e)
        {
            System.out.println("тылох");
        }
        finally {
            if(preparedStatement != null)
                preparedStatement.close();
        }
    }

    @Override
    public void a3(String language) throws SQLException {
        PreparedStatement preparedStatement = null;
        String zap = String.format("Select temperature, precipitation FROM weather where date >  NOW() - interval 7 day and weather.date in ( select  weather.date from weather join region on weather.region = region.name join typeofpeople on region.typeofpeople = typeofpeople.namepeople where language like '%s');", language);
        try{
            preparedStatement = connection.prepareStatement(zap);
            ResultSet i = preparedStatement.executeQuery();
            log.Writeline();
            log.Writelog("Запрос: "+ zapros1 + " выполнен");
            log.Writelog("Результаты: ");
            while(i.next())
            {
                var temp = i.getLong("temperature");
                var prec = i.getString("precipitation");
                log.Writelog(String.valueOf(temp));
                log.Writelog(String.valueOf(prec));
            }
            log.Writeline();
        }
        catch (SQLException | IOException e)
        {
            System.out.println("тылох");
        }
        finally {
            if(preparedStatement != null)
                preparedStatement.close();
        }
    }

    @Override
    public void a4(int area) throws SQLException {
        PreparedStatement preparedStatement = null;
        String zap = String.format("SELECT avg(temperature) FROM weather join region on weather.region = region.name where area > %S", area);
        try{
            preparedStatement = connection.prepareStatement(zap);
            ResultSet i = preparedStatement.executeQuery();
            log.Writeline();
            log.Writelog("Запрос: "+ zapros1 + " выполнен");
            log.Writelog("Результаты: ");
            while(i.next())
            {
                var temp = i.getLong("avg(temperature)");
                log.Writelog(String.valueOf(temp));
            }
            log.Writeline();
        }
        catch (SQLException | IOException e)
        {
            System.out.println("тылох");
        }
        finally {
            if(preparedStatement != null)
                preparedStatement.close();
        }
    }
    public void closeConnection() throws SQLException, IOException {
        connection.close();
        log.Writelog("connection close");
    }
}
