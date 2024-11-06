<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Ejemplo19Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Página principal</h1>
<p>Número <% Integer.parseInt(request.getParameter("number")); %></p>
</body>
</html>