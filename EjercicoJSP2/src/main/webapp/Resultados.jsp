<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Resultados de Votación</title>
</head>
<body>
    <h2>Resultados de la Elección de Delegado</h2>
    <table border="1">
        <tr>
            <th>Alumno</th>
            <th>Nº Votos</th>
        </tr>
        <tr>
            <td>Ruth Fernández</td>
            <td><%= getServletContext().getAttribute("votosRuth") %></td>
        </tr>
        <tr>
            <td>Victor Vergel</td>
            <td><%= getServletContext().getAttribute("votosVictor") %></td>
        </tr>
        <tr>
            <td>BLANCOS</td>
            <td><%= getServletContext().getAttribute("votosBlancos") %></td>
        </tr>
    </table>
    <br>
    <form action="Votacion.jsp" method="GET">
        <input type="submit" value="Volver">
    </form>
</body>