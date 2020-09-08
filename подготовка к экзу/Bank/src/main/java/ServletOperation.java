import model.ConnectClass;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import org.apache.log4j.Logger;
@WebServlet(name = "ServletOperation", urlPatterns = "/ServletOperation")
public class ServletOperation extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Servlet.class));
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int balance;
        int amount = Integer.parseInt(request.getParameter("amount"));
        String login = request.getSession().getAttribute("name").toString();
        Connection connection = null;
        try {
            PreparedStatement statement;
            try {
                connection = ConnectClass.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String data = "SELECT sum FROM bankk WHERE login = " + "'" + login + "'";
            statement = connection.prepareStatement(data);
            ResultSet res = statement.executeQuery();
            res = statement.executeQuery(data);
            res.next();
            balance = res.getInt("sum");

            if (balance >= amount) {
                statement.executeUpdate("UPDATE bankk SET sum = sum - " + amount + " WHERE login = " + "'" + login + "'");
                LOGGER.info(new java.util.Date().toString() + " " + login + " took " + amount + ". Balance: " + (balance - amount));
            }
            else
            {
                throw new IOException("no money");
            }

            response.sendRedirect(request.getContextPath() + "/operation");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
