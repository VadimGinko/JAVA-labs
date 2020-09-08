<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="model.ConnectClass" %><%--
  Created by IntelliJ IDEA.
  User: Unix
  Date: 23.06.2020
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
     Connection connection;
    Statement statement;
    ResultSet resultSet;

    connection = ConnectClass.getConnection();
    statement = connection.createStatement();
    String data = "SELECT * FROM bankk WHERE login = " + "'" + request.getSession().getAttribute("name").toString() + "'";
    resultSet = statement.executeQuery(data);
    resultSet.next();
    int balance = resultSet.getInt("sum");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Balance</title>
</head>
<body>
<h1>Your balance: <%= balance%></h1>
<button onclick="location.href='operation.jsp'">Back</button>
</body>
</html>
