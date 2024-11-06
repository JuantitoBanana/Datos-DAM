<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="Segunda.jsp">
<jsp:param value="1" name="arg1"/>
<jsp:param value="2" name="arg2"/>
<jsp:param value="3" name="arg3"/>
</jsp:forward>
</body>
</html>