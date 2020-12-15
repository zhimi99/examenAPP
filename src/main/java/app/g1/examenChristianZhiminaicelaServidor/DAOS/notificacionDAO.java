package app.g1.examenChristianZhiminaicelaServidor.DAOS;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import app.g1.examenChristianZhiminaicelaServidor.entidades.Notificacion;

@Stateless
public class notificacionDAO {
	
	@Inject
	private EntityManager em;
	
	
	public boolean insert(Notificacion entity) throws SQLException {

		em.persist(entity);
		return true;
	}

	public boolean update(Notificacion entity) {
		em.merge(entity);
		return true;
	}

	public Notificacion read(int id) {
		Notificacion entity = em.find(Notificacion.class, id);
		return entity;
	}

	public boolean delete(int id) {
		Notificacion entity = this.read(id);
		em.remove(entity);
		return true;

	}
	
	public List<Notificacion> getList() {
		
		String jpql = "SELECT n FROM Notificacion n";
		
		Query q = em.createQuery(jpql, Notificacion.class);
		
		return (List<Notificacion>) q.getResultList();
	}

}
