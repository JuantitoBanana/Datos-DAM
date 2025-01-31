<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultar</title>
</head>
<body>
	<form method="post" action="ServletController">
	
		<% if( (boolean) request.getAttribute("validacion")){ %>
				<table>
			<tr>
				<td colspan="2"><h1>SEDE ELECTRÓNICA GF</h1></td>
			</tr>
			<tr>
				<td><h4>DNI solicitante:</h4></td> <td><input type="text" name="dni" value="<%= String.valueOf(request.getAttribute("dni")) %>" readonly="true"></td>
			</tr>
			<tr>
				<td><h4>NOMBRE solicitante:</h4></td> <td><input type="text" name="nombre" value="<%= String.valueOf(request.getAttribute("nombre")) %>" readonly="true"></td>
			</tr>
			<tr>
				<td><h4>APELLIDOS solicitante:</h4></td> <td><input type="text" name="apellidos" value="<%= String.valueOf(request.getAttribute("apellidos")) %>" readonly="true"></td>
			</tr>
			<tr>
				<td><h4>TRÁMITE:</h4></td> <td><input type="text" name="tramite" value="<%= String.valueOf(request.getAttribute("tramite")) %>" readonly="true"></td>
			</tr>
			<tr>
				<td><h4>ENTIDAD:</h4></td><td><input type="text" name="entidad" value="<%= String.valueOf(request.getAttribute("entidad")) %>" readonly="true"></td>
			</tr>
			</table>
		<%}else{ %>
			<h1>SEDE ELECTRÓNICA GF</h1>
			<p>El número de registro no existe.</p>
		<%} %>
		<input type="submit" name="boton" value="Nuevo Registro" /> 
		<input type="submit" name="boton" value="Consulta Registro"/>
	</form>
</body>
</html>