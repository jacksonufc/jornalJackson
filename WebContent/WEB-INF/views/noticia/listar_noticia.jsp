<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Listar Noticia</title>
</head>
<body>

	<c:forEach var="n" items="${noticias}">
	<br />
		<b>Seção:</b> ${n.secao.titulo}<br />
		<b>Data:</b> ${n.dataNoticia}<br />
		<b>Titulo:</b> ${n.titulo}<br />
		<b>Subtitulo:</b> ${n.subtitulo}<br />
		<b>Jornalista:</b> ${n.usuario.nome}<br />
		<b>Texto:</b> ${n.texto}<br />
		<td><img alt="${a.nome}" src="<c:url value="/resources/imagem/${n.titulo}.png"  />" /></td><br />
		
		<h3>Comentarios:</h3>
		<c:forEach var="c" items="${n.comentario}">
			<b>${c.usuario.nome}:</b>
			${c.texto}
			<br/>
		</c:forEach>
		
		<form action="inserirComentario" method="post">
	
		<input type="hidden" name="idUsuario" value="${usuario_logado.idUsuario}"/>
		<input type="hidden" name="idNoticia" value="${n.idNoticia}"/>
		<br />	
			<c:if test="${papel_logado == 'Leitor'}">
		Escreva seu comentário:<br />
			<textarea name="texto" rows="5" cols="30"> </textarea><br /><br />
			</c:if>
			
			<c:if test="${papel_logado == 'Leitor'}">
		<input type="submit" value="ENVIAR" />
			</c:if>
	</form>
			<c:if test="${papel_logado == 'Jornalista' && usuario_logado.idUsuario == n.usuarioId}">
		<a href="alterarNoticiaFormulario?id=${n.idNoticia}">ALTERAR</a>
			</c:if>
			<c:if test="${(papel_logado == 'Jornalista' && usuario_logado.idUsuario == n.usuarioId) || papel_logado == 'Editor'}"> 
		<a href="apagarNoticia?id=${n.idNoticia}">APAGAR</a>	
			</c:if>
	
	</c:forEach>


</body>
</html>