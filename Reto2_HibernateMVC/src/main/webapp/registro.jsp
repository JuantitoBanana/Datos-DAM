<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
	<form method="post" action="ServletController">
		<table border="1">
		<tr>
			<td colspan="2"><h1>SEDE ELECTRÓNICA GF</h1></td>
		</tr>
		<tr>
			<td><h4>DNI solicitante:</h4></td> <td><input type="text" name="dni"></td>
		</tr>
		<tr>
			<td><h4>NOMBRE solicitante:</h4></td> <td><input type="text" name="nombre"></td>
		</tr>
		<tr>
			<td><h4>APELLIDOS solicitante:</h4></td> <td><input type="text" name="apellidos"></td>
		</tr>
		<tr>
			<td><h4>TRÁMITE:</h4></td> <td><input type="text" name="tramite"></td>
		</tr>
		<tr>
			<td><h4>ENTIDAD:</h4></td>
			<td><select name="entidad">
	        <option>INSPECCIÓN EDUCATIVA INFANTIL</option>
	        <option>INSPECCIÓN EDUCATIVA PRIMARIA</option>
	        <option>INSPECCIÓN EDUCATIVA SECUNDARIA</option>
	        <option>INSPECCIÓN EDUCATIVA BACHILLERATO</option>
	        <option>INSPECCIÓN EDUCATIVA FP</option>
	        <option>CONSEJERÍA EDUCACIÓN</option>
	        <option>MINISTERIO DE EDUCACIÓN Y CIENCIA</option>
	    	</select></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="boton" value="Grabar"/></td>
		</tr>
		</table>
	</form>
</body>
</html>