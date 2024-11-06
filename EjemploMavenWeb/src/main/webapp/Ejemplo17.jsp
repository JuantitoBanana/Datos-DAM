<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<%
Integer accesos = (Integer)session.getAttribute("accesos");
if(accesos == null){
	accesos = 0;
}
	accesos = accesos.intValue()+1;
	session.setAttribute("accesos", accesos);
	
if(request.getParameter("invalidaSesion") != null){
	session.invalidate();
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo 17</title>
</head>
<body>
	<form>
		<input type="submit" name="invalidaSesion" value="Invalidar Sesion">
		<input type="submit" name="recargaPage" value="Recarga Página">
	</form>
	<br>Contador
	<%=accesos.intValue() %>
</body>
</html>