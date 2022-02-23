package application.service;

import java.util.List;
import application.modelo.Persona;

public interface PersonaService {

    public List<Persona> findAllPersonas();

    public Persona findPersonaById(Long id);

    public void insertPersona(Persona persona);

    public void updatePersona(Persona persona);

    public void deletePersona(Persona persona);
}