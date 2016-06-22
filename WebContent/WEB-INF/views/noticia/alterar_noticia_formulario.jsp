<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Alterar Noticia</title>
</head>
<body>

<h2>Alterar Noticia</h2>

<form action="alterarNoticia" method="post">
	<input type="hidden" name="idNoticia" value="${noticia.idNoticia}" />
	Titulo: <input type="text" name="titulo" value="${noticia.titulo}" /><br />
	Subtitulo: <input type="text" name="subtitulo" value="${noticia.subtitulo}" /><br />
	Texto: <input type="text" name="texto" value="${noticia.texto}" /><br />
	Data: <input type="text" name="data" value="${noticia.dataNoticia}" /><br />
	<input type="submit" value="ALTERAR" />
</form>

</body>
</html>