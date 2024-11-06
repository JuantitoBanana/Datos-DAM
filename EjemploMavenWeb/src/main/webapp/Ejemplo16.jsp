<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!int numero = 100; %>
	<%!public String fecha(){
	return (new Date().toString());	
	}%>
	<table border="1">
	<%for(int i=0; i< numero;i++){ %>
	<tr>
	<td>Número</td>
	<td><%=i %></td>
	</tr>
	<%
	numero += 10;}
	%>
	
	</table>
</body>
</html>