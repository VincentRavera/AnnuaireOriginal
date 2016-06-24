package fr.treeptik.pojosample.sql;

import java.io.Serializable;

public class Possede implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idPersonne;
	private Integer idNumero;
	
	
	
	public Possede() {
	}
	public Possede(Integer idPersonne, Integer idNumero) {
		this.idPersonne = idPersonne;
		this.idNumero = idNumero;
	}
	public Integer getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}
	public Integer getIdNumero() {
		return idNumero;
	}
	public void setIdNumero(Integer idNumero) {
		this.idNumero = idNumero;
	}
	
	

}
