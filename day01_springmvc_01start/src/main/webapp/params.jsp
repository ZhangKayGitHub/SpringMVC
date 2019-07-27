<%--
  Created by IntelliJ IDEA.
  User: Kay
  Date: 2019/7/25
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--请求参数绑定--%>
<a href="param/testParam?username=hehe&password=123456">请求参数绑定</a>

<br>
<hr>
<!--把数据封装到Account当中-->
<form action="param/saveAccount" method="post">
    姓名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    金额：<input type="text" name="money"><br>
    用户姓名：<input type="text" name="user.uname"><br/><!--Account类中包含了User引用类型时的传值方式-->
    用户年龄：<input type="text" name="user.age"><br>
    <input type="submit" value="提交">
</form>
<br>
<hr>

<!--把数据封装到Account当中，类中存在List和Map的集合-->
<form action="param/saveAccount" method="post"><!---->
    姓名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    金额：<input type="text" name="money"><br>
    用户姓名：<input type="text" name="user.uname"><br/><!--Account类中包含了User引用类型时的传值方式-->
    用户年龄：<input type="text" name="user.age"><br><br>

    用户姓名：<input type="text" name="list[0].uname"><br/>
    用户年龄：<input type="text" name="list[0].age"><br><br>

    用户姓名：<input type="text" name="map['one'].uname"><br/>
    用户年龄：<input type="text" name="map['one'].age"><br>
    <input type="submit" value="提交">
</form>
<br>
<hr>
<br>
<!--自定义类型转换器-->
<form action="param/saveUser" method="post"><!---->
    用户姓名：<input type="text" name="uname"><br/><!--Account类中包含了User引用类型时的传值方式-->
    用户年龄：<input type="text" name="age"><br>
    用户生日：<input type="text" name="date">
    <input type="submit" value="提交">
</form>

<a href="param/testServlet">Servlet原生的API</a>

</body>
</html>
