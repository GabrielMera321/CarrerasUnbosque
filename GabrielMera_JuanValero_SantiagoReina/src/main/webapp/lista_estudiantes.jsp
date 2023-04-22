<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista de Estudiantes</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="container">
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
					<td>${estudiante.fechaNacimiento}</td>
					<td>${estudiante.colegio}</td>
					<td>${estudiante.carrera}</td>
					<td>${estudiante.estrato}</td>
					<td>${estudiante.homologacion}</td>
					<td><img src="${estudiante.foto}"
						alt="Foto de ${estudiante.nombre}" width="100" /></td>
				</tr>
			</c:forEach>
		</table>
		<h2>Eliminar Estudiante</h2>
		<form action="EstudianteServlet" method="post">
			<input type="hidden" name="action" value="eliminar"> <label
				for="nombre">Nombre:</label> <input type="text" name="nombre"
				required> <input type="submit" value="Eliminar Estudiante">
		</form>

		<h2>Actualizar Estudiante</h2>
		<form action="EstudianteServlet" method="post">
			<input type="hidden" name="action" value="actualizar"> <label
				for="nombreActual">Nombre Actual:</label> <input type="text"
				name="nombreActual" required> <label for="nuevoNombre">Nuevo
				Nombre:</label> <input type="text" name="nuevoNombre" required> <label
				for="nuevaFechaNacimiento">Nueva Fecha de nacimiento:</label> <input
				type="date" id="NuevaFechaNacimiento" name="nuevaFechaNacimiento"
				value="2000-07-22" min="1960-01-01" max="2018-12-31"> <label
				for="nuevoColegio">Nuevo Colegio:</label> <input type="text"
				name="nuevaCarrera" required> <label for="nuevoEstrato">Nuevo
				Estrato:</label> <select name="nuevoEstrato" required>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
			</select> <label for="nuevaHomologacion">Nueva Homologación:</label> <input
				type="checkbox" name="nuevaHomologacion"> <input
				type="submit" value="Actualizar Estudiante">
		</form>
		<a href="bienvenida.jsp">Volver</a>
	</div>
</body>
</html>
