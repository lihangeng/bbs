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
#logout{
   display:none
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
       <%
       String username = null;
       if(request.getSession().getAttribute("userName") != null){
    	   username = request.getSession().getAttribute("userName").toString();
       }else {
    	   username = "登录";
       }
      %>  
      window.onload=function(){
    	  var userName = "<%=username%>";
    	  if(userName != "登录"){
    		  document.getElementById("logout").style.display="inline";
    	  }
      }
</script>
<title>我爱自驾游</title>
<link rel="icon" href="timg.ico" type="image/x-icon">
</head>
<body>
<div id="header">
<td><img src="logo.png">  </td><td>此位置显示天气信息</td>
</div>
<div id="navigation">
<h2 id="navigationText">首页</h2><h2 id="navigationText">攻略</h2><h2 id="navigationText">社区</h2><h2 id="navigationText">资讯</h2>
<h3><a href="login.jsp" id="loginText"><%=username %> </a></h3><h3><a href="register.jsp" id="loginText">注册</a></h3><h3 id = "logout"><a href="logout.jsp" id="loginText">注销</a></h3>



</div>
<div id="content">

</div>
</body>
</html>
