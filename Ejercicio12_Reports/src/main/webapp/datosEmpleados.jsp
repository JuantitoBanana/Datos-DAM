<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Datos Empleados</title>
</head>
<body>
	<form action="ServletEmpleados" method="post">
		<table border="1">
			<tr>
				<td colspan="2"><h1>DATOS EMPLEADOS</h1></td>
			</tr>
			<tr>
				<td><input type="submit" name="boton" value="Consultar"></td>
				<td><input type="submit" name="boton" value="Listar"></td>
			</tr>
		</table>
	</form>
</body>
</html>