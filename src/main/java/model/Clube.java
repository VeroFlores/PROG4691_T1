package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clubes database table.
 * 
 */
@Entity
@Table(name="clubes")
@NamedQuery(name="Clube.findAll", query="SELECT c FROM Clube c")
public class Clube implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String nombre;
	
	//bidirectional
	@ManyToOne
	@JoinColumn(name="entrenadores_id")
	private Entrenadore entrenador;

	//bidirectional
	@ManyToOne
	@JoinColumn(name="jugadores_id")
	private Jugadore jugador;

	public Clube() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Entrenadore getEntrenador() {
		return this.entrenador;
	}
	

	public void setEntrenador(Entrenadore entrenador) {
		this.entrenador = entrenador;
	}

	public Jugadore getJugadore() {
		return this.jugador;
	}

	public void setJugadore(Jugadore jugador) {
		this.jugador = jugador;
	}
	



}