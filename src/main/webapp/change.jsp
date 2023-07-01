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
  <title>reset</title>
  <link href="css/reset.css" rel="stylesheet">
</head>

<body>
<div id="resetDiv" style="height: 350px">
  <form action="/brand-case/change/update" id="form" method="post">
    <h1 id="resetMsg">修改密码</h1>
    <div id="errorMsg">${reset_msg}</div>
    <p>用户名:<input id="username" name="username" value="${cookie.c_username.value}" type="text"></p>

    <p>原密码:<input id="password" name="password" value="" type="password"></p>
    <p>重置密码:<input id="repassword" name="repassword" value="" type="password"></p>
    <div id="subDiv">
      <input type="submit" class="button" value="修改" name="change1">

    </div>
  </form>
</div>

</body>
</html>
