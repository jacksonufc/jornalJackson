package br.ufc.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.modelo.Noticia;

@Repository
public class NoticiaDAO {
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Noticia noticia) {
		manager.persist(noticia);		
	}

	public void alterar(Noticia noticia) {
		manager.merge(noticia);
	}

	public Noticia recuperar(Long id) {
		return manager.find(Noticia.class, id);
	}

	public void apagar(Long id) {
		Noticia ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
	}

	public List<Noticia> listar(Long secaoId) {
		/*return manager.createQuery("select n from noticia as n",
				Noticia.class).getResultList();*/
		String hql = "select n from noticia as n "
				+ "where n.secaoId = :param_secaoId";
		Query query = manager.createQuery(hql);
		
		List<Noticia> noticias = query.setParameter("param_secaoId", secaoId).getResultList();
		return noticias;
	}
}
