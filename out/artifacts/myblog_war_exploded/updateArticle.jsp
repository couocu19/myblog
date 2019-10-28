<%@ page import="bean.Article" %><%--
  Created by IntelliJ IDEA.
  User: 11310
  Date: 2019/10/15
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<mvc:resources mapping="/css/**" location="/statics/css/" />
<mvc:resources mapping="/images/**" location="/statics/images/" />
<mvc:resources mapping="/js/**" location="/statics/js/" />
<mvc:resources mapping="/editor.md-master/**" location="/editor.md-master/" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath %>">
    <title>updatePage</title>
    <link rel="stylesheet" href="editor.md-master/examples/css/style.css" />
    <!--引入markdown css样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/editor.md-master/css/editormd.css" />
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon" />

</head>
<body background="img/writeBackground.jpg">
<h1>修改博客</h1>

<script src="editor.md-master/examples/js/jquery.min.js"></script>

<div id="layout" style="margin-left: 20px">
    <%
        Article a = (Article) request.getAttribute("article");
        String title = a.getTitle();
        String name = a.getUser();
        String writing = a.getWriting();
        String hwriting = a.getHwriting();
        int id = a.getId();
        int view = a.getViewCount();
        int comment = a.getCommentCount();

    %>
    <form action="article/update2" method="post">
        <header>
            <h1>请开始你的编辑</h1>
            文章标题：<input type="text" id="articleTitle" name="title" value="<%=title%>" />
            <input type="hidden" name="user" value="<%=name%>">
            <input type="hidden" name="id" value="<%=id%>">
            <input type="hidden" name="view" value="<%=view%>">
            <input type="hidden" name="comment" value="<%=comment%>">
            类别：
            <select id="articleCategory"></select>
            <span id="btnList">
                <input type="submit" id="publishArticle" onclick="writeArticle.doSubmit();" class="btn btn-info" value="更新文章" />
            </span>
        </header>
        <div id="test-editormd">
        <textarea class="editormd-markdown-textarea" name="writing" style="display:none;">
               <%=writing%>
   </textarea>
        <textarea class="editormd-html-textarea" name="hwriting">

        </textarea>
        </div>
    </form>
</div>

<script type="text/javascript">
    var testEditor;

    $(function() {
        testEditor = editormd("test-editormd", {
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            path    : "../lib/"
        });

        /*
        // or
        testEditor = editormd({
            id      : "test-editormd",
            width   : "90%",
            height  : 640,
            path    : "../lib/"
        });
        */
    });
</script>

<script>
    var testEditor;
    $(function() {
        testEditor = editormd("test-editormd", {
            width   : "90%",
            height  : 450,
            opacity : 0.8,
            syncScrolling : "single",
            saveHTMLToTextarea : true, //设置可保存为html 获取的时候testEditor.getHtml();就可以了
            /*theme : "dark",*/  //设置主题，有默认
            /*previewTheme : "dark",*/
            /*editorTheme : "pastel-on-dark",*/
            searchReplace : true,
            emoji : true,
            taskList : true,
            tocm            : true,         // Using [TOCM]
            tex : true,                   // 开启科学公式TeX语言支持，默认关闭
            flowChart : true,             // 开启流程图支持，默认关闭
            sequenceDiagram : true,       // 开启时序/序列图支持，默认关闭,
            dialogLockScreen : false,   // 设置弹出层对话框不锁屏，全局通用，默认为true
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "C:\\Users\\11310\\myblog\\src\\servlet\\UploadFileServlet.java",
            path    : "${pageContext.request.contextPath}/editor.md-master/lib/"
        });
    });


    /* 文章类别下拉框数据绑定 */
    var categorySelect = {
        init: function () {//初始化数据
            $.ajax({
                type: "GET",
                url: 'articleSort/listArticleCategory.do',
                dataType:'json',
                contentType:"application/json",
                cache: false,
                success: function(data){
                    //debugger;
                    data = eval(data) ;
                    categorySelect.buildOption(data);
                }
            });
        },
        buildOption: function (data) {//构建下拉框数据
            //debugger;
            var optionStr ="";
            for(var i=0 ; i < data.length; i ++) {
                optionStr += "<option value="+data[i].typeId+">";
                optionStr += data[i].name;
                optionStr +="</option>";
            }
            $("#articleCategory").append(optionStr);
        }
    }

    /* 发送文章*/
    var writeArticle = {
        doSubmit: function () {//提交
            if (writeArticle.doCheck()) {
                //debugger;
                var title = $("#articleTitle").val();
                var content = $("#articleContent").val();
                var typeId = $("#articleCategory").val();
                $.ajax({
                    type: "POST",
                    url: '<%=basePath %>article/saveOrUpdateArticle.do',
                    data: {'title':title,'content':content,'typeId':typeId},
                    dataType:'json',
                    //contentType:"application/json",
                    cache: false,
                    success: function(data){
                        //debugger;
                        if ("success"== data.result) {
                            alert("保存成功!");
                            setTimeout(function(){
                                window.close();
                            },3000);
                        }
                    }
                });
            }
        },
        doCheck: function() {//校验
            //debugger;
            var title = $("#articleTitle").val();
            var content = $("#articleContent").val();
            if (typeof(title) == undefined || title == null || title == "" ) {
                alert("请填写文章标题!");
                return false;
            }

            if(typeof (content) == undefined || content == null || content == "") {
                alert("正在上传！");
                return false;
            }

            return true;
        }
    }

</script>
<script src="${pageContext.request.contextPath}/editor.md-master/editormd.js"></script>

</body>
</html>
