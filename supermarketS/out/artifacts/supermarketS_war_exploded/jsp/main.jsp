<%--
  Created by IntelliJ IDEA.
  User: P
  Date: 2019/12/30
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="goods" class="javaBean.goods" scope="application"/>
<jsp:useBean id="clerk" class="javaBean.Clerk" scope="application"/>
<jsp:useBean id="firm" class="javaBean.firm" scope="application"/>
<jsp:useBean id="supplier" class="javaBean.supplier" scope="application"/>
<html>
<style>
    form{
        border: black;
        width: 100%;
        text-align: center;
    }
    input{
        width: 100%;height: 5%;
        font-size: medium;
    }
</style>
    <script type="text/javascript">
        function checkUname(){
            var uname=document.getElementById("gname").value;
            var reg=/^[\w\W]{1,10}$/;
            var span=document.getElementById("gnameSpan");
            if(uname=="" || uname==null){
                span.innerHTML="商品名不能为空";
                span.style.color="red";
                return false;
            }
            else if(reg.test(uname)){
                span.innerHTML="用户名符合规则";
                span.style.color="green";
                return  true;

            }else{
                span.innerHTML="用户名不符合规则";
                span.style.color="red";
                return  false;
            }
        }

        function checkGnum(){
            var uname=document.getElementById("gnum").value;
            var reg=/^[0-9]{0,4}$/;
            var span=document.getElementById("gnumSpan");
            if(uname=="" || uname==null){
                span.innerHTML="商品价格不能为空";
                span.style.color="red";
            }
            else if(reg.test(uname)){
                span.innerHTML="商品价格符合规则";
                span.style.color="green";

            }else{
                span.innerHTML="商品价格不符合规则";
                span.style.color="red";
            }
        }

        function checkGQTY(){
            var uname=document.getElementById("gQTY").value;
            var reg=/^[0-9]{0,4}$/;
            var span=document.getElementById("gQTYSpan");
            if(uname=="" || uname==null){
                span.innerHTML="商品价格不能为空";
                span.style.color="red";
            }
            else if(reg.test(uname)){
                span.innerHTML="商品价格符合规则";
                span.style.color="green";

            }else{
                span.innerHTML="商品价格不符合规则";
                span.style.color="red";
            }
        }
        function checkGQTYWARN(){
            var uname=document.getElementById("gQTYWARN").value;
            var reg=/^[0-9]{0,2}$/;
            var span=document.getElementById("gQTYWARNSpan");
            if(uname=="" || uname==null){
                span.innerHTML="商品价格不能为空";
                span.style.color="red";
            }
            else if(reg.test(uname)){
                span.innerHTML="商品价格符合规则";
                span.style.color="green";

            }else{
                span.innerHTML="商品价格不符合规则";
                span.style.color="red";
            }
        }
    </script>
        <script type="text/javascript">
            function  checkbox() {
                var str=document.getElementsByName("checkboxs");
                var objarray=str.length;
                var chestr="";
                for (i=0;i<objarray;i++)
                {
                    if(str[i].checked == true)
                    {
                        chestr  += str[i].value;
                        chestr +=",";
                    }
                }
                var num = document.getElementsByName("textboxs");
                var numarry = num.length;
                var che = "";
                for (j=0;j<numarry;j++){
                    if (num[j].value!=""){
                        che += num[j].value;
                        che +=",";
                    }
                }
                if(chestr == "" )
                {
                    alert("请选择商品！");
                }else if ( che =="") {
                    alert("需要购买的数量");
                } else {
                    window.location.href="/trade?tradeOK=OK&str="+chestr+che;
                }


            }
        </script>

<head>
    <title>Title</title>
</head>
<body style="background-image: url(/images/login2.jpg)">
<%
    Object message = request.getAttribute("message");
    if (message!=null && !"".equals(message)){
%>
<script type="text/javascript"> alert("<%=message%>");</script>
<% }%>

    <div style="width: 10% ;height: 100%;background-color: aqua;border: 1px solid #ccc;float: left;text-align: center">

        <form action="/showAll?what=goods" method="post">
            <input type="submit" value="商品信息" name="goods">

        </form>

        <%
            String name ="";
            Cookie [] c=request.getCookies();
            for(int i=0;i<c.length;i++){
                if(c[i].getName().equals("username")){
                   name =c[i].getValue();
                }
            }
            request.setAttribute("loginname",name);
        %>

        <c:if test="${loginname!=null && loginname =='admin'}">
            <form action="/showAll?what=clerk" method="post">
                <input type="submit" value="员工信息" name="clerk">
            </form>
        </c:if>

        <form action="/showAll?what=supplier" method="post">
            <input type="submit" value="供货商信息" name="supplier">
        </form>
        <form action="/showAll?what=firm" method="post">
            <input type="submit" value="厂商信息" name="firm">
        </form>

        <br><br><br><br><br><br>
        <form action="/reGoods?reGoodsOK=not" method="post">
            <input type="submit" value="录入商品信息">
        </form>
        <form action="/DUGoods?UDC=Firstin" method="post">
            <input type="submit" value="删改商品信息">
        </form>
        <form action="/trade?tradeOK=firstin" method="post">
            <input type="submit" value="进行商品交易">
        </form>
        <br><br><br><br>
        <form action="/jsp/login.jsp" method="post" >
            <input type="submit" value="退出登陆">
        </form>

    </div>

    <div style="width:80%;height: 100%;background-color: azure;border: 1px solid #ccc;float: right">
        <div style="height: 10%;border: 1px solid #ccc;width: 100%">
            <c:if test="${flag =='goods' && (ud == '' || ud == null)&&(select == '' || select == null)}">
            <form action="/showAll?search=goods" method="post">
                编号：<input type="text" name="no" style="width: 15%;height: 40%"> &nbsp;&nbsp;&nbsp;
                名称：<input type="text" name="name" style="width: 15%;height: 40%">&nbsp;&nbsp;&nbsp;
                <input type="submit" value="查询" style="width: 15%;height: 40%">
            </form>
            <form action="/order"method="post">
                选择列：<select name="order" style="width: 15%;height: 40%">
                    <option value="gno">商品编号</option>
                    <option value="gname">商品名称</option>
                    <option value="gnum">价格</option>
                    <option value="gQTY">数量</option>
                    <option value="gQTYWARN">报警数量</option>
                    <option value="gifsell">是否允许销售</option>
                    <option value="fno">厂商编号</option>
                    <option value="sno">供应商编号</option>
                </select>
                排序方式：<select name="howorder" style="width: 15%;height: 40%">
                    <option value="asc"> 升序</option>
                    <option value="desc">降序</option>
                </select>
                <input type="submit" value="排序" style="width: 15%;height: 40%">
            </form>
    </c:if>
            <c:if test="${ud =='ud'}">
                <form action="/DUGoods?UDC=D" method="post">
                    要删除商品的编号：<input type="text" name="udno" style="width: 15%;height: 40%"> &nbsp;&nbsp;&nbsp;
                    <input type="submit" value="删除" style="width: 15%;height: 40%">
                </form>
                <form action="/DUGoods?UDC=U"method="post">
                    更改的商品编号：<input type="text" name="changeno" style="width: 15%;height: 40%">
                    选择更改的列：<select name="changewhat" style="width: 15%;height: 40%">
                    <option value="gname">商品名称</option>
                    <option value="gnum">价格</option>
                    <option value="gQTY">数量</option>
                    <option value="gQTYWARN">报警数量</option>
                    <option value="gifsell">是否允许销售</option>
                    <option value="fno">厂商编号</option>
                    <option value="sno">供应商编号</option>
                </select>
                    <input type="text" name="changevalue" style="width: 15%;height: 40%">
                    <input type="submit" value="更改" style="width: 15%;height: 40%">
                </form>
            </c:if>

        </div>

        <div style="height: 80%;border: 1px solid #ccc;width: 100%">

            <c:if test="${flag =='goods'}">
        <table style="text-align: center;"border="1"cellpadding="2"cellspacing="2">
            <tbody>

              <tr>
                  <td>商品编号</td>
                  <td>商品名称</td>
                  <td>价格</td>
                  <td>数量</td>
                  <td>报警数量</td>
                  <td>是否允许销售</td>
                  <td>厂商编号</td>
                  <td>供应商编号</td>
                 <c:if test="${select!=null && select=='select'}" >
                   <td>选择商品</td>
                     <td>商品的数量</td>
                 </c:if>
              </tr>
              <c:forEach items="${list}" var="goods" >
                  <tr>
                      <td>${goods.gno}</td>
                      <td>${goods.gname}</td>
                      <td>${goods.gNUM}</td>
                      <td>${goods.gQTY}</td>
                      <td>${goods.gQTYWARN}</td>
                      <td>${goods.gifsell}</td>
                      <td>${goods.fno}</td>
                      <td>${goods.sno}</td>
                      <c:if test="${select !=null && select=='select'}" >
                      <td>
                          <c:if test="${goods.gifsell == 'true'}">
                          <input type="checkbox" name="checkboxs" value="${goods.gno}" style="width: 40%;height: 40%; border: black 1px solid">
                          </c:if>
                      </td>
                      <td>
                          <c:if test="${goods.gifsell == 'true'}">
                          <input type="text" name="textboxs" >
                          </c:if>
                      </td>
                      </c:if>
                  </tr>
              </c:forEach>
            </tbody>
        </table>
                <br><br>
                <c:if test="${select!=null && select=='select'}" >
                    <input type="button" value="确认已选择的商品" onclick="checkbox()" style="width: 10%;background-color: aquamarine;margin-left: 20%;">
                </c:if>
          </c:if>
            <c:if test="${flag == 'clerk'}">
              <table style="text-align: center;"border="1"cellpadding="2"cellspacing="2">
                  <tbody>
                <tr>
                    <td>员工编号</td>
                    <td>员工姓名</td>
                    <td>员工年龄</td>
                    <td>入职日期</td>
                </tr>
                <c:forEach items="${list}" var="clerk">
                    <tr>
                        <td>${clerk.ckno}</td>
                        <td>${clerk.ckname}</td>
                        <td>${clerk.ckage}</td>
                        <td>${clerk.redate}</td>
                    </tr>
                </c:forEach>
                  </tbody>
              </table>
            </c:if>
            <c:if test="${flag == 'firm'}">
                <table style="text-align: center;"border="1"cellpadding="2"cellspacing="2">
                    <tbody>
              <tr>
                  <td>厂商编号</td>
                  <td>厂商名称</td>
                  <td>厂商地址</td>
                  <td>厂商电话</td>
              </tr>
              <c:forEach items="${list}" var="firm">
                  <tr>
                      <td>${firm.fno}</td>
                      <td>${firm.fname}</td>
                      <td>${firm.faddress}</td>
                      <td>${firm.fTN}</td>
                  </tr>
              </c:forEach>
                    </tbody>
                </table>
          </c:if>
            <c:if test="${flag == 'supplier'}">
              <table style="text-align: center;"border="1"cellpadding="2"cellspacing="2">
                  <tbody>
              <tr>
                  <td>供应商编号</td>
                  <td>供应商名称</td>
                  <td>供应商地址</td>
                  <td>供应商电话</td>
              </tr>
              <c:forEach items="${list}" var="supplier">
                  <tr>
                      <td>${supplier.sno}</td>
                      <td>${supplier.sname}</td>
                      <td>${supplier.saddress}</td>
                      <td>${supplier.STN}</td>
                  </tr>
              </c:forEach>
                  </tbody>
              </table>
          </c:if>
            <c:if test="${flag=='reGoods'}">
                <form action="/reGoods?reGoodsOK=OK" method="post" onsubmit="return checkUname()">
                    商品名称:<input type="text" name="gname" id="gname" style="width: 40%" onblur="checkUname()"><span id="gnameSpan"></span><br><br><br>
                    商品价格:<input type="text" name="gnum" id="gnum" onblur="checkGnum()" style="width: 40%"><span id="gnumSpan"></span><br><br><br>
                    商品数量：<input type="text" name="gQTY" id="gQTY" onblur="checkGQTY()" style="width: 40%"><span id="gQTYSpan"></span><br><br><br>
                    报警数量：<input type="text" name="gQTYWARN" id="gQTYWARN" onblur="checkGQTYWARN()" style="width: 40%"><span id="gQTYWARNSpan"></span><br><br><br>
                    是否允许销售：<select name="gifsell"style="width: 10%;height: 5%">
                                    <option value="true">允许</option>
                                    <option value="false">不允许</option>
                                </select><br><br><br>
                    厂商编号：<select name="fno"style="width: 10%">
                                <c:forEach items="${fno}" var="list">
                                    <option>${list}</option>
                                </c:forEach>
                            </select><br><br><br>
                    供应商编号：<select name="sno" style="width: 10%">
                                     <c:forEach items="${sno}" var="list">
                                             <option>${list}</option>
                                    </c:forEach>
                                 </select><br><br><br>

                    <input  type="submit" value="提交" style="width: 15%;color: black;background-color: aquamarine">
                </form>
            </c:if>


        </div>

    </div>

</body>
</html>
