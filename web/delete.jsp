<%@ page import="_0604.dao.UserDao" %>
<%@ page import="_0604.dao.impl.UserDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/05
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    UserDao dao = new UserDaoImpl();
    String s = request.getParameter("id");
    String sql ="delete from user where uid = ?";
    Object[] params = {s};
    ((UserDaoImpl) dao).executeUpdate(sql,params);

%>
</body>
</html>
