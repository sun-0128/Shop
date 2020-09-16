<%@ page import="_0604.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/05
  Time: 7:30
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
<h3>欢迎进入商家首页,:<%=name%></h3>
<a href="uzs">注销</a>
<a href="update.jsp">修改个人信息</a>
<a href="addGoods.jsp">新增商品</a>
<p>
    <a href="goodsList.jsp">展示商品(可删除和修改商品信息)</a>
</p>
<%--<p>--%>
    <%--<a href="/goosList_S">商品展示</a>--%>
<%--</p>--%>
</body>
</html>
