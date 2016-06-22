<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Papel</title>
</head>
<body>

<table border="1">
	<c:forEach var="p" items="${papeis}">
	<tr>
		<td>${p.idPapel}</td>
		<td>${p.papel}</td>
		<td><a href="alterarPapelFormulario?id=${p.idPapel}">ALTERAR</a></td>
		<td><a href="apagarPapel?id=${p.idPapel}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>