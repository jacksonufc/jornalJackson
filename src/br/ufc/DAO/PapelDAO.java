package br.ufc.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufc.modelo.Papel;

public class PapelDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Papel papel) {
		manager.persist(papel);		
	}

	public void alterar(Papel papel) {
		manager.merge(papel);
	}

	public Papel recuperar(Long id) {
		return manager.find(Papel.class, id);
	}

	public void apagar(Long id) {
		Papel ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
	}

	public List<Papel> listar() {
		return manager.createQuery("select p from papel as p",
				Papel.class).getResultList();
	}
}
