<%@ page import="_0604.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/06
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object o=session.getAttribute("user");
    String name = ((User)o).getNickName();
%>
<p>
    <%=name%>,您好,添加或修改商品成功!
</p>
<a href="shangjiaIndex.jsp">返回首页</a>
</body>
</html>
