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
    <title>展示某商家的全部商品</title>
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
            <th>删除商品操作</th>
            <th>修改商品操作</th>
        </tr>
        <%
            GoodsDaoImpl dao = new GoodsDaoImpl();
            User user= (User) session.getAttribute("user");
            List<Goods> list=dao.queryAll(user);
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
            <td><a href="" onclick="f1(<%=list.get(i).getGoodsId()%>)">删除商品</a></td>
            <td><a href="updateGoods.jsp?id2=<%=list.get(i).getGoodsId()%>" onclick="f2(<%=list.get(i).getGoodsId()%>)">修改商品</a></td>
        </tr>
<%
    }
%>
</table>
</body>
<script>
    function f1(id) {
        window.location.href="deleteGoods.jsp?id="+id;
    }
    function f2(id2) {
    }
</script>
</html>
