<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/04
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<h3>******欢迎注册******</h3>
<form action="usc" method="get">
    <p>
        用户名:
        <input type="text" name="uname" required>
    </p>
    <p>
        昵称:
        <input type="text" name="nickName" required>
    </p>
    <p>
        密码:
        <input type="password" name="pwd" required>
    </p>
    <p>
    <input type="radio" name="juese" value="买家" checked>买家
    <input type="radio" name="juese" value="商家">商家
    </p>
    <p>
        手机号码:
        <input type="text" name="phone" maxlength="11" required>
    </p>
    <p>
        地址:
        <input type="text" name="address" required >
    </p>
    <p>
        身份证号码:
        <input type="text" name="IDcard" maxlength="18">
    </p>
    <input type="submit" value="用户注册">
</form>
</body>
</html>
