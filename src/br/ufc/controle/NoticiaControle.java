package br.ufc.controle;

import javax.servlet.ServletContext;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.DAO.NoticiaDAO;
import br.ufc.DAO.SecaoDAO;
import br.ufc.DAO.UsuarioDAO;
import br.ufc.modelo.Noticia;
import br.ufc.modelo.Secao;
import br.ufc.modelo.Usuario;
import br.ufc.util.AulaFileUtil;

@Transactional
@Controller
public class NoticiaControle {

	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAO nDAO;
	
	@Autowired
	private SecaoDAO sDAO;
	
	@Autowired
	private UsuarioDAO uDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(Model model){
		
		List<Secao> secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);
		
		return "noticia/inserir_noticia_formulario";
	}
	
	/*@RequestMapping("/principal")
	public String inserirNoticiaHome(Model model){
		
		List<Secao> secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);
		
		return "../../home";
	}*/
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(@Valid Noticia noticia, Long idSecao, Long idUsuario,
							   BindingResult result,
							   @RequestParam(value="imagem", required=false) MultipartFile imagem){
		
		if(result.hasFieldErrors("nome")){
			return "noticia/inserir_noticia_formulario";
		}
		
		String path = servletContext.getRealPath("/")+"resources/imagem/"+noticia.getTitulo()+".png";
		
		AulaFileUtil.salvarImagem(path, imagem);
		
		Usuario user = uDAO.recuperar(idUsuario);
		noticia.setUsuario(user);
		
		Secao sc = sDAO.recuperar(idSecao);
		
		noticia.setSecao(sc);
		
		this.nDAO.inserir(noticia);
		
		return "noticia/noticia_inserido_ok";
	}
	
	@RequestMapping("/listarNoticia")
	public String listarNoticia(Model model, Long idSecao){
		
		List<Noticia> noticias = this.nDAO.listar(idSecao);
		model.addAttribute("noticias", noticias);
		
		
		return "noticia/listar_noticia";
	}
	
	/*@RequestMapping("/listarNoticiaSecao")
	public String listarNoticiaSecao(Model model, Long id){
		List<Noticia> n = this.nDAO.listar();
		List<Noticia> lista = new ArrayList<Noticia>();
		for(int i = 0; i < n.size(); i++){
			if(n.get(i).getSecaoId() == id){
				lista.add(n.get(i));
			}
		}
		
		model.addAttribute("noticias", lista);
		
		
		return "noticia/listar_noticia";
	}*/
	
	@RequestMapping("/apagarNoticia")
	public String apagarNoticia(Long id){
		
		this.nDAO.apagar(id);
		return "redirect:listarNoticia";
	}
	
	@RequestMapping("/alterarNoticiaFormulario")
	public String alterarNoticiaFormulario(Long id, Model model){
		
		Noticia noticia = this.nDAO.recuperar(id);
		model.addAttribute("noticia", noticia);
		return "noticia/alterar_noticia_formulario";
	}
	
	@RequestMapping("/alterarNoticia")
	public String alterarNoticia(Noticia noticia){
		
		this.nDAO.alterar(noticia);
		return "redirect:listarNoticia";
	}
}
