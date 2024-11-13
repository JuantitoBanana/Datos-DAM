<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceso</title>
</head>
<body>
	<h1>Datos Registro Desarrollo de Software</h1>
	<form action="ServletUsuario" method="post">
		<label>Nombre: </label><input type="text" name="nombre"><br> 
		<label>Contraseña: </label><input type="password" name="contrasena"><br>
		<label>Elige un perfil: </label>
		<select size="2">
			
		</select><br>
		<input type="submit" value="Acceso">
	</form>
</body>
</html>