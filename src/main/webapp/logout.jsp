<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注销成功</title>
<script language=javascript>  
   window.onload=function(){
	   <%
	   session.removeValue("userName");
	   session.invalidate();
	   %>
   }
   setTimeout("window.location.href='/fish-web-bbs/index.jsp'",1800)
</script>
</head>
<body>
    注销成功!
</body>
</html>
