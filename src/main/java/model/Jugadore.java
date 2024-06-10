package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jugadores database table.
 * 
 */
@Entity
@Table(name="jugadores")
@NamedQuery(name="Jugadore.findAll", query="SELECT j FROM Jugadore j")
public class Jugadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String apellido;

	private String nombre;

	private int numero;

	public Jugadore() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}