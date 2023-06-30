<%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/8/28
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>用户登录</title>
  <link href="css/login.css" rel="stylesheet">
</head>

<body>

<div id="loginDiv" style="height: 350px">
  <form action="/brand-case/mailServlet" id="form" method="post">
    <h1 id="loginMsg">用户登录</h1>
    <div id="errorMsg">${login_msg} ${register_msg}</div>
    <p>邮箱:<input id="username" name="mail" value="${cookie.c_username.value}" type="text"></p>
    <div id="subDiv">
      <input type="submit" class="button" value="登录">


      <%--            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;--%
    </div>
    <%--        <input type="button" class="button" onclick="window.location.href='register.jsp';" value="注册VIP">--%>
  </form>
</div>



</body>
</html>
