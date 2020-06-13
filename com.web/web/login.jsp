<%--
  Created by IntelliJ IDEA.
  User: 陆远
  Date: 2020/6/13
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style>
        #error {
            color: red;
        }
    </style>
</head>
<body>
<form action="/LoginServlet" method="post">
    <div>用户名：<input type="text" name="username"></div>
    <div>密码：<input type="password" name="password"></div>
    <div>验证码（默认aaaa）：<input type="text" name="code"></div>
    <div><input type="submit" value="提交"></div>
    <div id="error"><%= request.getAttribute("errorMsg")==null ? "":request.getAttribute("errorMsg")%>
    </div>
</form>
</body>
</html>
