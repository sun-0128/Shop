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
    <title>测试cforeach获取商品列表</title>
</head>
<body>
<%--<%--%>
    <%--List<Goods> goodsList = (List<Goods>) session.getAttribute("goodsLsit111");--%>
<%--%>--%>
<table border="1">
    <tr>
        <th>序号</th>
        <th>商品名称</th>
        <th>单价</th>
        <th>库存</th>
        <th>商家名称</th>
        <th>商品描述</th>
    </tr>
    <c:if test="${goodsList1!=null}">
        <c:forEach items="${goodsList1}" var="goods">
            <%--${goods}--%>
            <tr>
                <td>${goods.goodsId}</td>
                <td>${goods.goodsName}</td>
                <td>${goods.price}</td>
                <td>${goods.storeNum}</td>
                <td>${goods.shopName}</td>
                <td>${goods.goodsDescription}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
