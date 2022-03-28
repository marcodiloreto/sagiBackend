package application.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;

@Entity
@Data
@NoArgsConstructor
public class Persona implements Serializable {

	private static final long serialVersionUID = 6363777413501451503L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	private String nombre;

	private String rol;

	private String fotoURL;

	private double promRating;
	
	private Boolean bajaLogica;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Creadores", joinColumns = @JoinColumn(name = "personaID"), inverseJoinColumns = @JoinColumn(name = "actividadID"))
	private List<Actividad> creadas = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Interesados", joinColumns = @JoinColumn(name = "personaID"), inverseJoinColumns = @JoinColumn(name = "actividadID"))
	private List<Actividad> Interes = new ArrayList<>();


	public Persona(long ID) {
		this.ID = ID;
	}

}