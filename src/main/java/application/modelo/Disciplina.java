package application.modelo;

import java.io.Serializable;
import java.util.List;

import application.auxiliar.Rareza;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Disciplina implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	private String nombre;
	
	private String desc;
	
	@Column(columnDefinition = "ENUM('PORAHORANADA')")
    @Enumerated(EnumType.STRING)
	private Rareza rareza;
	
	private String fotoURL;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="disciplina")
	private List<Actividad> actividades;
	
	public Disciplina(String nombre, String desc, Rareza rareza, String fotoURL) {
		this.nombre = nombre;
		this.desc = desc;
		this.rareza = rareza;
		this.fotoURL = fotoURL;
	}
	
	

	public Disciplina(String nombre, String desc) {
		this.nombre = nombre;
		this.desc = desc;
	}
	
	public Disciplina() {
		
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Rareza getRareza() {
		return rareza;
	}

	public void setRareza(Rareza rareza) {
		this.rareza = rareza;
	}

	public String getFotoURL() {
		return fotoURL;
	}

	public void setFotoURL(String fotoURL) {
		this.fotoURL = fotoURL;
	}

	@Override
	public String toString() {
		return "Disciplina [ID=" + ID + ", nombre=" + nombre + ", desc=" + desc + ", rareza=" + rareza + ", fotoURL="
				+ fotoURL + "]";
	}
	
}

//`ID` INT NOT NULL,
//`nombre` VARCHAR(45) NOT NULL,
//`desc` VARCHAR(45) NOT NULL,
//`rareza` ENUM('por ahora nada') NULL,
//`fotoURL` VARCHAR(45) NOT NULL,