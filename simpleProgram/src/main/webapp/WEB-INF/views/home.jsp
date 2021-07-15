<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登入畫面</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">    
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
	<body>
		
		<div class="container">
			<div class="row">
				<p class="col-md-6 col-md-offset-3">帳號登入</p>
			</div>
			
			<form method="POST" name="singin">
				
				<div class="row">
					<input type="text" class="col-md-5 col-md-offset-3" name="account">
					<p class="col-md-1 text-center">帳號</p> <br> <br> 
				</div>
				<div class="row">
					<input type="password" class="col-md-5 col-md-offset-3" name="password">
					<p class="col-md-1 text-center">密碼</p> <br> <br> 
				</div>
				<div class="row">
					<input type="submit" class="col-md-2 col-md-offset-3" value="登入" />
					<a href="<c:url value="/addUser" />" class="col-md-2 text-center">新建帳號</a>
				</div>
				
				
			</form>
		
		
		
		</div>
		
		
		
		
		
	</body>
</html>