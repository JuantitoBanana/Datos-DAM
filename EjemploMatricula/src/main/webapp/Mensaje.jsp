<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Menu.jsp" method="post">
	<table bgcolor=yellow align="center" border="1">
		<tr>
			<td><%= request.getAttribute("mensaje") %></td>
		</tr>
		<tr>
			<td><input type="submit" name="boton" value="volver"></td>
		</tr>
	</table>
	
	</form>
</body>
</html>