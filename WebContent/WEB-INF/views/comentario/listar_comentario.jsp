<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Listar Comentario</title>
</head>
<body>

<table border="1">
	<tr>
		<th>ID_COMENTARIO</th>
		<th>TEXTO</th>
		<th>ALTERAR</th>
		<th>APAGAR</th>
	</tr>
	
	<c:forEach var="c" items="${comentarios}">
	<tr>
		<td>${c.idComentario}</td>
		<td>${c.texto}</td>
		<td><a href="alterarComentarioFormulario?id=${c.idComentario}">ALTERAR</a></td>
		<td><a href="apagarComentario?id=${c.idComentario}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>