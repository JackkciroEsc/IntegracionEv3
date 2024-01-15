<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Modelo.Persona" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultado del Inicio de Sesión</title>
</head>
<body>
    <div class="result-container">
        <h1>Resultado del Inicio de Sesión</h1>
        <%
            String mensaje = (String) request.getAttribute("mensaje");
            Persona persona = (Persona) request.getAttribute("datosUsuario");
            if (mensaje != null) {
                out.println("<p>" + mensaje + "</p>");
            }
            if (persona != null) {
                out.println("<h3>Rut:</h3>" + "<p>" + persona.getRut() + "</p>");
                out.println("<h3>Nombre y Apellido:</h3>" + "<p>" + persona.getNombre() + " " + persona.getApellido() + "</p>");
                out.println("<h3>Teléfono:</h3>" + "<p>" + persona.getTelefono() + "</p>");
                out.println("<h3>Fecha de Ingreso:</h3>" + "<p>" + persona.getFechaIngreso() + "</p>");
            }
        %>
        <a href="index.jsp">Volver</a>
    </div>
</body>
</html>