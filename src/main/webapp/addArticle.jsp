<%--
  Created by IntelliJ IDEA.
  User: yangchao
  Date: 2018/3/13
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加文章</title>
</head>
<body>
<form action="/mapis/article/addArticle" method="post" enctype="multipart/form-data">
    标题:<input type="text" name="title"/><br/>
    上传日期:<input type="text" name="upload_date"/><br/>
    类型:<select name="type">
            <option value="1">爱情文章</option>
            <option value="2">专业文章</option>
            <option value="3">亲情文章</option>
        </select><br/>
    作者:<input type="text" name="author"/><br/>
    描述:<textarea name="description" cols="30" rows="20"></textarea><br/>
    内容:<textarea name="content" cols="60" rows="20"></textarea><br/>
    阅读量:<input type="text" name="read_num" value="0"><br/>
    图片:<input type="file" name="picture"><br/>
    关键字:<input type="test" name="keyWords">
    <input type="submit" value="添加"/><br/>
</form>
</body>
</html>
