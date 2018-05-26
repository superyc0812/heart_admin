<%--
  Created by IntelliJ IDEA.
  User: yangchao
  Date: 2018/3/14
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加测试试题</title>
</head>
<body>
<form action="/mapis/test/addTestPaper" method="post" enctype="multipart/form-data">
    试题名:<input type="text" name="test_name"/><br/>
    类型:<select name="typeId">
            <option value="1">爱情</option>
            <option value="2">专业</option>
            <option value="3">亲情</option>
        </select><br/>
    测试量:<input type="text" name="test_num" value="0"><br/>
    图片:<input type="file" name="picture"/><br/>
    <input type="submit" value="添加"/><br/>
</form>
</body>
</html>
