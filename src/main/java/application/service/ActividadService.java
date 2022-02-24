package application.service;

import java.util.List;

import org.hibernate.Session;

import application.modelo.Actividad;

public interface ActividadService {

    public List<Actividad> findAllActividades();

    public Actividad findActividadById(long id);

    public void saveActividad(Actividad actividad);

    public void deleteActividad(Actividad actividad);
    
    public Actividad getDisciplina(Actividad actividad);
    
    //public Session getCurrentSession();
}
