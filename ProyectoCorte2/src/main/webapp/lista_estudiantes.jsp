<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista de Estudiantes</title>
</head>
<body>
    <h1>Lista de Estudiantes</h1>
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Fecha de Nacimiento</th>
            <th>Colegio</th>
            <th>Carrera</th>
            <th>Estrato</th>
            <th>Homologación</th>
            <th>Foto</th>
        </tr>
        <c:forEach items="${estudiantes}" var="estudiante">
            <tr>
                <td>${estudiante.nombre}</td>
                <td>${estudiante.fecha_nacimiento}</td>
                <td>${estudiante.colegio}</td>
                <td>${estudiante.carrera}</td>
                <td>${estudiante.estrato}</td>
                <td>${estudiante.homologacion}</td>
                <td><img src="${estudiante.foto}" alt="Foto de ${estudiante.nombre}" width="100" /></td>
            </tr>
        </c:forEach>
    </table>
    <a href="index.jsp">Volver</a>
</body>
</html>