<%--
  Created by IntelliJ IDEA.
  User: Kay
  Date: 2019/7/25
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--常用注解--%>
<a href="anno/testRequestParame?name=哈哈">RequestParam</a><!--验证RequestParam函数参数的注解，
当请求的参数的名字与函数参数的名字不一致时，使用该注解，该注解的参数必须和请求参数的名字一致，否者还是会报错
（本例中AnnoController类中的testRequestParame方法的参数）-->


<br>
    <hr>
    <br>
    <form action="anno/testRequestBody" method="post"><!--测试RequestBody注解，本例中AnnoController类中的testRequestBody方法的参数-->
        用户姓名：<input type="text" name="username"><br/>
        用户年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

<br>
<hr>
<br>
    <a href="anno/testPathVaribale/10">PathVaribale注解</a>

    <br>
    <hr>
    <br>
    <a href="anno/testRequestHeader">RequestHeader注解</a>
    <br>
    <hr>
    <br>
    <a href="anno/testCookieValue">CookieValue注解</a>
    <br>
    <hr>
    <br>
    <form action="anno/testModelAttribute" method="post"><!--测试RequestBody注解，本例中AnnoController类中的testRequestBody方法的参数-->
        用户姓名：<input type="text" name="uname"><br/>
        用户年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>
    <br>
    <hr>
    <br>
    <a href="anno/testSessionAttributes">testSessionAttributes注解</a>
    <br>
    <a href="anno/getSessionAttributes">getSessionAttributes注解</a>
    <br>
    <a href="anno/delSessionAttributes">delSessionAttributes注解</a>

</body>
</html>
