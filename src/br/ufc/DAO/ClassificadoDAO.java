package br.ufc.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.modelo.Classificado;

@Repository
public class ClassificadoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Classificado classificado) {
		manager.persist(classificado);		
	}

	public void alterar(Classificado classificado) {
		manager.merge(classificado);
	}

	public Classificado recuperar(Long id) {
		return manager.find(Classificado.class, id);
	}

	public void apagar(Long id) {
		Classificado ref = this.recuperar(id);
		if(ref!=null){
			manager.remove(ref);
		}
	}

	public List<Classificado> listar() {
		return manager.createQuery("select c from classificado as c",
				Classificado.class).getResultList();
	}
}
