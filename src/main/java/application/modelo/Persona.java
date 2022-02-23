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
import javax.persistence.JoinColumn;

@Entity
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	private String nombre;

	private String rol;

	private String fotoURL;

	private double promRating;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "PersonaActividad", joinColumns = @JoinColumn(name = "personaID"), inverseJoinColumns = @JoinColumn(name = "actividadID"))
	private List<Actividad> actividades = new ArrayList<>();

	public Persona() {
	}

	public Persona(long ID) {
		this.ID = ID;
	}

	public Persona(String nombre, String rol, String fotoURL, double promRating) {
		this.nombre = nombre;
		this.rol = rol;
		this.fotoURL = fotoURL;
		this.promRating = promRating;
	}

	public long getIdPersona() {
		return ID;
	}

	public void setIdPersona(long ID) {
		this.ID = ID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getFotoURL() {
		return fotoURL;
	}

	public void setFotoURL(String fotoURL) {
		this.fotoURL = fotoURL;
	}

	public double getPromRating() {
		return promRating;
	}

	public void setPromRating(double promRating) {
		this.promRating = promRating;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	@Override
	public String toString() {
		return "Persona [ID=" + ID + ", nombre=" + nombre + ", rol=" + rol + ", fotoURL=" + fotoURL + ", promRating="
				+ promRating + "]";
	}

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((apeMaterno == null) ? 0 : apeMaterno.hashCode());
	 * result = prime * result + ((apePaterno == null) ? 0 : apePaterno.hashCode());
	 * result = prime * result + ((email == null) ? 0 : email.hashCode()); result =
	 * prime * result + (int) (ID ^ (ID >>> 32)); result = prime * result + ((nombre
	 * == null) ? 0 : nombre.hashCode()); return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) { return true;
	 * } if (obj == null) { return false; } if (getClass() != obj.getClass()) {
	 * return false; } Persona other = (Persona) obj; if (apeMaterno == null) { if
	 * (other.apeMaterno != null) { return false; } } else if
	 * (!apeMaterno.equals(other.apeMaterno)) { return false; } if (apePaterno ==
	 * null) { if (other.apePaterno != null) { return false; } } else if
	 * (!apePaterno.equals(other.apePaterno)) { return false; } if (email == null) {
	 * if (other.email != null) { return false; } } else if
	 * (!email.equals(other.email)) { return false; } if (ID != other.ID) { return
	 * false; } if (nombre == null) { if (other.nombre != null) { return false; } }
	 * else if (!nombre.equals(other.nombre)) { return false; } return true; }
	 */
}