package app.g1.examenChristianZhiminaicelaServidor.DAOS;

import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import app.g1.examenChristianZhiminaicelaServidor.entidades.Destinario;

@Stateless
public class destinarioDAO {
	
	@Inject
	private EntityManager em;
	
	
	public boolean insert(Destinario entity) throws SQLException {

		em.persist(entity);
		return true;
	}

	public boolean update(Destinario entity) {
		em.merge(entity);
		return true;
	}

	public Destinario read(int id) {
		Destinario entity = em.find(Destinario.class, id);
		return entity;
	}

	public boolean delete(int id) {
		Destinario entity = this.read(id);
		em.remove(entity);
		return true;

	}
	
	public List<Destinario> getList() {
		
		String jpql = "SELECT d FROM Destinario d";
		
		Query q = em.createQuery(jpql, Destinario.class);
		
		return (List<Destinario>) q.getResultList();
	}
	

}
