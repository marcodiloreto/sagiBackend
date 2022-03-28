package application.dto.modelMapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import application.dto.ActividadViewDto;
import application.modelo.Actividad;

@Component
public class ActividadViewModelMapper{

	public ActividadViewDto aDto(Actividad a) {
		
		ActividadViewDto dto= new ActividadViewDto();
		
		dto.setID(a.getID());
		dto.setNombreActividad(a.getNombre());
		dto.setDesc(a.getDescripcion());
		dto.setCreadores(a.getCreadores().stream().map(p -> p.getNombre()).collect(Collectors.toList()));
		dto.setDireccion(a.getDireccion());
		dto.setDisciplina(a.getDisciplina().getNombre());
		dto.setPersonas(a.getInteresados().size());
		dto.setPrecio(a.getPrecio());
		dto.setMaxCupos(a.getMaxCupos());
		dto.setPlanes(a.getPlanes());//.stream().map(ds -> ds.getDia()).collect(Collectors.toList()));
		return dto;
	}

	
}
