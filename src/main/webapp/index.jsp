<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
</head>
<body>
    <form action="Servlet" method="POST">
        <h1>Iniciar Sesión</h1>
        
        <p>Usuario: <input type="text" name="usuario" /></p>
        <p>Contraseña: <input type="password" name="password" /></p>
        
        <input type="submit" value="Comprobar" name="submit">
    </form>
</body>
</html>