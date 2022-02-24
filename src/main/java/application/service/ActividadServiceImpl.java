package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.JPArepository.IActividadDao;
import application.modelo.Actividad;




@Service("actividadService")
@Transactional(readOnly = true)
public class ActividadServiceImpl implements ActividadService {

	@Autowired
	private IActividadDao aDao;
	
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
		return aDao.findAll();
	}

	@Override
	public Actividad findActividadById(long id) {
		Optional<Actividad> a = aDao.findById(id);
		//System.out.println(a);
		return a.get();
	}

	@Override
	@Transactional
	public void saveActividad(Actividad actividad) {
		aDao.save(actividad);
	}

	@Override
	@Transactional
	public void deleteActividad(Actividad actividad) {
		aDao.delete(actividad);
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
