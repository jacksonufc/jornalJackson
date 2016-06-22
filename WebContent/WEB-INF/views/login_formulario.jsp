<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>Jornal Eletrônico</title>
	<link href="resources/css/jornalUFC.css" rel="stylesheet">
	<meta name="author" content="Jackson Freitas" />
	<meta name="generator" content="Gerenciador de Conteúdo" />
</head>
<body>

<div class="login_form">
	<form action="login" method="post">
	<img src="resources/imagem/logo_ufc.png" style="width:228px; margin: 0 auto;" />
	<br />
	
	Login: <input type="text" name="login" size="40"/> <br /><br />
	Senha: <input type="password" name="senha" size="40" /> <br /><br />
	Seção: <select name="idPapel">
                    <option value="0">Escolha uma opção</option>
                    <option value="Editor">Editor</option>
                    <option value="Jornalista">Jornalista</option>
                    <option value="Leitor">Leitor</option>
                    </select>
                <br /><br />            
	<input type="submit" value="ENVIAR"><br /><br />
	</form>
	
	
</div>
<form action="inserirUsuarioFormulario" method="post">
		<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>