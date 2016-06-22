package br.ufc.controle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.DAO.ClassificadoDAO;
import br.ufc.DAO.UsuarioDAO;
import br.ufc.modelo.Classificado;
import br.ufc.modelo.Usuario;

@Transactional
@Controller
public class ClassificadoControle {
	
	@Autowired
	@Qualifier(value="classificadoDAO")
	private ClassificadoDAO cDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario(){
		return "classificado/inserir_classificado_formulario";
	}
	
	@RequestMapping("/inserirClassificado")
	public String inserirClassificado(@Valid Classificado classificado,
							   BindingResult result){
		
		if(result.hasFieldErrors("nome")){
			return "classificado/inserir_classificado_formulario";
		}
		
		this.cDAO.inserir(classificado);
		
		return "classificado/classificado_inserido_ok";
	}
	
	@RequestMapping("/listarClassificado")
	public String listarClassificado(Model model){
		
		
		List<Classificado> classificados = this.cDAO.listar();
		model.addAttribute("classificados", classificados);
		
		
		return "classificado/listar_classificado";
	}	
	
	@RequestMapping("/apagarClassificado")
	public String apagarClassificado(Long id){
		
		this.cDAO.apagar(id);
		return "redirect:listarClassificado";
	}
	
	@RequestMapping("/alterarClassificadoFormulario")
	public String alterarClassificadoFormulario(Long id, Model model){
		
		Classificado classificado = this.cDAO.recuperar(id);
		model.addAttribute("classificado", classificado);
		return "classificado/alterar_classificado_formulario";
	}
	
	@RequestMapping("/alterarClassificado")
	public String alterarClassificado(Classificado classificado){
		
		this.cDAO.alterar(classificado);
		return "redirect:listarClassificado";
	}
	
	@RequestMapping("/inserirOferta")
	public String inserirOferta(Classificado classificado, Usuario usuario){
		Usuario qualquer = uDAO.recuperar(usuario.getIdUsuario());
		Classificado huas = cDAO.recuperar(classificado.getIdClassificado());
		
		huas.setMelhorOferta(classificado.getMelhorOferta());
		
		huas.setNomeLeitor(qualquer.getNome());
		
		this.cDAO.alterar(huas);
		return "redirect:listarClassificado";
	}
}
