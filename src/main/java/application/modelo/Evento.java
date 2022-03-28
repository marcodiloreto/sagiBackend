package application.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import application.modelo.auxiliar.EstadoEvento;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Evento implements Serializable{

	private static final long serialVersionUID = 28937542098L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	private Time horaInicio;
	
	private Time horaFin;
	
	private Date fecha;
	
	private String direccion;
	
	private EstadoEvento estado;
	
	@ManyToOne
	@JoinColumn(name="actividadID")
	private Actividad actividad;
	
	
	
//	`ID` INT(11) NOT NULL AUTO_INCREMENT,
//	  `horaInicio` TIME NOT NULL,
//	  `horaFin` TIME NOT NULL,
//	  `fecha` DATE NOT NULL,
//	  `direccion` VARCHAR(45) NOT NULL,
//	  `estado` VARCHAR(45) NULL DEFAULT NULL,
//	  `actividadID` INT(11) NOT NULL,
//	  `bajaLogica` BIT(1) NOT NULL DEFAULT 0,
}
