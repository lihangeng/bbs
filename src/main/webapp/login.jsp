<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@taglib prefix= "spring" uri= "http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户登录</title>
   <style>
#header{
     height:100px;
     background:white;
     }
#navigation{
      height:10px;
      background:black;
     }
#content{
margin:0 auto;border:2px solid #000;width:400px;height:400px
}
   </style>
   <script type="text/javascript">
   <%
   String errorMsg = null;
   if(request.getParameter("errorMsg") != null){
	   errorMsg = request.getParameter("errorMsg").toString() ;
   }
   %>
   window.onload=function(){
	   var errorMsg = "<%=errorMsg%>";
	   if(errorMsg != "null"){
 		  document.getElementById("errorMsg").style.display="block";
 	  }
   }
   function check(form){
	   if(form.name.value ==''){
		   alert("请输入用户账号");
		   form.name.focus();
		   return false;
	   }
	   if(form.password.value ==''){
		   alert("请输入登录密码！");
		   form.password.focus();
		   return false;
	   }
	   return true;
	   
   }
   </script>
</head>
<body>
<div id = header><img src="logo.png">  </div>
<div id = navigation></div>
<div id = content>
<h1 id = title style="text-align:center">用户登录</h1>
<form action="bbs/login" method="post" id = form1>
<table>
   <tr>
   <td><h2>姓名</h2></td>
   <td><input style="font-size:20px" size="15" type="text" id="name" name = "name"/> </td>
   </tr>
   <tr>
   <td><h2>密码</h2></td>
   <td><input style="font-size:20px" size="15" type="password" id="password" name = "password"/></td>
   </tr>
   <tr>
   <td align="center"><h2><input style="font-size:20px;width:100% " class="but" type="submit" value="登录" onclick = "return check(this.form)"></h2></td>
   </tr>
   <div id = "errorMsg" style="display:none">请输入正确的用户名或密码!</div>
</table>
</form>
</div>
</body>
</html>