<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>Jornal Eletrônico</title>
	<meta name="author" content="Jackson Freitas" />
	<meta name="generator" content="Gerenciador de Conteúdo" />
	<link href="resources/css/jornalUFC.css" rel="stylesheet">
</head>
<body>

<div id="fundo">
		<div id="conteudo">
			<img id="logo" src="resources/imagem/logo_ufc.png" />
			
			<div id="busca">
				<form method="get" action="loginFormulario">
					<input type="submit" value="Fazer Login" />
				</form>
			</div>
			
			<div id="menu">
				<ul>
					<li><a href="#">Listar Seções</a></li>
					<li><a href="#">CURSOS</a></li>
					<li><a href="#">METODOLOGIA</a></li>
					<li><a href="#">NOTÍCIAS</a></li>
					<li><a href="#">CONTATO</a></li>					
				</ul>
			</div>
			
			<img id="banner" src="resources/imagem/ufc_painel.jpg" />		
			
			<div id="noticias">
			
				<p id="novidades-esquerda">NOVIDADES</p>
				<p id="mais-noticias-direita">Mais Notícias</p>
				
				<div id="conteudo-anuncios">
					<div class="data">
						20 ABR
					</div>	
					<p><a href="#">Professores da UFC Campus Quixadá oferecem aula de atualização de capacitação profissional</a></p><br>
					<hr class="divisor" />
					
					<div class="data">
						20 ABR
					</div>
					<p><a href="#">Professores da UFC Campus Quixadá oferecem aula de atualização de capacitação profissional</a></p><br>
					<hr class="divisor" />
					
					<div class="data">
						20 ABR
					</div>
					<p><a href="#">Professores da UFC Campus Quixadá oferecem aula de atualização de capacitação profissional</a></p><br>
					<hr class="divisor" />
					
					<div class="data">
						20 ABR
					</div>
					<p><a href="#">Professores da UFC Campus Quixadá oferecem aula de atualização de capacitação profissional</a></p><br>
					<hr class="divisor" />
				</div>	
			</div>
			
			<div id="noticiacontinuacao">
			
				<p id="video-esquerda">VÍDEO</p>
				<p id="canal-direita">Canal no Youtube</p>
				
				<iframe width="365" height="250" src="http://www.youtube.com/embed/0kxxY-Xu8JY" frameborder="0" allowfullscreen></iframe>
				<p>Depoimento de Renata sobre os serviços da Delivery</p>
				
				<hr class="divisor" />
	
			</div>
			
			<div id="rodape">
				<img id="celular" src="imagem/celular.png" />
				
				<div id="contato">
					<p>ENTRE EM CONTATO<P>
					<P>85 9696.5400 / 85 8213.6242</P>
				</div>
				
				<img id="atratis" src="imagem/atratis.png" />
			</div>
		
		</div>
	</div>


<h2>Menu</h2>

<a href="loginFormulario"> Efetuar Login </a>
<br />
<br />
<br />
<a href="inserirUsuarioFormulario"> Inserir Usuario </a> <br />
<a href="inserirNoticiaFormulario"> Inserir Noticia </a> <br />
<a href="inserirSecaoFormulario"> Inserir Secao </a> <br />
<a href="inserirClassificadoFormulario"> Inserir Classificado </a> <br />
<a href="inserirComentarioFormulario"> Inserir Comentario </a> <br />
<a href="inserirPapelFormulario"> Inserir Papel </a> <br />
<br />
<a href="listarUsuario">Listar Usuario</a><br />
<a href="listarNoticia">Listar Noticia</a><br />
<a href="listarSecao">Listar Seção</a><br />
<a href="listarClassificado">Listar Classificado</a><br />
<a href="listarComentario">Listar Comentario</a><br />
<a href="listarPapel">Listar Papel</a><br />

</body>
</html>