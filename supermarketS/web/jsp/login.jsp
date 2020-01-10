<%--
  Created by IntelliJ IDEA.
  User: P
  Date: 2019/12/30
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>小型超市管理系统</title>
    <%
        Object message = request.getAttribute("message");
        if (message!=null && !"".equals(message)){
    %>
    <script type="text/javascript"> alert("<%=message%>");</script>
    <% }%>

</head>
<body  background="/images/login2.jpg" style="background-color: 	#66B3FF">

    <br>  <br>
    <form action="/login" method="post" style="text-align: center">
        <br><br><br><br><br><h1 style="font-size:xx-large ;text-align: center">小型超市管理系统</h1><br><br><br>
        用户名：<input type="text" name="uname" style="width: 10%;height: 3%;"> <br><br><br>
        密  码：<input type="password" name="pwd"style="width: 10%;height: 3%;"> <br>
        <br><br><br>&nbsp;&nbsp;
        <input type="submit" value="登陆" style="width: 10%;height: 4%;color: black;font-size: medium;background:aquamarine">
    </form>

</body>
</html>
