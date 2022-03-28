package application.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Actividad implements Serializable{

	private static final long serialVersionUID = 6363777413501451504L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	private String nombre;
	
	private String descripcion;
	
	private String precio;
	
	private String	promRating;
	
	private Boolean bajaLogica;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "actividad", cascade={CascadeType.ALL})
	private List<Plan> planes = new ArrayList<>();
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechaInicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechaFin;
	
	private String direccion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="disciplinaID")
	private Disciplina disciplina;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "Interesados", 
			  joinColumns = @JoinColumn(name = "actividadID"), 
			  inverseJoinColumns = @JoinColumn(name = "personaID"))
	private List<Persona> interesados = new ArrayList<>();
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "Creadores", 
			  joinColumns = @JoinColumn(name = "actividadID"), 
			  inverseJoinColumns = @JoinColumn(name = "personaID"))
	private List<Persona> creadores = new ArrayList<>();
	
	private int maxCupos;
	
	private Double latitud;
	
	private Double longitud;
	
	public void creadoresAdd(Persona p) {
		this.creadores.add(p);
	}

	@JsonCreator
	public Actividad(@JsonProperty("ID")Long ID) {
		super();
		this.ID = ID;
	}
	
	
}
