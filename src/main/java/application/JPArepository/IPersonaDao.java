package application.JPArepository;

import application.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDao extends JpaRepository<Persona, Long> {

//	@Query("SELECT p.actividades FROM Persona p WHERE p.id = :id ")
//	List<Actividad> getPersonas(@Param("id") Long id);
	
}
