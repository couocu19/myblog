<%@ page import="bean.Article" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: 11310
  Date: 2019/10/28
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/boot.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/showArticle.css"/>
    <title>ArticlePage</title>
    <%
        Article a = (Article) request.getServletContext().getAttribute("article");
        String title = a.getTitle();
        int id = a.getId();
        String user = a.getUser();
        Date time = a.getDate();
        int view = a.getViewCount();
        int comment = a.getCommentCount();
        String hwriting = a.getHwriting();
    %>
</head>
<body>

  <div class="contains">
  </div>
  <div class="container">
      <div class="col-sm-3">
          <div id="userBox">
              <%=user%>的博文
          </div>
          <div class="basicInfo">
                  <div class="number">
                      <div>原创</div>
                      <div class="num">5</div>
                  </div>
                  <div class="number">
                      <div>评论数</div>
                      <div class="num">20</div>
                  </div>
                  <div class="view">
                      <div>访问</div>
                      <div class="num1">100</div>
                  </div>
          </div>
          <div class="list-group">
              <a class="list-group-item" href="#">☋ &nbsp;<%=user%>的主页</a>
              <a class="list-group-item" href="#">☋ &nbsp;回到首页</a>
          </div>
      </div>

      <div class="col-sm-8">
          <div class="Article">
          <div class="title1" style="width: 100%;height: 100px;text-align: center;
border-bottom: 1.5px solid
darkgray;">
              <h2 class="tips"><%=title%></h2>
              <div class="info">
                  <div class="time"><%=time%></div>
                  <div class="writer"><%=user%></div>
                  <div class="view1">阅读数：<%=view%></div>
                  <div class="update"><a href="article/update1?id=<%=id%>">编辑</a></div>
                  <div class="update"><a href="article/delete?id=<%=id%>" onclick="if(confirm('确定删除该文章吗？')==false)return false;location.href='article/delete?id=<%=id%>'">删除</a></div>
              </div>

          </div>
          <div class="mainWriting">
              <%=hwriting%>
          </div>
          </div>
      </div>
  </div>
</body>
</html>
