<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/07
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>演示c标签的用法</title>
</head>
<body>
<c:set var="abc" scope="session" value="${1}"></c:set>
<c:if test="${abc==1}" var="a">
    <h1><c:out value="${abc}"></c:out></h1>
    <h1><c:out value="${a}"></c:out></h1>
</c:if>
<%--items是要遍历的集合对象 var是集合的内容--%>
<c:forEach items=""></c:forEach>
</body>
</html>
