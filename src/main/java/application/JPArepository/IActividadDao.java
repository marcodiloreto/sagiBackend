package application.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.modelo.Actividad;

public interface IActividadDao extends JpaRepository<Actividad, Long> {

}
