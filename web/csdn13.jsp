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
    <title>刷新博客访问</title>
    <meta http-equiv="refresh" content="5">
</head>
<body>
</body>
<script language="JavaScript">
       var a=window.open("https://blog.csdn.net/sun_0128/article/details/107092186");
        function x() {
            a.close();
        }
        setTimeout("x()",4000);
</script>
</html>
