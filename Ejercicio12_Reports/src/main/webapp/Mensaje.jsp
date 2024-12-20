<%@page import="com.gf.webapp.empresa.entities.Empleado"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% List<Empleado> empleados = (List<Empleado>) getServletContext().getAttribute("listaEmpleados"); %>
	<table border="1">
	<tr><td>Apellidos</td><td>Oficio</td><td>Salario</td></tr>
	<%for(Empleado e: empleados){ %>
		<tr><td><%=e.getApellidos() %></td><td><%=e.getOficio() %></td><td><%=e.getSalario() %></td></tr>
	<%} %>
	</table>
</body>
</html>