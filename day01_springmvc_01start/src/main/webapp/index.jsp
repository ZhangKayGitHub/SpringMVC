<%--
  Created by IntelliJ IDEA.
  User: Kay
  Date: 2019/7/25
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
<a href="user/hello">入门程序</a><!--当我们点击该链接是连接中的href=“hello”
将会找到HelloController这个类中通过通过注解@RequestMapping(path = "/hello")映射的方法名为hello的方法-->
<a href="user/testRequestMapping">@RequestMapping注解</a><!--当类的强卖你添加RequestMapping注解添加路径（/user）时，请求要请求的方法路径要添加上类的路径-->
</body>
</html>
