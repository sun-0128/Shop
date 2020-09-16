<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/07/04
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<meta http-equiv="refresh" content="20">
<button onclick="f1()"> 点我</button>
</body>
<script language="JavaScript">
    var a=window.open("https://blog.csdn.net/sun_0128/article/details/106849685");
    // setTimeout(4000);
    // a.close();
    function x() {
        a.close();
    }
    setTimeout("x()",4000);
</script>
</html>
