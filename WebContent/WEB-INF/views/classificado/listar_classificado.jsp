<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Listar Classificado</title>
</head>
<body>

<table border="1">
	<tr>
		<th>TITULO</th>
		<th>TEXTO</th>
		<th>PREÇO</th>
		<th>TELEFONE</th>
		<th>MELHOR OFERTA</th>
		<th>DATA OFERTA</th>
		<th>AUTOR MELHOR OFERTA</th>
	</tr>
	
	<c:forEach var="c" items="${classificados}">
	<tr>
		<td>${c.titulo}</td>
		<td>${c.texto}</td>
		<td>${c.preco}</td>
		<td>${c.telefone}</td>
		<td>${c.melhorOferta}</td>
		<td>${c.dataOferta}</td>
		<td>${c.nomeLeitor}</td>
		
		<td><form action="inserirOferta" method="post">
			<input type="hidden" name="idClassificado" value="${c.idClassificado}" />
			<input type="hidden" name="idUsuario" value="${usuario_logado.idUsuario}" />
			<input type="text" name="melhorOferta" value="${c.melhorOferta}" /><br />
			
			<input type="submit" value="OFERTAR" />
		</form>
		</td>
		
		<!-- <td><a href="inserirOferta?id=${c.idClassificado}">Ofertar</a></td> -->
	</tr>
	</c:forEach>
</table>

</body>
</html>