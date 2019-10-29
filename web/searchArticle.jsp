<%@ page import="bean.Article" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 11310
  Date: 2019/10/15
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>searchPage</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/boot.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/showArticle.css"/>
</head>
<body>
<%--<%--%>
    <%--List<Article> list = (List)request.getAttribute("infoList");--%>
    <%----%>
    <%----%>
<%--%>--%>
<div class="container">
    <div class="total">
        <h1>为你找到以下文章</h1>
    </div>
    <div class="news-list">
        <%--<div class="news-list-item clearfix">--%>
        <c:forEach items="${infoList}" var="l">
            <div class="news-list-item clearfix">
                <div class="title" style="width: 500px;
            height: 30px;
            text-align: center;
            font-family: 楷体;
            font-weight: bold;">
                    <a class="text" href="article/show?id=${l.id}" class="title">${l.title}</a>
                </div><br>
                <div class="read" style="text-align: center;
width: 100px;
height: 30px;
margin: 26px auto 0px auto;
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













</body>
</html>
