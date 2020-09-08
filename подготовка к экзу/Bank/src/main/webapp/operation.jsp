<%--
  Created by IntelliJ IDEA.
  User: Unix
  Date: 23.06.2020
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Balance</title>
</head>
<body>
<form action="ServletOperation" method="post">
    <input type="text" name="amount" placeholder="amount"/>
    <input type="submit" value="operation"/>
</form>
<button onclick="location.href='balance.jsp'">Check balance</button>
<button onclick="location.href='/wer'">Exit</button>
</body>
</html>