<%@page import="ArchivosJava.Incidencia"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Consulta de Incidencias</title>
</head>
<body>
    <h1>LISTADO DE INCIDENCIAS</h1>
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Tema</th>
            <th>Descripción</th>
        </tr>
        <%
            List<Incidencia> incidencias = (List<Incidencia>) session.getAttribute("incidencias");
            if (incidencias != null) {
                for (Incidencia incidencia : incidencias) {
        %>
                    <tr>
                        <td><%= incidencia.getCodigo() %></td>
                        <td><%= incidencia.getTema() %></td>
                        <td><%= incidencia.getDescripcion() %></td>
                    </tr>
        <%
                }
            }
        %>
    </table>
    <form action="AltaIncidencia.jsp" method="get">
        <input type="submit" value="Volver"/>
    </form>
</body>
</html>