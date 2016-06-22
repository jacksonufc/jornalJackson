package br.ufc.controle;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.DAO.ComentarioDAO;
import br.ufc.DAO.NoticiaDAO;
import br.ufc.DAO.UsuarioDAO;
import br.ufc.modelo.Comentario;
import br.ufc.modelo.Noticia;
import br.ufc.modelo.Usuario;

@Transactional
@Controller
public class ComentarioControle {

	@Autowired
	@Qualifier(value="comentarioDAO")
	private ComentarioDAO cDAO;

	@Autowired
	private NoticiaDAO nDAO;
	
	@Autowired
	private UsuarioDAO uDAO;
	
	@RequestMapping("/inserirComentarioFormulario")
	public String inserirComentarioFormulario(){
		return "comentario/inserir_comentario_formulario";
	}
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(@Valid Comentario comentario, Long idNoticia, Long idUsuario,
							   BindingResult result){
		
		if(result.hasFieldErrors("nome")){
			return "comentario/inserir_comentario_formulario";
		}
		
		
		Usuario user = uDAO.recuperar(idUsuario);
		Noticia not = nDAO.recuperar(idNoticia);
		comentario.setUsuario(user);
		
		Collection<Comentario> comentarios = not.getComentario();
		comentarios.add(comentario);
		
		not.setComentario(comentarios);
		nDAO.alterar(not);
		
		comentario.setNoticia(not);
		
		this.cDAO.inserir(comentario);
		
		return "redirect:listarNoticia?idSecao=" + not.getSecaoId();
	}
	
	@RequestMapping("/listarComentario")
	public String listarComentario(Model model){
		
		
		List<Comentario> comentarios = this.cDAO.listar();
		model.addAttribute("comentarios", comentarios);
		
		
		return "comentario/listar_comentario";
	}	
	
	@RequestMapping("/apagarComentario")
	public String apagarComentario(Long id){
		
		this.cDAO.apagar(id);
		return "redirect:listarComentario";
	}
	
	@RequestMapping("/alterarComentarioFormulario")
	public String alterarComentarioFormulario(Long id, Model model){
		
		Comentario comentario = this.cDAO.recuperar(id);
		model.addAttribute("comentario", comentario);
		return "comentario/alterar_comentario_formulario";
	}
	
	@RequestMapping("/alterarComentario")
	public String alterarComentario(Comentario comentario){
		
		this.cDAO.alterar(comentario);
		return "redirect:listarComentario";
	}
}
