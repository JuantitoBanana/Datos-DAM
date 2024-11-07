<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recogida de Datos Personales</title>
</head>
<body>
    <h2>Introduzca sus datos personales</h2>
    <form action="ServletPersonas" method="post">
        DNI/NIF: <input type="text" name="dni" required><br>
        Nombre: <input type="text" name="nombre" required><br>
        Apellidos: <input type="text" name="apellidos" required><br>
        Dirección: <input type="text" name="direccion" required><br>
        Teléfono: <input type="text" name="telefono" required><br>
        Correo: <input type="email" name="correo" required><br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>