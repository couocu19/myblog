<%@ page import="bean.Article" %>
<%@ page import="java.util.Date" %><%--
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
</head>
<body>
  <div class="contains">
  </div>

  <div class="container">
      <div class="col-sm-3">
          <div id="userBox">
              的博客
          </div>
      </div>
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
      <div class="col-sm-8">
          <div class="Article">
          <div class="title1" style="width: 100%;height: 100px;text-align: center;
border-bottom: 1.5px solid
darkgray;">
              <h2 class="tips"><%=title%></h2>
              <div class="info">
                  <div class="time"><%=time%></div>
                  <div class="writer"><%=user%></div>
                  <div class="view">阅读数：<%=view%></div>
                  <div class="update"><a href="article/update1?id=<%=id%>">编辑</a></div>
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
