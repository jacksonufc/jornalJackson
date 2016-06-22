package br.ufc.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.modelo.Papel;
import br.ufc.modelo.Usuario;

@Repository
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Usuario usuario) {
		manager.persist(usuario);		
	}

	public void alterar(Usuario usuario) {
		manager.merge(usuario);
	}

	public Usuario recuperar(Long id) {
		return manager.find(Usuario.class, id);
	}

	public Usuario getBuscarPorLogin(String login){
		String hql = "select u from usuario u where u.login='" + login + "'";
		List<?> resultado = manager.createQuery(hql).getResultList();
		if(!resultado.isEmpty()){
			return manager.createQuery(hql, Usuario.class).getResultList().get(0);
		}
		return null;
	}
	
	public void apagar(Long id) {
		Usuario ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
	}
	
	public boolean buscar_papel(Long id_user, String papel){
		Usuario ref = this.recuperar(id_user);
		List<Papel> papeis = ref.getPapelList();
		for (Papel aux : papeis) {
			if(aux.getPapel().equals(papel))
				return true;
		}
		return false;
	}

	public List<Usuario> listar() {
		return manager.createQuery("select u from usuario as u",
				Usuario.class).getResultList();
	}
}
