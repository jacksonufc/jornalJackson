package br.ufc.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.modelo.Secao;

@Repository
public class SecaoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Secao secao) {
		manager.persist(secao);		
	}

	public void alterar(Secao secao) {
		manager.merge(secao);
	}

	public Secao recuperar(Long id) {
		return manager.find(Secao.class, id);
	}

	public void apagar(Long id) {
		Secao ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
	}

	public List<Secao> listar() {
		return manager.createQuery("select s from secao as s",
				Secao.class).getResultList();
	}
}
