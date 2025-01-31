<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mensaje</title>
</head>
<body>
	<form method="post" action="ServletController">
		<h1>SEDE ELECTRÓNICA GF</h1>
		<% if( (boolean) request.getAttribute("validacion")){ %>
			<p><%= String.valueOf(request.getAttribute("mensaje")) %></p>
			<p>Número registro: <%= String.valueOf(request.getAttribute("numRegistro")) %></p>
			<p>Fecha de registro: <%= LocalDateTime.now() %></p>
		<%}else{ %>
			<p>No se ha registrado el trámite. Error al realizar la grabación.</p>
		<%} %>
		<input type="submit" name="boton" value="Nuevo Registro" /> 
		<input type="submit" name="boton" value="Consulta Registro"/>
	</form>
</body>
</html>