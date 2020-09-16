<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/04
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<%
    Object o = session.getAttribute("msg");
    if(o!=null) {
        String msg = (String) o;
        if (msg.equals("用户已在其他地方登录,再次点击\"登录\"将会下线其他的设备,在本页面重新登陆")
                || msg.equals("用户名或密码不正确")) {
            out.print(msg);
        }
    }
%>
<body>
<form action="uls" method="post">
    <p>
        用户名:
        <input type="text" name="uname" required>
    </p>
    <p>
        密码:
        <input type="password" name="pwd" required>
    </p>
    <input type="submit" value="登录">
</form>
<button onclick="f()">点我注册</button>
</body>
<script>
    function f() {
        window.location.href="create.jsp";
    }
</script>
</html>
