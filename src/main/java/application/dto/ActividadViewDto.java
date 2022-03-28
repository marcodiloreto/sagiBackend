package application.dto;

import java.sql.Time;
import java.util.List;

import application.modelo.Plan;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActividadViewDto{

	private Long ID;
	
	private String nombreActividad;

	private String desc;
	
	private List<String> creadores;

	private String precio;

	private String promRating;

	private List<Plan> planes;

	private Time horaInicio;

	private Time horaFin;

	private String direccion;
	
	private String disciplina;
	
	private int personas;
	
	private double latitud;
	
	private double longitud;
	
	private int maxCupos;
	

}
