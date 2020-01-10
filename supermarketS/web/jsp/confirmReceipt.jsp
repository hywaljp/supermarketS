<%--
  Created by IntelliJ IDEA.
  User: P
  Date: 2020/1/1
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="tradeG" class="javaBean.trade" scope="application"/>
<html>
<head>
    <title>确认收款的页面</title>
</head>
<body style="text-align: center">

<br><br> <h1 style="font-size: xx-large">打印商品购买清单</h1>

        <div style="border:1px solid red;width:880px;height:600px;position:absolute;left:50%;margin-left:-430px;top:50%;margin-top:-190px;">
            <table style="margin-left: 40%; position: relative "border="1"cellpadding="2"cellspacing="2">
                <tbody>
                    <tr>
                        <td>商品的名称</td>
                        <td>商品单价</td>
                        <td>商品数量</td>
                    </tr>

                    <c:forEach items="${list}" var="tradeG">
                    <tr>
                           <td>${tradeG.name}</td>
                           <td>${tradeG.price}</td>
                           <td>${tradeG.num}</td>
                    </tr>
                    </c:forEach>

                </tbody>
            </table>
            <br><br><br><br>
            日  期：<input type="text" name="date" readonly="readonly" value="${date}"><br><br>
            总价格：<input type="text" name="sumprice" readonly="readonly" value="${sumprice}"><br><br>
            收款人编号：<input type="text" name="whore" readonly="readonly" value="${whore}"><br><br>
            <br><br>
            <form action="/trade?tradeOK=succeed" method="post">
                <input type="submit" value="收款确认" style="background-color: green;color: red;width: 10%;height: 5%">
            </form>&nbsp;&nbsp;&nbsp;
            <form action="/trade?tradeOK=failure" method="post">
                <input type="submit" value="取消订单" style="background-color:grey;width: 10%;height: 5%">
            </form>
        </div>


</body>
</html>
