<%@ page import="_0604.dao.UserDao" %>
<%@ page import="_0604.dao.impl.UserDaoImpl" %>
<%@ page import="_0604.dao.impl.GoodsDaoImpl" %>
<%@ page import="_0604.pojo.Goods" %><%--
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
    String s = request.getParameter("id");
    session.setAttribute("goodsId",s);
    GoodsDaoImpl dao = new GoodsDaoImpl();
    Goods goods = dao.queryByGoodsId(Integer.valueOf(s));
    String name = goods.getGoodsName();
%>
<h3>购买该商品&quot;<%=name%>&quot;</h3>
<form action="goumaiGS" method="post">
    <p>
        购买数量:
        <input type="text" name="buyNum" required>
    </p>
    <input type="submit" value="确认购买">
</form>
</body>
</html>
