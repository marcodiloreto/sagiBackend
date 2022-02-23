package application.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import application.modelo.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Repository
public class PersonaDaoImpl implements PersonaDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    public void insertPersona(Persona persona) {
        // Insertamos nuevo objeto0
    	try {
    	em.persist(persona);
    	}catch (Throwable e) {
    		log.error("ERROR ERROR", e);
    	}
    	}
    	

    public void updatePersona(Persona persona) {
        // Actualizamos al objeto 
        em.merge(persona);
    }


    public void deletePersona(Persona persona) {
         em.remove(em.merge(persona));
    }


    public Persona findPersonaById(long idPersona) {
        return em.find(Persona.class, idPersona);
    }


    public List<Persona> findAllPersonas() {
        String jpql = "SELECT p FROM Persona p";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

  
    public long contadorPersonas() {
        String consulta = "select count(p) from Persona p";
        Query q = em.createQuery(consulta);
        return  (Long) q.getSingleResult();
    }

 
    /*public Persona getPersonaByEmail(Persona persona) {
        String cadena = "%" + persona.getEmail() + "%"; //se usa en el like como caracteres especiales
        String consulta = "from Persona p where upper(p.email) like upper(:param1)";
        Query q = em.createQuery(consulta);
        q.setParameter("param1", cadena);
        return (Persona) q.getSingleResult();
    }*/
}