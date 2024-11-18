<%@page import="javax.imageio.plugins.tiff.GeoTIFFTagSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrate</title>
</head>
<body>
	<h1>Datos Registro Desarrollo de Software</h1>
	<form action="ServletUsuario" method="post">
		<label>Nombre: </label><input type="text" name="nombre" ><br> 
		<label>Contraseña: </label><input type="password" name="contrasena" ><br>
		<label>Categoría Profesional: </label><input type="radio" name="categoriaProfesional" value="I" checked="checked">I
		<input type="radio" name="categoriaProfesional" value="II">II
		<input type="radio" name="categoriaProfesional" value="III">III<br>
		<input type="submit" value="Registro">
	</form>
			<%
            if (getServletContext().getAttribute("error") != null) {
            	
            %>
            	<p style="color:red;">(*)El nombre de usuario y la contraseña no pueden estar vacios</p>
           <%
            }
            %>
</body>
</html>