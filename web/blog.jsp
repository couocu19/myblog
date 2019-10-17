<%--
  Created by IntelliJ IDEA.
  User: 11310
  Date: 2019/10/15
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/boot.min.css"/>
<html>
<head>
    <title>blogPage</title>
</head>
<body>
<div class="contains">
</div>
<div class="container">
    <div class="col-sm-3">
           <div id="userBox">
               ${user}的博客
           </div>
           <div class="list-group">
               <a class="list-group-item" href="#">☋ 首页</a>
               <a class="list-group-item">㉿ 标签</a>
               <a class="list-group-item">⋛ 归档</a>
               <a class="list-group-item">♋ 关于</a>
           </div>
           <%--<div id="userInfo">--%>
               <div class="user">
                   <div id="photo">
                       <img src="userimage/defaultimg.JPG"><br>
                       ${user}
                   </div>
               </div>

               <div class="list-group">
                       <a class="list-group-item">
                           <span>博文</span>
                           <span>10</span>
                       </a>
                       <a class="list-group-item">
                           <span>标签</span>
                           <span>5</span>

                       </a>
                       <a class="list-group-item">
                           <span>总浏览</span>
                           <span>30</span>
                       </a>

           </div>

</div>
    <div class="col-sm-6">
        <div class="news-list">
            <div class="news-list-item clearfix">
                <%--<div class="col-xs-">--%>
                    <a class="text" href="#" class="title">Java基础知识之反射</a>
                    <a class="text1" href="#" class="title">阅读全文</a>
                    <div class="info">
                        <span>作者:刘二狗</span>.
                        <span>评论数:</span>.
                    </div>
                <%--</div>--%>
            </div>

        </div>


    </div>
    <div class="col-sm-2">
               <ul class="nav navbar-nav navbar-right">
                   <li><a href="">写文章</a></li>
                   <li><a href="index.jsp">退出</a></li>
               </ul>

           <div class="search-bar">
               <form action="" method="post">
               <input type="search" class="form-control" placeholder="搜索关键词……">
               </form>
           </div>
       </div>
</div>

</body>
</html>
