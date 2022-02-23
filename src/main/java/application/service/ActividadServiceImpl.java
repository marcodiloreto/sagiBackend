package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.modelo.Actividad;
import application.repository.ActividadDao;



@Service("actividadService")

@Transactional(readOnly = true)
public class ActividadServiceImpl implements ActividadService {

	@Autowired
	private ActividadDao aDao;
	
//	@Autowired
//	private static SessionFactory sessionFactory;
//	
//	public ActividadServiceImpl() {
//		if (sessionFactory == null) {
//		sessionFactory = new Configuration().configure().buildSessionFactory();
//		}
//	} 
	
	@Override
	public List<Actividad> findAllActividades() {
		return aDao.findAllActividades();
	}

	@Override
	public Actividad findActividadById(long id) {
		Actividad a = aDao.findActividadById(id);
		//System.out.println(a);
		return a;
	}

	@Override
	@Transactional
	public void insertActividad(Actividad actividad) {
		aDao.insertActividad(actividad);
	}

	@Override
	@Transactional
	public void updateActividad(Actividad actividad) {
		aDao.updateActividad(actividad);
	}

	@Override
	@Transactional
	public void deleteActividad(Actividad actividad) {
		aDao.deleteActividad(actividad);
	}
	
	@Override
	public Actividad getDisciplina(Actividad actividad){
		actividad = this.findActividadById(actividad.getID());
		actividad.getDisciplina();
		return actividad;
	}
	
//	public Session getCurrentSession() {
//		 //
//		 Session s = sessionFactory.openSession();
//		 return sessionFactory.getCurrentSession();
//	}

}
