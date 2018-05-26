<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
    <form action="/admin/login" method="post">
        账号:<input type="text" name="account"/><br/>
        密码:<input type="password" name="password"/><br/>
        <input type="submit" value="登录"/><br/>
    </form>
    <a href="/user/getUserList">获取用户列表</a><br/>
    <a href="/user/getUserById/1">根据用户编号获取用户信息</a><br/>
    <br/><br/>
    <a href="/addArticle.jsp">添加文章</a><br/>
    <a href="/article/getArticleById/1">更新文章</a>
    <br/><br/>
    <a href="/addMusic.jsp">添加音乐</a><br/>
    <a href="/music/getMusicById/1">更新音乐</a><br/>
    <br/><br/>
    <a href="/filterForum.jsp">过滤论坛铭感文字</a><br/>
    <br/><br/>
    <a href="/addPaper.jsp">添加测试试题</a><br/>
    <a href="/paper/deletePaper/3">删除测试试题</a><br/>
</body>
</html>
