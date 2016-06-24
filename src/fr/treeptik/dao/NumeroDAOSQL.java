package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.pojosample.sql.Numero;
import fr.treeptik.pojosample.sql.Personne;

public interface NumeroDAOSQL extends GenericDAO<Numero, Integer>{
	public List<Numero> getNumeroOf(String name);
	public List<Numero> getNumeroOf(Personne entity);

}
