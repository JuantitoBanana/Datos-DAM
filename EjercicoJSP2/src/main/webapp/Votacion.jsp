<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Elección de Delegado</title>
</head>
<body>
	<h2>ELECCION DE DELEGADO</h2>
	<form action="ServletVotacion" method="POST">
		<p>Los delegados que se presentan a miembros del Consejo Escolar son...</p>
		<input type="checkbox" name="candidato" value="Ruth Fernández">RUTH FERNÁNDEZ<br>
		<input type="checkbox" name="candidato" value="Victor Vergel"> VICTOR VERGEL<br>
		<br> <input type="submit" value="Enviar">
	</form>
</body>
</html>