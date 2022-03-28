package application.dto.modelMapper;

import org.springframework.stereotype.Component;

import application.dto.DisciplinaViewDto;
import application.modelo.Disciplina;

@Component
public class DisciplinaViewModelMapper {

	public DisciplinaViewDto aDto(Disciplina d){
		
		DisciplinaViewDto dto = new DisciplinaViewDto();
	
		dto.setID(d.getID());
		dto.setNombre(d.getNombre());
		dto.setFotoURL(d.getFotoURL());
		
		return dto;
	}
}
