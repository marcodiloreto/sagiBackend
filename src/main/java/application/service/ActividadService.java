package application.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import application.modelo.Actividad;
import application.modelo.Persona;

public interface ActividadService {

	public List<Actividad> findAllActividades();

	public Page<Actividad> findAllActividades(Pageable pageable);

	public Actividad findActividadById(Long id);

	public Actividad saveActividad(Actividad actividad);

	public Boolean deleteActividad(Long id);

	public List<Persona> getInteresados(Long id);

	public Actividad newActividad(Actividad a, Long idUs, Long idDi);

	public boolean deshacerDelete(Long iD);

	public Actividad updateActividad(Actividad nueva);
}
