<%@ page import="_0604.dao.impl.UserDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="_0604.pojo.User" %>
<%@ page import="_0604.dao.impl.GoodsDaoImpl" %>
<%@ page import="_0604.pojo.Goods" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/05
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示模糊查询的商品</title>
</head>
<body>
<table border="1">
        <tr>
            <th>商品id</th>
            <th>商品名称</th>
            <th>单价/元</th>
            <th>库存</th>
            <th>状态</th>
            <th>商家id</th>
            <th>描述</th>
            <th>购买商品操作</th>
            <th>加入购物车操作</th>
        </tr>
        <%
            GoodsDaoImpl dao = new GoodsDaoImpl();
            String name = request.getParameter("goodsName");
            List<Goods> list=dao.queryGoodsByName(name);
            for (int i = 0; i < list.size(); i++) {
        %>
        <tr>
            <td><%=list.get(i).getGoodsId()%></td>
            <td><%=list.get(i).getGoodsName()%></td>
            <td><%=list.get(i).getPrice()%></td>
            <td><%=list.get(i).getStoreNum()%></td>
            <td><%=list.get(i).getGoodsStatus()%></td>
            <td><%=list.get(i).getShopId()%></td>
            <td><%=list.get(i).getGoodsDescription()%></td>
            <td><a href="goumaiGoods.jsp?id=<%=list.get(i).getGoodsId()%>" onclick="f1(<%=list.get(i).getGoodsId()%>)">购买商品</a></td>
            <td><a href="goodsCart.jsp?id=<%=list.get(i).getGoodsId()%>" onclick="f1(<%=list.get(i).getGoodsId()%>)">加入购物车</a></td>
        </tr>
<%
    }
%>
</table>
<a href="maijiaIndex.jsp">点击返回首页</a>
</body>
<script>
    function f1(id) {
    }
</script>
</html>
