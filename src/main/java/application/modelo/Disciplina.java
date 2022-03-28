package application.modelo;

import java.io.Serializable;
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
import javax.persistence.OneToMany;

import application.modelo.auxiliar.Rareza;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Disciplina implements Serializable{

	private static final long serialVersionUID = 3202089571512147315L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	private String nombre;
	
	private String descripcion;
	
	@Column(columnDefinition = "ENUM('PORAHORANADA')")
    @Enumerated(EnumType.STRING)
	private Rareza rareza;
	
	private String fotoURL;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="disciplina")
	private List<Actividad> actividades;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "DisciplinaHija", 
			  joinColumns = @JoinColumn(name = "disciplinaID"), 
			  inverseJoinColumns = @JoinColumn(name = "hijaID"))
	private List<Disciplina> disciplinasHijas = new ArrayList<>();
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "DisciplinaMadre", 
			  joinColumns = @JoinColumn(name = "disciplinaID"), 
			  inverseJoinColumns = @JoinColumn(name = "madreID"))
	private List<Disciplina> disciplinasMadre = new ArrayList<>();
}
