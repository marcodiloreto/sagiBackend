package application.JPArepository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import application.modelo.Actividad;

public interface IActividadDao extends JpaRepository<Actividad, Long> {

//	@Query("SELECT a.disciplina FROM Actividad a where a.id = :id ")
//	Disciplina getDisciplina(@Param("id") Long id);
//	
//	@Query("SELECT a.interesados FROM Actividad a where a.id = :id")
//	List<Persona> getPersonas(@Param("id") Long id);
	
	@Query("SELECT a FROM Actividad a where a.bajaLogica = false")
	Page<Actividad> findAll(Pageable a);
}
