<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新建帳號</title>
		<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
		<style type="text/css">
			input.error{background-color: #ffcccc;}
			div.errors {background-color: #ffcccc;border: 2px solid red;}
			#allowId {color:blue;}
		</style>
	</head>
	<body>
		<sf:form method="POST" commandName="user">
			<sf:label path="firstName" cssErrorClass="error">姓</sf:label>
			<sf:input path="firstName" cssErrorClass="error"/>
			<br>
			<sf:label path="lastName" cssErrorClass="error">名</sf:label>
			<sf:input path="lastName" cssErrorClass="error"/>
			<br>
			<sf:label path="mail" cssErrorClass="error">信箱</sf:label>
			<sf:input path="mail" cssErrorClass="error" />
			<br>
			<sf:label path="account" cssErrorClass="error" >設定帳號</sf:label>
			<sf:input path="account" cssErrorClass="error" id="account"/>
			<label id="allowId"></label>
			<br>
			<sf:label path="password" cssErrorClass="error">設定密碼</sf:label>
			<sf:password path="password" cssErrorClass="error"/>
			<br><br>
			<sf:errors path="*" element="div" cssClass="errors"/>
			<br>
			<input type="submit" value="建立" id="submit" style="display:none">
		</sf:form>
		
		<script type="text/javascript">
			$("#account").blur(
				function(){
					$.post(
						"<c:url value='/addUser/allowId'/>",
						{id : $("#account").val()},
						function(data){
							$("#allowId").text(data.msg);
							if(data.display){
								$("#submit").attr('style','');
							}else{
								$("#submit").attr('style','display:none');
							}
						},
						"json"
					)
				}		
			)
		</script>
	</body>
</html>