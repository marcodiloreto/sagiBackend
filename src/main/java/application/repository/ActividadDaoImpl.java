package application.repository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import application.modelo.Actividad;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class ActividadDaoImpl implements ActividadDao {

	  Logger log = LogManager.getRootLogger();
	  
	    @PersistenceContext
	    private EntityManager em;
	    
	@Override
	public void insertActividad(Actividad actividad) {
		   // Insertamos nuevo objeto
    	try {
    	em.persist(actividad);
    	}catch (Throwable e) {
    		log.error("ERROR ERROR", e);
    	}
	}

	@Override
	public void updateActividad(Actividad actividad) {
		 // Actualizamos al objeto 
        em.merge(actividad);
	}

	@Override
	public void deleteActividad(Actividad actividad) {
		em.remove(em.merge(actividad));
	}

	@Override
	public Actividad findActividadById(long idActividad) {
//		EntityTransaction a = em.getTransaction(); 
//		System.out.println(a);
		return em.find(Actividad.class, idActividad);
	}

	@Override
	public List<Actividad> findAllActividades() {
		 String jpql = "SELECT a FROM Actividad a";
	        Query query = em.createQuery(jpql);
	        return query.getResultList();
	}

	@Override
	public long contadorActividad() {
		String consulta = "select count(a) from Actividad a";
        Query q = em.createQuery(consulta);
        return  (Long) q.getSingleResult();
	}
	
	public Actividad getDisciplina(Actividad a) {
		Long id = a.getID();
		String consulta = "SELECT a FROM Actividad a JOIN FETCH a.disciplina WHERE a.id = :id";
		return em.createQuery(consulta, Actividad.class).setParameter("id",id).getSingleResult();
	}
	
	

}
