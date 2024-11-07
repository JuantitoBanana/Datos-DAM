<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ArchivosJava.Persona" %>
<html>
<head>
    <title>Datos Personales</title>
</head>
<body>
    <h2>Datos Personales Introducidos</h2>
    <%
        Persona persona = (Persona) request.getAttribute("persona");
        if (persona != null) {
    %>
        DNI/NIF: <%= persona.getDni() %><br>
        Nombre: <%= persona.getNombre() %><br>
        Apellidos: <%= persona.getApellidos() %><br>
        Dirección: <%= persona.getDireccion() %><br>
        Teléfono: <%= persona.getTelefono() %><br>
        Correo: <%= persona.getCorreo() %><br>
    <% } else { %>
        <p>No se han encontrado datos.</p>
    <% } %>
    <form action="RecogidaPersonas.jsp">
        <input type="submit" value="Volver">
    </form>
</body>
</html>