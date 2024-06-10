package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the entrenadores database table.
 * 
 */
@Entity
@Table(name="entrenadores")
@NamedQuery(name="Entrenadore.findAll", query="SELECT e FROM Entrenadore e")
public class Entrenadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "apellido")
	private String apellido;


	@Column(name = "edad")
	private int edad;

	@Column(name = "nacionalidad")
	private String nacionalidad;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy="entrenador")
	private List<Clube> clubes;
	
	public Entrenadore() {
	}
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Clube> getClubes() {
		return this.clubes;
	}
	
	public void setClubes(List<Clube> clubes) {
		this.clubes = clubes;
	}
	

	public Clube addClube(Clube clube) {
		getClubes().add(clube);
		clube.setEntrenador(this);
		return clube;
	}
	
	public Clube removeClube(Clube clube) {
		getClubes().add(clube);
		clube.setEntrenador(null);
		return clube;
	}

}