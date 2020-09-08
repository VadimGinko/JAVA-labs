<%--
  Created by IntelliJ IDEA.
  User: Unix
  Date: 23.06.2020
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = pageContext.getException().getMessage();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<h2 style="color: red">Ooops... Exception occurred while processing the request</h2>
<p class="information">Message: <%= message %></p>

</html>
