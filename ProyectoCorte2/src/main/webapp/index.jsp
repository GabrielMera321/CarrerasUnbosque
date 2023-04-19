<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="/Index.css" rel="stylesheet" type="text/css"/>
<head>
<meta charset="ISO-8859-1">
<title>Universidad El Bosque</title>
</head>
<body>
<h1>
Universidad el Bosque
</h1>
<pre>La Universidad el Bosque les da la bienvenida,si usted es administrador ingrese su usuario y contrasena.<br>Si es aspirante presione el boton estudiante<br>
</pre>
<form action=LoginServlet method=post >
<pre>
        Enter User Name:  <input type="text" name="t1">
        
         Enter Password:  <input type="text" name="t2">
        
    <input name="action" type="submit"value="Login" >    <input name="action" type="submit" value="Estudiante">
</pre>
</form> 
</body>
</html>