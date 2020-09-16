<%@ page import="_0604.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/04
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object o=session.getAttribute("user");
    String name = ((User)o).getNickName();
%>
<p>
    <%=name%>,欢迎登录!
</p>
<a href="userSend">进入首页</a>
</body>
</html>
