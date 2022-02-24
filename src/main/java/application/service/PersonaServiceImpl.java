package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import application.JPArepository.IPersonaDao;
import application.modelo.Persona;
import org.springframework.transaction.annotation.Transactional;

@Service("personaService")
@Transactional(readOnly = true)
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private IPersonaDao pDao;

    @Override
    public List<Persona> findAllPersonas() {
        return pDao.findAll();
    }

   
    @Override
    public Persona findPersonaById(Long id) {
    	Optional<Persona> p = pDao.findById(id);
    	return p.get();
    }
    
    @Override
    @Transactional
    public void savePersona(Persona persona) {
        pDao.save(persona);
    }

    @Override
    @Transactional
    public void deletePersona(Persona persona) {
        pDao.delete(persona);
    }
}