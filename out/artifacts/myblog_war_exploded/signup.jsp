<%--
  Created by IntelliJ IDEA.
  User: 11310
  Date: 2019/10/15
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<html>
<head>
    <title>registerPage</title>
</head>
<body>
  <h1>注册博客账号</h1>
  <div class="lr">
  请填写以下相关信息~<br>
  <form action="register" method="post">
      用户名(账号名):<input type="text" name="name"><br>
      设置密码:<input type="password" name="pwd"><br>
      生日:<input type="date" name="date"><br>
      <input type="submit" value="点击注册">
  </form>
  </div>

</body>
</html>
