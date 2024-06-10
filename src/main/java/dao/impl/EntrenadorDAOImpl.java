package dao.impl;

import java.util.List;

import model.Entrenadore;

public class EntrenadorDAOImpl extends CommonDAOImpl<Entrenadore>{
	
	public void guardar (Entrenadore entrenador) {
		super.guardar(entrenador);
	}
	
	public List <Entrenadore> consultar() {
		return super.consultar();
	}
	
	public Entrenadore consultarPorId() {
		return super.consultarPorId(0);
	}
}
