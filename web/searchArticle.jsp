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
<div class="contains">
</div>
<div class="contain">
    <div class="total">
        <p class="stitle">为你找到以下文章</p>
    </div>
    <div class="list">
        <c:forEach items="${infoList}" var="l">
            <div class="item">
                <div class="stitles">
                    <a class="text" href="article/show?id=${l.id}" class="title">${l.title}</a>
                </div>
                <div class="information" >
                    <div class="wc">
                        <span>发表于:${l.date}</span>.
                        <span>作者:${l.user}</span>.
                        <span>评论数:${l.commentCount}</span>
                    </div>
                    <div class="look">
                        <a class="text11" href="article/show?id=${l.id}" class="title">查看全文</a>
                    </div>

                </div>
            </div>
        </c:forEach>
    </div>




</div>













</body>
</html>
