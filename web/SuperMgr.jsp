<%@ page import="_0604.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/05
  Time: 7:28
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
    User user= (User) o;
    String name = user.getNickName();
%>
<h3>欢迎进入超级管理员页面:<%=name%></h3>
<a href="userList.jsp">展示所有用户</a>
<a href="uzs">注销</a>
</body>
</html>
