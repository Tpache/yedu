<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">  
    
	onload = function() {
		setInterval(go, 1000);
	};
	var x = 3; //利用了全局变量来执行  
	function go() {
		x--;
		if (x > 0) {
			document.getElementById("sp").innerHTML = x; //每次设置的x的值都不一样了。  
		} else {
			location.href = 'res.html';
		}
	}
</script>
<style>
	.divcss5 {text-align: center}
</style>
<title>Index</title>
</head>
<body>
	<div class="divcss5"><img src="../img/appleLZ.png"/></div>
	<div class="divcss5">${msg}</div>
</body>
</html>