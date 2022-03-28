package application.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;

import application.modelo.auxiliar.Semana;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DiasSemana {
	
	@Id
	private Long ID;
	
	@Enumerated(EnumType.STRING)
	private Semana dia;
	
	@JsonCreator
	public DiasSemana(Long ID, Semana dia) {
		this.ID = ID;
		this.dia = dia;
	}
}
