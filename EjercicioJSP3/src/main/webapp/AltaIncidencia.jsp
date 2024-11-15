 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta Incidencia</title>
</head>
<body>
    <h1>ALTA INCIDENCIA</h1>
    <% 
        Integer codigoGenerado = (Integer) session.getAttribute("codigoGenerado");
        if (codigoGenerado != null) { 
    %>
        <p>Su incidencia ha sido dada de alta en nuestros sistemas con el código: <%= codigoGenerado %></p>
        <form method="get" action="ConsultaIncidencia.jsp">
            <input type="submit" value="Nueva Incidencia"/>
        </form>
    <% 
    	session.removeAttribute("codigoGenerado");
        } else { 
    %>
    <form action="ServletIncidencia" method="post">
        <label>Tema:</label>
        <input type="text" id="tema" name="tema"><br>
        
        <label>Descripción:</label>
        <input type="text" id="descripcion" name="descripcion"><br>
        
        <input type="submit" value="Confirmar"/>
        
        <p style="color:red;">
            <%
            if (request.getAttribute("error") != null) {
                request.getAttribute("error");
            }
            %>
        </p>
    </form>
    <% 
        }
    %>
</body>
</html>