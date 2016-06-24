//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.05.04 à 05:04:27 PM CEST 
//


package fr.treeptik.pojosample.sql;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Personne implements Serializable{

	private static final long serialVersionUID = 1L;
	protected int id;
    protected String nom;
    protected String prenom;
    protected Date dateNaissance;
    protected List<Numero> numero;

    public Personne() {
    }
    
    public Personne(String nom, String prenom, Date dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	public Personne(int id, String nom, String prenom, Date dateNaissance) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	public Personne(int id, String nom, String prenom, Date dateNaissance, List<Numero> numero) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.numero = numero;
	}
	public int getId() {
        return id;
    }
    public void setId(int value) {
        this.id = value;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String value) {
        this.nom = value;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String value) {
        this.prenom = value;
    }
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date value) {
        this.dateNaissance = value;
    }
    public List<Numero> getNumero() {
        if (numero == null) {
            numero = new ArrayList<Numero>();
        }
        return this.numero;
    }

}
