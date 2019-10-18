<%--
  Created by IntelliJ IDEA.
  User: 11310
  Date: 2019/10/18
  Time: 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadPhotoPage</title>
</head>
<body>
<h1>上传头像</h1>
注册信息成功！现在可以上传你的头像~<br>
<form action="upload" method="post" enctype="multipart/form-data">
上传头像:<br><input type="file" name="photo"><br>
<input type="submit" value="点击上传">
</form>
</body>
</html>
