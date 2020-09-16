<%@ page import="_0604.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/05
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--判断如果登录的账号已在线提示,并且注销该用户--%>
<%
    Object msg = session.getAttribute("msg");
    String m = (String) msg;
    session.setAttribute("msg",m);
    out.print(msg.toString());
    Object u = session.getAttribute("user");
    User user = (User) u;
    session.setAttribute("user",user);
    response.sendRedirect("uzs");
%>
</body>
</html>
