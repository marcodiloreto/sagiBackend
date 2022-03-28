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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import application.dto.DisciplinaViewDto;
import application.dto.modelMapper.DisciplinaViewModelMapper;
import application.modelo.Disciplina;
import application.service.DisciplinaService;

@RestController
@RequestMapping(path = "/disciplina")
public class DisciplinaControllerRest {

	private final Logger LOGGER = LoggerFactory.getLogger(DisciplinaControllerRest.class);	
	
	@Autowired
	private DisciplinaService service;
	
	@Autowired
	private DisciplinaViewModelMapper dvmm;

	@GetMapping(path = "/all")
	public ResponseEntity<Object> getList() {
		Page<DisciplinaViewDto> a = service.findAllDisciplinas(PageRequest.of(0, 100))
				.map(d -> dvmm.aDto(d));
		// List<Actividad> a = service.findAllActividades();
		return ResponseEntity.ok().body(a);
	}
	
	@GetMapping(path = "/test")
	public void test(){
		List<Disciplina> a = service.findAllDisciplinas();
		System.out.println(a);
	}
	
	@PostMapping("/new")
	@ResponseBody
	public ResponseEntity<Object> crearActividad(@RequestBody Disciplina d) {
		Disciplina b = service.saveDisciplina(d);
		return ResponseEntity.ok(b.getID());
	}
	
	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseEntity<Object> eliminarActividad(Long ID) {
		boolean a = service.deleteDisciplina(ID);
		return ResponseEntity.ok("Actividad con id:" + ID + "eliminada:" +a);
	}
	
	
}
