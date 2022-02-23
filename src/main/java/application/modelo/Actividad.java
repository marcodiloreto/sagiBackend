package application.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import application.auxiliar.Semana;

@Entity
public class Actividad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String nombre;
	
	private String desc;
	
	private String precio;
	
	private String	promRating;
	
	private String bajaLogica;
	
	@Column(columnDefinition = "ENUM('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES','SABADO','DOMINGO')")
    @Enumerated(EnumType.STRING)
	private Semana diasSemana;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private Time horaInicio;
	
	private Time horaFin;
	
	private String direccion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="disciplinaID")
	private Disciplina disciplina;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "PersonaActividad", 
			  joinColumns = @JoinColumn(name = "actividadID"), 
			  inverseJoinColumns = @JoinColumn(name = "personaID"))
	private List<Persona> personas = new ArrayList<>();
	
	public Actividad() {
		
	}

	public Actividad(String precio, String promRating, String bajaLogica, Semana diasSemana, Date fechaInicio,
			Date fechaFin, Time horaInicio, Time horaFin, String direccion, Disciplina disciplina) {
		super();
		this.precio = precio;
		this.promRating = promRating;
		this.bajaLogica = bajaLogica;
		this.diasSemana = diasSemana;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.direccion = direccion;
		this.disciplina = disciplina;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getPromRating() {
		return promRating;
	}

	public void setPromRating(String promRating) {
		this.promRating = promRating;
	}

	public String getBajaLogica() {
		return bajaLogica;
	}

	public void setBajaLogica(String bajaLogica) {
		this.bajaLogica = bajaLogica;
	}

	public Semana getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(Semana diasSemana) {
		this.diasSemana = diasSemana;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	

//	public List<Persona> getPersonas() {
//		return personas;
//	}

	@Override
	public String toString() {
		return "Actividad [ID=" + ID + ", nombre=" + nombre + ", desc=" + desc + ", precio=" + precio + ", promRating="
				+ promRating + ", bajaLogica=" + bajaLogica + ", diasSemana=" + diasSemana + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin
				+ ", direccion=" + direccion;
	}
	
	
}


//`ID` INT NOT NULL,
//`precio` VARCHAR(45) NOT NULL,
//`promRating` VARCHAR(45) NULL,
//`bajaLogica` VARCHAR(45) NULL,
//`diasSemana` ENUM('lunes', 'martes', 'miercoles', 'jueves', 'viernes', 'sabado', 'domingo') NULL,
//`fechaInicio` DATE NOT NULL,
//`fechaFin` DATE NULL,
//`horaInicio` TIME NOT NULL,
//`horaFin` TIME NOT NULL,
//`direccion` VARCHAR(45) NOT NULL,
//`disciplinaID` INT NOT NULL,