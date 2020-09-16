<%@ page import="_0604.dao.UserDao" %>
<%@ page import="_0604.dao.impl.UserDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/05
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>******请填写修改后的信息******</h3>
<form action="uus" method="post">
    <p>
        昵称:
        <input type="text" name="nickName" required>
    </p>
    <p>
        手机号码:
        <input type="text" name="phone" maxlength="11" required>
    </p>
    <p>
        地址:
        <input type="text" name="address" required >
    </p>
    <input type="submit" value="修改">
</form>
</body>
</html>
