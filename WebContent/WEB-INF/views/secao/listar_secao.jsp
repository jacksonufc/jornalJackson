<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Listar Secao</title>
</head>
<body>

<table border="1">
	<tr>
		<th>TITULO</th>
		<th>DESCRIÇÃO</th>
		<th>ALTERAR</th>
		<th>APAGAR</th>
	</tr>
	
	<c:forEach var="s" items="${secoes}">
	<tr>
		<td><a href="listarNoticia?idSecao=${s.idSecao}">${s.titulo}</a></td>
		<td>${s.descricao}</td>
		<td><a href="alterarSecaoFormulario?id=${s.idSecao}">ALTERAR</a></td>
			<c:if test="${papel_logado == 'Jornalista' || papel_logado == 'Editor'}">
		<td><a href="apagarSecao?id=${s.idSecao}">APAGAR</a></td>
			</c:if>
		
	</tr>
	</c:forEach>
</table>

</body>
</html>