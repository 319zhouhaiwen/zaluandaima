<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>登陆</title>
</head>
<script type="text/javascript">
	function a() {
		var cas = document.getElementById("cods");
		cas.src = "cod?t=" + Math.random();
	}
</script>
<body>
	<form action="long" method="post">
		<input type="hidden" name="hidcode" id="hidcode" value="${abc}">
		账号：<input type="text" name="name" id="name" /><br> 密码：<input
			type="password" name="pswd" id="pswd" /><br>
		<div id="div" style="display: none">
			验证码：<input type="text" name="yzm" style="width: 50px;" /> <img
				src="cod" onclick="a();" id="cods" /> <br>
		</div>
		<button>登陆</button>
	</form>
</body>
<script type="text/javascript">
	var value = document.getElementById("hidcode").value;
	if (value == 1) {
		document.getElementById("div").style.display ="";
	}else{
		document.getElementById("hidcode").value="";
	}
</script>
</html>
