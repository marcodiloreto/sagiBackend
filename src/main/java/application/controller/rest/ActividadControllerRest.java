package application.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import application.controller.SagiAppControllerRest;
import application.modelo.Actividad;
import application.service.ActividadService;

@RestController
public class ActividadControllerRest extends SagiAppControllerRest {


	private final Logger LOGGER = LoggerFactory.getLogger(ActividadControllerRest.class);	

	@Autowired
	private ActividadService service;

	@GetMapping(path = "/actividad/all")
	public List<Actividad> getList() {
		LOGGER.info("Lista todas las actividades");
		
		return service.findAllActividades();
		
	}

}
