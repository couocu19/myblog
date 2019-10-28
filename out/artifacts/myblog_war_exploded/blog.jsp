<%--
  Created by IntelliJ IDEA.
  User: 11310
  Date: 2019/10/15
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

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
    <%
        String name = (String)request.getServletContext().getAttribute("name");
    %>
    <div class="col-sm-3">
           <div id="userBox">
               <%=name%>的博客
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
                       <img src=${path}><br>
                       <%=name%>
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
            <%--<div class="news-list-item clearfix">--%>
               <c:forEach items="${list}" var="l">
                   <div class="news-list-item clearfix">
                       <div class="title" style="width: 500px;
            height: 30px;
            text-align: center;
            font-family: 楷体;
            font-weight: bold;">
                    <a class="text" href="article/show?id=${l.id}" class="title">${l.title}</a>
                       </div><br>
                       <%--${l.hwriting}--%>

                       <div class="read" style="text-align: center;
width: 100px;
height: 30px;
margin: 30px auto 0px auto;
border: 1px solid darkkhaki;
padding: 4px;
border-radius: 5px;">

                           <style>
                               .read:hover{
                               transform: scale(1.25);
                               background-color: gainsboro;
                               color: black !important;
                           }

                           </style>
                    <a class="text1" href="article/show?id=${l.id}" class="title">阅读全文</a>
                       </div>
                    <div class="info">
                        <span>作者:${l.user}</span>.
                        <span>评论数:${l.commentCount}</span>
                    </div>
                   </div>
               </c:forEach>

            <%--</div>--%>

        </div>

    </div>
    <div class="col-sm-2">
               <ul class="nav navbar-nav navbar-right">
                   <li><a href="writeAriticle.jsp">写文章</a></li>
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
