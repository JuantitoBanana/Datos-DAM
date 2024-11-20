<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceso</title>
</head>
<body>
	<h1>COTIZAGF S.L.</h1>
	<form action="ServletCotizacion" method="post">
		<label>Nombre:</label><input type="text" name="nombre"><br>
		<label>Código pin:</label><input type="password" name="pin"><br>
		<input type="submit" name="boton" value="Acceso">
		<input type="reset" value="Cerrar">
	</form>
	<% if(request.getAttribute("errorBlanco") != null){ %>
		<p style="color:red;">(*)El nombre y el código pin son obligatorios</p>
	<%} else if(request.getAttribute("errorCredenciales") != null){ %>
		<p style="color:red;">(*)Las credenciales no son correctas</p>
	<%} %>
</body>
</html>