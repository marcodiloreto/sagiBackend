package application.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import application.controller.SagiAppControllerRest;
import application.dto.ActividadViewDto;
import application.dto.modelMapper.ActividadViewModelMapper;
import application.modelo.Actividad;
import application.modelo.Persona;
import application.modelo.updater.ActividadUpdater;
import application.service.ActividadService;

@RestController
@RequestMapping(path = "/actividad")
public class ActividadControllerRest extends SagiAppControllerRest {

	private final Logger LOGGER = LoggerFactory.getLogger(ActividadControllerRest.class);

	@Autowired
	private ActividadService service;

	@Autowired
	private ActividadViewModelMapper actividadViewMm;


	@GetMapping(path = "/all")
	public ResponseEntity<Object> getList() {
		Page<ActividadViewDto> a = service.findAllActividades(PageRequest.of(0, 100))
				.map(act -> actividadViewMm.aDto(act));
		return ResponseEntity.ok().body(a);
	}

	/*
	 * @GetMapping(path = "/{id}/anotados") public List<Persona>
	 * getAnotados(@PathVariable Long id){ List<Persona> p =
	 * service.getInteresados(id); return p; }
	 */

	@PostMapping("/new")
	@ResponseBody
	public ResponseEntity<Object> crearActividad(@RequestBody Actividad a, @RequestHeader("idUs") Long idUs,
			@RequestHeader("idDi") Long idDi) {
		Actividad b = service.newActividad(a, idUs, idDi);
		return ResponseEntity.ok(b.getID());
	}

	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<Object> modificarActividad(@RequestBody Actividad a) {
		a = service.updateActividad(a);
		return ResponseEntity.ok(a.getID());
	}

	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseEntity<Object> eliminarActividad(Long ID) {
		boolean a = service.deleteActividad(ID);
		return ResponseEntity.ok("Actividad con id:" + ID + " bajaLogica = " + a);
	}

	@PatchMapping("/delete/undo")
	@ResponseBody
	public ResponseEntity<Object> deshacerEliminarActividad(Long ID) {
		boolean a = service.deshacerDelete(ID);
		return ResponseEntity.ok("Actividad con id:" + ID + " bajaLogica = " + a);
	}

}
