<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lSang="en">
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous"></link>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Universidad el Bosque</title>
</head>
<body>
	<h1>Formulario Aspirante</h1>

	<form action="EstudianteServlet" method="post"
		enctype="multipart/form-data">
		<label for="foto">Foto:</label> 
		<input type="file" id="foto" name="foto" accept="image/*"> 
		<input type="hidden" name="action" value="agregar"> 
		<input type="submit" value="Agregar">
		<input type="hidden" name="action"value="agregar"> 
		<label for="nombre">Nombre:</label>
		 <input type="text" name="nombre" required> 
		 <label for="fecha_nacimiento">Fecha de nacimiento:</label> 
		 <input type="date" id="fecha_nacimiento" name="fecha_nacimiento"value="2000-07-22" min="1960-01-01" max="2018-12-31"> 
		 <label for="colegio">Colegio de donde se graduo:</label> 
		 <input type="text"name="colegio" required> <label for="carrera">Carrera</label>
		<select name="carreras" id="carrera">
			<option value="">Seleccione una opcion</option>
			<option value="arquitectura">Arquitectura - $8.958.000 COP</option>
			<option value="arte_dramatico">Arte Dramático - $7.137.000
				COP</option>
			<option value="artes_plasticas">Artes Plásticas - $7.137.000
				COP</option>
			<option value="diseno_industrial">Diseño Industrial -
				$8.958.000 COP</option>
			<option value="diseno_comunicacion">Diseño de Comunicación -
				$8.958.000 COP</option>
			<option value="formacion_musical">Formación Musical -
				$8.336.000 COP</option>
			<option value="ciencia_politica">Ciencia Política y Gobierno
				- $7.215.000 COP</option>
			<option value="derecho">Derecho - $8.125.000 COP</option>
			<option value="filosofia">Filosofía - $3.796.000 COP</option>
			<option value="licenciatura_educacion_infantil">Licenciatura
				en Educación Infantil - $3.810.000 COP</option>
			<option value="psicologia">Psicología - $8.469.000 COP</option>
			<option value="licenciatura_bilinguismo">Licenciatura en
				Bilingüismo con Énfasis en la Enseñanza del Inglés - $4.418.000 COP</option>
			<option value="interprete_lengua_senas">Intérprete
				Profesional de la Lengua de Señas Colombiana - Modalidad Virtual -
				$3.918.000 COP</option>
			<option value="administracion_empresas">Administración de
				Empresas - $8.319.000 COP</option>
			<option value="bioingenieria">Bioingeniería - $7.494.000 COP</option>
			<option value="ingenieria_ambiental">Ingeniería Ambiental -
				$6.954.000 COP</option>
			<option value="ingenieria_electronica">Ingeniería
				Electrónica - $6.605.000 COP</option>
			<option value="ingenieria_industrial">Ingeniería Industrial
				- $7.300.000 COP</option>
			<option value="ingenieria_sistemas">Ingeniería de Sistemas -
				$6.605.000 COP</option>
			<option value="negocios_internacionales">Negocios
				Internacionales - $8.763.000 COP</option>
			<option value="matematicas">Matemáticas - $5.228.000 COP</option>
			<option value="estadistica">Estadística - $5.961.000 COP</option>
			<option value="contaduria_publica">Contaduría Pública -
				Modalidad Virtual - $1.637.778 COP</option>
			<option value="finanzas">Finanzas - Modalidad Virtual -
				$1.905.556 COP</option>
			<option value="marketing_transformacion_digital">Marketing y
				Transformación Digital - Modalidad Virtual - $1.905.556 COP</option>
			<option value="economia">Economía - Modalidad Virtual -
				$1.905.556 COP</option>
			<option value="administracion_negocios_sostenibles">Administración
				de Negocios Sostenibles - Modalidad Virtual - $1.905.556 COP</option>
			<option value="administracion_produccion_logistica">Administración
				de Producción y Logística Internacional – Modalidad Virtual -
				$1.905.556 COP</option>
			<option value="biologia">Biología - $7.448.000 COP</option>
			<option value="enfermeria">Enfermería - $7.759.000 COP</option>
			<option value="instrumentacion_quirurgica">Instrumentación
				Quirúrgica - $6.627.000 COP</option>
			<option value="medicina">Medicina - $27.195.000 COP</option>
			<option value="odontologia">Odontología - $11.788.000 COP</option>
			<option value="optometria">Optometría - $7.881.000 COP</option>
			<option value="quimica_farmaceutica">Química Farmacéutica -
				$7.903.000 COP</option>
		</select> <select name="estrato">
			<option value="1" selected>1</option>
			<option value="2" selected>2</option>
			<option value="3" selected>3</option>
			<option value="4" selected>4</option>
			<option value="5" selected>5</option>
			<option value="6" selected>6</option>
			<option value="estrato" selected>Estrato</option>
		</select> <label for="homologacion">Homologación:</label> <input
			type="checkbox" name="homologacion"> <input type="submit"
			value="Agregar Estudiante"> 
	</form>

	
	</body>
</html>