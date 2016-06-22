<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Início</title>
</head>
<body>

<h2>Bem Vindo ${usuario_logado.nome}!</h2>

<h2>Menu</h2>

<br />
	
	<c:if test="${papel_logado == 'Editor'}">
<a href="inserirUsuarioFormulario"> Inserir Usuario </a> <br />
	</c:if>

	<c:if test="${papel_logado == 'Jornalista'}">
<a href="inserirNoticiaFormulario"> Inserir Noticia </a> <br />
	</c:if>

	<c:if test="${papel_logado == 'Editor'}"> 
<a href="inserirSecaoFormulario"> Inserir Secao </a> <br />
	</c:if>

	<c:if test="${papel_logado == 'Editor'}">
<a href="inserirClassificadoFormulario"> Inserir Classificado </a> <br />
	</c:if>
	
	<c:if test="${papel_logado == 'Leitor'}">
<a href="inserirComentarioFormulario"> Inserir Comentario </a> <br />
	</c:if>

<a href="listarUsuario">Listar Usuario</a><br />

<a href="listarNoticia">Listar Noticia</a><br />

<a href="listarSecao">Listar Seção</a><br />

<a href="listarClassificado">Listar Classificado</a><br />
	
<a href="listarComentario">Listar Comentario</a><br />

<a href="listarPapel">Listar Papel</a><br />
<br />
<a href="logout">Logout</a>
</body>
</html>