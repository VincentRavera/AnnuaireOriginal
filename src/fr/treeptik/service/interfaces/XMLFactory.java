package fr.treeptik.service.interfaces;

import fr.treeptik.dao.AbstractDAO;
import fr.treeptik.dao.impl.xsd.AnnuaireXSD;
import fr.treeptik.dao.impl.xsd.NumeroXSD;
import fr.treeptik.dao.impl.xsd.PersonneXSD;

public class XMLFactory extends AbstractDAOFactory {

	@Override
	public AbstractDAO getPersonne() {
		return new PersonneXSD();
	}

	@Override
	public AbstractDAO getNumero() {
		return new NumeroXSD();
	}
	
	public AbstractDAO getAnnuaire(){
		return new AnnuaireXSD();
	}

}
