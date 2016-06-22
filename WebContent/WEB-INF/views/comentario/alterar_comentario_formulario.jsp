<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Alterar Comentario</title>
</head>
<body>

<h2>Alterar Comentario</h2>

<form action="alterarComentario" method="post">
	<input type="hidden" name="idComentario" value="${comentario.idcomentario}" />
	Texto: <input type="text" name="texto" value="${comentario.texto}" /><br />
	<input type="submit" value="ALTERAR" />
</form>

</body>
</html>