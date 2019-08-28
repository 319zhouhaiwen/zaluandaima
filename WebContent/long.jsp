<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function a(){
		var code=document.getElementById("code");
		code.src="code?t="+Math.random();
	}
</script>
<body>
	<form action="long" method="post" >
	<input type="hidden" name="hidden" id="hidden" value="${hidden}"/><br>
		账号：<input type="text" name="name" id="name"/><br> 
		密码：<input type="password" name="mm" id="mm"/><br>
		<div id="div" style="display:none">
			验证码：<input type="text" name="yzm" id="yzm"/>
			<img  src="code" id="code" onclick="a()" title="点击更换">
		</div>
		<button>登陆</button>
	</form>
</body>
<script type="text/javascript">
	function b(){
		var value=document.getElementById("value").value;
		if(value==1){
			document.getElementById("div").style.display="";
		}
	}
</script>
</html>