<%@ page import="_0604.dao.UserDao" %>
<%@ page import="_0604.dao.impl.UserDaoImpl" %>
<%@ page import="_0604.dao.impl.GoodsDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/05
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除商品</title>
</head>
<body>
<%
    GoodsDaoImpl dao = new GoodsDaoImpl();
    String s = request.getParameter("id");
    String sql ="delete from goods where goodsid = ?";
    Object[] params = {s};
    dao.executeUpdate(sql,s);
    response.sendRedirect("goodsList.jsp");
%>
</body>
</html>
