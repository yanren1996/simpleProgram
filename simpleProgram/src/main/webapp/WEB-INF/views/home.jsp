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
			<form method="POST" class="form-horizontal">
				
				<div class="form-group">
					<label class="col-md-2 control-label">帳號</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name="account">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-2 control-label">密碼</label>
					<div class="col-md-8">
						<input type="password" class="form-control" name="password">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-md-1 col-md-offset-2">
						<input type="submit" class="btn btn-defult" value="登入" />
					</div>
					<div class="col-md-2">
						<a href="<c:url value="/addUser" />" class="text-center">新建帳號</a>
					</div>
				
					
					
				</div>
				
			</form>

		
		</div>
		
	</body>
</html>