<%@page import="ArchivosJava.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App</title>
</head>
<body>
	<h1>Datos Registro Desarrollo de Software</h1>
	
	<p><%= getServletContext().getAttribute("nombre") %> has accedido correctamente.</p>
	<p>Número de veces que se accede a la página de registros desde la aplicación: <%= getServletContext().getAttribute("contadorAccesos") %></p>
	
	<table border="1">
	<tr><td>Usuarios registrados</td></tr>
	<%
		List<Usuario> usuarios = (List<Usuario>) getServletContext().getAttribute("usuarios");
    	for (Usuario usuario : usuarios) {
	%>
		<tr><td><%= usuario.toString() %></td></tr>
	<% 
    	}
	%>
	</table><br>
	
	<form action="Acceso.jsp" method="get">
		<input type="submit" name="boton" value="Acceso">
	</form>
</body>
</html>