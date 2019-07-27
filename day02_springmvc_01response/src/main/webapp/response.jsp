<%--
  Created by IntelliJ IDEA.
  User: Kay
  Date: 2019/7/26
  Time: 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">
        //页面加载，绑定单机事件
        $(function () {
            $("#btn").click(function(){
                alert("hello btn");
                //发送一个ajax请求
                $.ajax({//表示一个ajax全局对象
                   //编写json格式，设置属性值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    //发送给服务器的数据
                    data:'{"username":"hehe","password":"123456","age":30}',
                    //预期服务器返回的类型
                    dataType:"json",
                    //请求的方式
                    type:"post",
                    //成功后的回调函数
                    success:function (data) {
                        //data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="user/testString">测试响应返回字符串</a><br>
    <a href="user/testVoid">测试响应没有字符串Void</a><br>
    <a href="user/testModelAndView">测试ModelAndView</a><br>
    <a href="user/testForwardOrRedirect">测试ForwardOrRedirect</a><br>
    <!--<button id="btn">发送ajax的异步请求</button>-->
    <input type="button" value="发送ajax的异步请求" id="btn"/>

</body>
</html>
