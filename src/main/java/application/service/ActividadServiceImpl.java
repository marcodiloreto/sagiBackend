package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.JPArepository.IActividadDao;
import application.JPArepository.IDisciplinaDao;
import application.JPArepository.IPersonaDao;
import application.JPArepository.IPlanDao;
import application.modelo.Actividad;
import application.modelo.Persona;
import application.modelo.Plan;
import application.modelo.updater.ActividadUpdater;

@Service("actividadService")
public class ActividadServiceImpl implements ActividadService {

	@Autowired
	private IActividadDao aDao;

	@Autowired
	private IPersonaDao pDao;

	@Autowired
	private IDisciplinaDao dDao;
	
	@Autowired 
	private IPlanDao plDao;
	
	@Autowired
	private ActividadUpdater aU;

	@Override
	public List<Actividad> findAllActividades() {
		List<Actividad> a = aDao.findAll();

		return a;
	}

	@Override
	public Page<Actividad> findAllActividades(Pageable pageable) {
		Page<Actividad> a = aDao.findAll(pageable);
		return a;
	}

	@Override
	public Actividad findActividadById(Long id) {
		Optional<Actividad> a = aDao.findById(id);
		// System.out.println(a);
		return a.get();
	}

	@Override
	public Actividad saveActividad(Actividad actividad) {
		return aDao.save(actividad);
	}

	@Override
	public Boolean deleteActividad(Long id) {
		Actividad a = aDao.getById(id);
		a.setBajaLogica(true);
		return aDao.save(a).getBajaLogica();
	}

	@Override
	public boolean deshacerDelete(Long id) {
		Actividad a = aDao.getById(id);
		a.setBajaLogica(false);
		return aDao.save(a).getBajaLogica();
	}

	public List<Persona> getInteresados(Long id) {
		Actividad a = aDao.getById(id);
		return a.getInteresados();
	}

	@Transactional
	public Actividad newActividad(Actividad a, Long idUs, Long idDi) {
		a.creadoresAdd(pDao.getById(idUs));
		a.setDisciplina(dDao.getById(idDi));
		return saveConPlanes(a);
	}
	
	@Transactional
	public Actividad updateActividad(Actividad nueva) {
		Optional<Actividad> vieja = aDao.findById(nueva.getID());		
		nueva = aU.format(nueva, vieja.get());
		nueva = saveConPlanes(nueva);
		return nueva;
	}
	
	@Transactional
	public Actividad saveConPlanes(Actividad a) {
		List<Plan> planes = a.getPlanes();
		a.setPlanes(null);
		aDao.save(a);
		planes.forEach( (plan)->{ plan.setActividad(a); plDao.save(plan);});
		return aDao.getById(a.getID());
	}

}
