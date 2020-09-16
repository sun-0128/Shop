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
    GoodsDaoImpl dao = new GoodsDaoImpl();
    String s = request.getParameter("id2");
    session.setAttribute("goodsId",s);
%>
<h3>修改商品id为&quot;<%=s%>&quot;的商品信息</h3>
<form action="updateGS" method="post">
    <p>
        商品名:
        <input type="text" name="goodsName" required>
    </p>
    <p>
        价格:
        <input type="text" name="price" required>
    </p>
    <p>
        库存量:
        <input type="text" name="storeNum" required>
    </p>
    <p>
        商品描述:
        <input type="text" name="goodsDescription" required>
    </p>
    <input type="submit" value="确认修改">
</form>
</body>
</html>
