<%@page import="java.util.List"%>
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
	<form action="Aplicacion.jsp" method="get">
		<label>Nombre: </label><input type="text" name="nombre" value="<%= getServletContext().getAttribute("nombre") %>" ><br> 
		<label>Contraseña: </label><input type="password" name="contrasena"  value="<%= getServletContext().getAttribute("contrasena") %>"><br>
		<label>Elige un perfil: </label>
		<select size="2">
			<%
			List<String> perfiles = (List<String>) getServletContext().getAttribute("perfiles");
		    for (String perfil : perfiles) {
			%>
				<option><%= perfil %></option>
			<%
			}
			%>
		</select><br>
		<input type="submit" value="Acceso">
	</form>
	<p>A las <%= session.getAttribute("fechaCreacion") %> se creó esta sesión con el identificador: <%= session.getAttribute("identificadorSesion") %></p>
	
</body>
</html>