<%@ page import="_0604.pojo.Goods" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/07
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试cforeach获取订单列表</title>
</head>
<body>
<%--<%--%>
    <%--List<Goods> goodsList = (List<Goods>) session.getAttribute("goodsLsit111");--%>
<%--%>--%>
<table border="1">
    <tr>
        <th>订单id</th>
        <th>买家id</th>
        <th>商品id</th>
        <th>购买数量</th>
        <th>总价</th>
        <th>订单类型</th>
    </tr>
    <c:if test="${orderList!=null}">
        <c:forEach items="${orderList}" var="orders">
            <%--${goods}--%>
            <tr>
                <td>${orders.orderId}</td>
                <td>${orders.buyerId}</td>
                <td>${orders.goodsId}</td>
                <td>${orders.buyNum}</td>
                <td>${orders.totalPrice}</td>
                <td>${orders.orderType}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
