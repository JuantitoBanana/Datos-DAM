<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar</title>
</head>
<body>
	<form method="post" action="ServletController">
		<table border="1">
		<tr>
			<td colspan="2"><h1>SEDE ELECTRÓNICA GF</h1></td>
		</tr>
		<tr>
			<td><h4>Número Registro:</h4></td> <td><input type="text" name="numRegistro"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="boton" value="Buscar"/></td>
		</tr>
		</table>
	</form>
</body>
</html>