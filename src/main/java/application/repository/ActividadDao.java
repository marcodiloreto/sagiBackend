package application.repository;

import java.util.List;


import application.modelo.Actividad;

public interface ActividadDao {
	
	void insertActividad(Actividad actividad);

    void updateActividad(Actividad actividad);

    void deleteActividad(Actividad actividad);

    Actividad findActividadById(long idActividad);

    List<Actividad> findAllActividades();

    long contadorActividad();
    
    Actividad getDisciplina(Actividad a);
	
}
