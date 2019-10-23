<%--
  Created by IntelliJ IDEA.
  User: 11310
  Date: 2019/10/14
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/boot.min.css"/>
<html>
  <head>
    <title>LoginPage</title>
  </head>
  <body>
  <div class="lr">

  <form action="login" method="post">
    <div class="form-group">
    用户名/昵称<br>
      <input type="text" name="user"><br>
    </div>

    <div class="form-group">
    密码<br>
      <input type="password" name="pwd"><br>
    </div>

    <div class="form-group">
    <input type="submit" value="登录"><br>
    </div>
  </form>

  <form action="signup.jsp" method="post">
     没有账号？<input type="submit" value="注册"><br>
  </form>
  </div>

  </body>
</html>
