<%--
  Created by IntelliJ IDEA.
  User: 11310
  Date: 2019/10/14
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<html>
  <head>
    <title>LoginPage</title>
  </head>
  <body>
  <form action="/login" method="post">
    用户名:<input type="text" name="user"><br>
    密码:<input type="password" name="pwd"><br>
    <input type="submit" value="登录"><br>
  </form>
  <form action="signup.jsp" method="post">
     没有账号？<input type="submit" value="注册"><br>
  </form>

  </body>
</html>
