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
		<label>Nombre: </label><input type="text" name="nombre"><br> 
		<label>Contraseña: </label><input type="password" name="contrasena"><br>
		<label>Categoría Profesional: </label><input type="radio" name="categoriaProfesional">I
		<input type="radio" name="categoriaProfesional">II
		<input type="radio" name="categoriaProfesional">III<br>
		<input type="submit" value="Registro">
		<p style="color:red;">
            <%
            if (request.getAttribute("error") != null) {
            	request.getAttribute("error");
            }
            %>
        </p>
	</form>
</body>
</html>