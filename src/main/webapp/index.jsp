<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style>
#header{
     height:100px;
     background:white;
     }
#navigation{
      height:50px;
      background:black;
      
     }
#content{
      
}
#navigationText{
     color:white;
     float:left;
     margin:10px 30px;
}
#loginText{
     color:white;
     float:right;
     margin:15px ;
}

}
</style>
<script type="text/javascript">
       window.onload=function(){
       }
</script>
<title>我爱自驾游</title>
</head>
<body>
<div id="header">
<img src="logo.png">  
</div>
<div id="navigation">
<h2 id="navigationText">首页</h2><h2 id="navigationText">攻略</h2><h2 id="navigationText">社区</h2><h2 id="navigationText">资讯</h2>
<h3><a href="login.jsp" id="loginText">登录</a></h3><h3><a href="register.jsp" id="loginText">注册</a></h3>


</div>
<div id="content">

</div>
</body>
</html>
