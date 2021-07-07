<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登入畫面</title>
</head>
	<body>
		帳號登入
		<form method="POST" name="singin">
			<input type="text" name="account">帳號<br> <br> 
			<input type="password" name="password">密碼<br> <br> 
			<input type="submit" value="登入" />
		</form>
		<br>
		<a href="<c:url value="/addUser" />">新建帳號</a>
	</body>
</html>