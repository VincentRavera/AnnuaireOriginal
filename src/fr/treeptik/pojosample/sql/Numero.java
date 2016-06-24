//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.04 à 05:04:27 PM CEST 
//


package fr.treeptik.pojosample.sql;

import java.io.Serializable;

public class Numero implements Serializable{

	private static final long serialVersionUID = 1L;
	protected Integer id;

	protected String tel;
    protected String type;
    
    

    public Numero() {
	}
    

	public Numero(Integer id, String tel, String type) {
		this.id = id;
		this.tel = tel;
		this.type = type;
	}


	public Numero(String tel, String type) {
		this.tel = tel;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTel() {
        return tel;
    }

    public void setTel(String value) {
        this.tel = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

}
