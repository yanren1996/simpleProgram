<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	</head>
	<body>
		已登入${user.firstName} ${user.lastName}的帳號<br>
		Email: ${user.mail}<br>
		<button id="update">修改資料</button><button id="cancel" style="display:none">取消</button>
		<div>
			<sf:form method="POST" commandName="user" style="display:none" id="form">
				<sf:label path="account" cssErrorClass="error" >帳號</sf:label>
				<sf:input path="account" cssErrorClass="error" id="account" readonly="true"/>
				<label id="allowId"></label>
				<br>
				<sf:label path="password" cssErrorClass="error">密碼</sf:label>
				<sf:password path="password" cssErrorClass="error"/>
				<br>
				<sf:label path="firstName" cssErrorClass="error">姓</sf:label>
				<sf:input path="firstName" cssErrorClass="error"/>
				<br>
				<sf:label path="lastName" cssErrorClass="error">名</sf:label>
				<sf:input path="lastName" cssErrorClass="error"/>
				<br>
				<sf:label path="mail" cssErrorClass="error">信箱</sf:label>
				<sf:input path="mail" cssErrorClass="error"/>
				<br>
				<br>
				<sf:errors path="*" element="div" cssClass="errors"/>
				<br>
				<input type="submit" value="儲存" id="submit"/>
			</sf:form>
		</div>
		<script type="text/javascript">
			$("#update").click(function(){
				$("form").attr('style','');
				$("#cancel").attr('style','');
				$("#update").attr('style','display:none');
			});
			
			$("#cancel").click(function(){
				$("form").attr('style','display:none');
				$("#cancel").attr('style','display:none');
				$("#update").attr('style','');
			});
			
		</script>
	</body>
</html>