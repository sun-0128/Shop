<%@ page import="_0604.dao.impl.UserDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="_0604.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/06/05
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示除管理员外的用户</title>
</head>
<body>
<table border="1">
        <tr>
            <th>用户id</th>
            <th>用户名称</th>
            <th>昵称</th>
            <th>密码</th>
            <th>登录状态</th>
            <th>角色id</th>
            <th>手机号</th>
            <th>地址</th>
            <th>身份证号码</th>
            <th>删除操作</th>
        </tr>
        <%
            UserDaoImpl userDao = new UserDaoImpl();
            List<User> list=userDao.getAllUser();
            for (int i = 0; i < list.size(); i++) {
        %>
        <tr>
            <td><%=list.get(i).getUid()%></td>
            <td><%=list.get(i).getUname()%></td>
            <td><%=list.get(i).getNickName()%></td>
            <td><%=list.get(i).getPassword()%></td>
            <td><%=list.get(i).getLoginStatus()%></td>
            <td><%=list.get(i).getRoleId()%></td>
            <td><%=list.get(i).getPhone()%></td>
            <td><%=list.get(i).getAddress()%></td>
            <td><%=list.get(i).getIDcard()%></td>
            <td><a href="" onclick="f1(<%=list.get(i).getUid()%>)">删除用户</a></td>
        </tr>
<%
    }
%>
</table>
</body>
<script>
    function f1(id) {
        window.location.href="delete.jsp?id="+id;
    }
</script>
</html>
