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
<h3>欢迎进入买家首页:<%=name%></h3>
<a href="uzs">注销</a>
<a href="update.jsp">修改个人信息</a>
<p>

</p>
<p>
<form action="goodsListByName.jsp">
    请输入查询内容:
    <input type="text" name="goodsName">
    <input type="submit" value="点我查询">
</form>
</p>
<p>
    <a href="goodsList_All.jsp">查看全部商品</a>
</p>
<p><a href="/queryOrderS">查看自己购买的订单</a></p>
<p>
    <a href="/goosList_S">商品展示(罗)</a>
</p>
</body>
</html>
