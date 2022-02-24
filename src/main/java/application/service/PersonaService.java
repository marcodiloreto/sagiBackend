package application.service;

import java.util.List;
import application.modelo.Persona;

public interface PersonaService {

    public List<Persona> findAllPersonas();

    public Persona findPersonaById(Long id);

    public void savePersona(Persona persona);

    public void deletePersona(Persona persona);
}