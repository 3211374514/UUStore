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
  <title>login</title>
  <link href="css/reset.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
  <form action="/brand-case/loginServlet" id="form" method="post">
    <h1 id="loginMsg">CHANGE</h1>
    <div id="errorMsg">${login_msg} ${register_msg}</div>
    <p>Username:<input id="username" name="username" value="${cookie.username.value}" type="text"></p>

    <p>Password:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>
    <p>Repassword:<input id="password" name="repassword" value="${cookie.password.value}" type="password"></p>
    <div id="subDiv">
      <input type="submit" class="button" value="change" name="change1">

    </div>
  </form>
</div>

</body>
</html>
