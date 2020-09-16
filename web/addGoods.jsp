<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/06
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<h3>******添加商品******</h3>
<form action="ags" method="post">
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
    <input type="submit" value="确认添加">
</form>
</body>
</html>
