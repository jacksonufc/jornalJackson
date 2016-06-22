package br.ufc.controle;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.DAO.UsuarioDAO;
import br.ufc.criptografia.Criptografia;
import br.ufc.modelo.Papel;
import br.ufc.modelo.Usuario;
import br.ufc.util.AulaFileUtil;

@Transactional
@Controller
public class UsuarioControle {

	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(){
		return "usuario/inserir_usuario_formulario";
	}
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(@Valid Usuario usuario,
							   BindingResult result, Papel papel,
							   @RequestParam(value="imagem", required=false) MultipartFile imagem){
		
		if(result.hasFieldErrors("nome")){
			return "usuario/inserir_usuario_formulario";
		}
		
		String path = servletContext.getRealPath("/")+"resources/imagem/"+usuario.getLogin()+".png";
		
		AulaFileUtil.salvarImagem(path, imagem);
		
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(papel);
		usuario.setPapelList(papeis);
		
		Criptografia cripto = new Criptografia();
		usuario.setSenha(cripto.criptografa(usuario.getSenha()));
		
		this.uDAO.inserir(usuario);
		
		return "usuario/usuario_inserido_ok";
	}
	
	@RequestMapping("/inserirUsuarioLeitorFormulario")
	public String inserirUsuarioLeitorFormulario(){
		return "usuario/inserir_usuario_leitor_formulario";
	}
	
	@RequestMapping("/inserirUsuarioLeitor")
	public String inserirUsuario(@Valid Usuario usuario, Papel papel,
							   BindingResult result){
		
		if(result.hasFieldErrors("nome")){
			return "usuario/inserir_usuario_formulario";
		}
		
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(papel);
		usuario.setPapelList(papeis);
		
		Criptografia cripto = new Criptografia();
		usuario.setSenha(cripto.criptografa(usuario.getSenha()));
		
		this.uDAO.inserir(usuario);
		
		return "usuario/usuario_inserido_ok";
	}
	
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model){
		
		
		List<Usuario> usuarios = this.uDAO.listar();
		model.addAttribute("usuarios", usuarios);
		
		
		return "usuario/listar_usuario";
	}	
	
	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long id){
		
		this.uDAO.apagar(id);
		return "redirect:listarUsuario";
	}
	
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long id, Model model){
		
		Usuario usuario = this.uDAO.recuperar(id);
		model.addAttribute("usuario", usuario);
		return "usuario/alterar_usuario_formulario";
	}
	
	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario usuario){
		
		this.uDAO.alterar(usuario);
		return "redirect:listarUsuario";
	}
}
