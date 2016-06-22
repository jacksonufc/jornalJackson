<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Inserir Noticia</title>
</head>
<body>
	
	<form action="inserirNoticia" method="post" enctype="multipart/form-data">
		
		Seção: <select name = "idSecao">
			<c:forEach var="s" items="${secoes}" >
			<option value="${s.idSecao}">
			<c:out value="${s.titulo}"></c:out>
			</option>
			</c:forEach>
		</select>	
		<br /><br />
		<input type="hidden" name="idUsuario" value="${usuario_logado.idUsuario}">
		
		Data: <input type="text" name="dataNoticia" /><br /><br />
		Titulo: <input type="text" name="titulo" />
		<form:errors path="noticia.titulo" /> 
		<br /><br />
		Subtitulo: <input type="text" name="subtitulo" /><br /><br />
		Texto:<br />
		<textarea name="texto" rows="5" cols="45"> </textarea><br /><br />
		Imagem: <input type="file" name="imagem" /> <br /><br />
		<input type="submit" value="ENVIAR" />
	</form>

</body>
</html>