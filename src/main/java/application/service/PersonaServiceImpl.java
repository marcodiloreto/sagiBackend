package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import application.modelo.Persona;
import application.repository.PersonaDao;
import org.springframework.transaction.annotation.Transactional;

@Service("personaService")
@Transactional(readOnly = true)
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;

    @Override
    public List<Persona> findAllPersonas() {
        return personaDao.findAllPersonas();
    }

   
    @Override
    public Persona findPersonaById(Long id) {
        return personaDao.findPersonaById(id);
    }
    
    @Override
    @Transactional
    public void insertPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    @Transactional
    public void updatePersona(Persona persona) {
        personaDao.updatePersona(persona);
        
    }

    @Override
    @Transactional
    public void deletePersona(Persona persona) {
        personaDao.deletePersona(persona);
    }
}