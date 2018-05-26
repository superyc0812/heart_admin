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
    <title>添加音乐</title>
</head>
<body>
<form action="/mapis/music/addMusic" method="post" enctype="multipart/form-data">
    音乐名:<input type="text" name="name"/><br/>
    演唱者:<input type="text" name="musician"/><br/>
    上传日期:<input type="text" name="upload_date"/><br/>
    描述:<textarea name="description" cols="50" rows="30"></textarea>
    类型:<select name="typeId">
            <option value="1">爱情音乐</option>
            <option value="2">专业音乐</option>
            <option value="3">亲情音乐</option>
        </select><br/>
    播放量:<input type="text" name="play_num" value="0"><br/>
    图片:<input type="file" name="img"/><br/>
    地址:<input type="file" name="song"><br/>
    关键字:<input type="text" name="kwyWords">
    <input type="submit" value="添加"/><br/>
</form>
</body>
</html>
