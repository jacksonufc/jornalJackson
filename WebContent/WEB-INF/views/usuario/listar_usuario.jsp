<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Listar Usuario</title>
</head>
<body>

<table border="1">
	<tr>
		<th>ID_USUARIO</th>
		<th>NOME</th>
		<th>LOGIN</th>
		<th>SENHA</th>
		<th>EMAIL</th>
		<th>ALTERAR</th>
		<th>APAGAR</th>
	</tr>
	

	<c:forEach var="u" items="${usuarios}">
	<tr>
		<td>${u.idUsuario}</td>
		<td>${u.nome}</td>
		<td>${u.login}</td>
		<td>${u.senha}</td>
		<td>${u.email}</td>
		<td><img alt="${a.nome}" src="<c:url value="/resources/imagem/${u.login}.png"  />" /></td>
		<td><a href="alterarUsuarioFormulario?id=${u.idUsuario}">ALTERAR</a></td>
		<td><a href="apagarUsuario?id=${u.idUsuario}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>