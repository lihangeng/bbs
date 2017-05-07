<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@taglib prefix= "spring" uri= "http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户注册</title>
<script>
   
   </script>
</head>
<body>
<h3>用户注册</h3>
<form action="bbs/register" method="post" >
<table>
   <tr>
   <td>姓名</td>
   <td><input type="text" id="name" name = "name"/> </td>
   </tr>
   <tr>
   <td>密码</td>
   <td><input type="password" id="password" name = "password"/></td>
   </tr>
   <tr>
   <td><input class="but" type="submit" value="登录"></td>
   </tr>
</table>
</form>
</body>
</html>