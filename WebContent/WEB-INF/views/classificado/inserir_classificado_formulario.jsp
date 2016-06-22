<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Inserir Classificado</title>
</head>
<body>
	
	<form action="inserirClassificado" method="post">
	
		<input type="hidden" name="idUsuario" value="${usuario_logado.idUsuario}">
	
		Titulo: <input type="text" name="titulo" />
		<form:errors path="classificado.titulo" /> 
		<br />
		Texto: <input type="text" name="texto" /><br />
		Preço: <input type="text" name="preco" /><br />
		Telefone: <input type="text" name="telefone" /><br />
			<c:if test="${papel_logado == 'Leitor'}">
		Melhor Oferta: <input type="text" name="melhorOferta" /><br />
		Data Oferta: <input type="text" name="dataOferta" /><br />
			</c:if>
		<input type="submit" value="ENVIAR" />
	</form>

</body>
</html>