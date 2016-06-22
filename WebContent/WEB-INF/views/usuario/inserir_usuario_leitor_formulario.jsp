<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/jornalUFC.css" rel="stylesheet">
<title>Inserir Usuario Leitor</title>
</head>
<body>
	
	<form action="inserirUsuarioLeitor" method="post">
		Nome: <input type="text" name="nome" />
		<form:errors path="usuario.nome" /> 
		<br />
		Login: <input type="text" name="login" /><br />
		Senha: <input type="password" name="senha" /><br />
		Email: <input type="text" name="email" /><br />
		<input type="hidden" name="idPapel" value="3">
		<input type="submit" value="ENVIAR" />
	</form>

</body>
</html>