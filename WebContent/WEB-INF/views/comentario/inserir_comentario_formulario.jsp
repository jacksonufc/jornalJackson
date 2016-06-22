<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Inserir Comentario</title>
</head>
<body>
	
	<form action="inserirComentario" method="post">
	
		<input type="hidden" name="idLeitor" value="${usuario_logado.idUsuario}">
	
		Texto: <input type="text" name="texto" />
		<form:errors path="comentario.texto" /> 
		<br />
		<input type="submit" value="ENVIAR" />
	</form>

</body>
</html>