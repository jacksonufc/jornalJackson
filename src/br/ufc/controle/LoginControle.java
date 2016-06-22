package br.ufc.controle;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.DAO.PapelDAO;
import br.ufc.DAO.UsuarioDAO;
import br.ufc.criptografia.Criptografia;
import br.ufc.modelo.Papel;
import br.ufc.modelo.Usuario;

@Controller
public class LoginControle {

	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	private PapelDAO pDAO;
	
	@RequestMapping("/loginFormulario")
	public String loginFormulario(){
		return "login_formulario";
	}
	
	@RequestMapping("/login")
	public String login(Usuario usuario, HttpSession session, String idPapel, 
						HttpSession sessionpapel){
		Criptografia cripto = new Criptografia();
		//usuario.setSenha(cripto.criptografa(usuario.getSenha()));
		String senha = cripto.criptografa(usuario.getSenha());
		Usuario candidato = uDAO.getBuscarPorLogin(usuario.getLogin());
		if(candidato!=null){
			List<Papel> papeis = candidato.getPapelList();					
			if(candidato.getSenha().equals(senha) && this.uDAO.buscar_papel(candidato.getIdUsuario(), idPapel)){
				session.setAttribute("usuario_logado", candidato);
				sessionpapel.setAttribute("papel_logado", idPapel);
				return "menu";
			}
		}
		return "redirect:loginFormulario";
	}
	
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}