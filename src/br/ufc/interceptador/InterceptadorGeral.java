package br.ufc.interceptador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptadorGeral extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String URI = request.getRequestURI();
		if(URI.equals("/Jornal_Eletronico/resources/css/jornalUFC.css") || URI.contains("resources/imagem/")){
			return true;
		}
		if(URI.endsWith("loginFormulario") ||
		   URI.endsWith("login") || URI.endsWith("inserirUsuarioFormulario") || URI.endsWith("inserirUsuario") )
				return true;
		 
		
		if(request.getSession().getAttribute("usuario_logado")!=null){
			return true;
		}
		
		response.sendRedirect("loginFormulario");
		return false;
	}
}
