<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cotización</title>
</head>
<body>

	<% Map<String, Double> mapaValores = (HashMap<String, Double>) getServletContext().getAttribute("mapaValores"); %>
	
	<h1>COTIZAGF S.L.</h1>
	<h3>La sesión está activa por el usuario: <%=session.getAttribute("nombreUsuario") %></h3>
	<h3>Fecha nueva cotización: <%=session.getAttribute("fechaCreacion") %></h3>
	
	<table border="1">
		<tr><td>Ciclo</td><td>Valor Actual</td><td>Valor Nuevo</td></tr>
		<% for(String valor : mapaValores.keySet()){%>
		<tr><td><%=valor %></td><td><%= mapaValores.get(valor) %></td><td><input type="text" name="valoresNuevos"></td></tr>
		<%} %>
	</table><br>
	<form action="ServletCotizacion" method="post">
		<input type="submit" name="boton" value="Enviar">
	</form>
</body>
</html>