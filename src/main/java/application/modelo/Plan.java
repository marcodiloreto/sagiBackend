package application.modelo;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Plan  implements Serializable{
	
	private static final long serialVersionUID = 3202089571512147323L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@OneToOne
	@JoinColumn(name="diasSemanaID")
	private DiasSemana dia;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
	private Time horaInicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
	private Time horaFin;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="actividadID")
	private Actividad actividad;
	
	@JsonCreator
	public Plan(int ID, DiasSemana dia, Time horaInicio,Time horaFin) {
		this.dia = dia;
		this.ID = ID;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
}
