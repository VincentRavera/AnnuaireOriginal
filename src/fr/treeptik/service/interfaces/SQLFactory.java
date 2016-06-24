package fr.treeptik.service.interfaces;

import fr.treeptik.dao.AbstractDAO;
import fr.treeptik.dao.impl.sql.NumeroJDBC;
import fr.treeptik.dao.impl.sql.PersonneJDBC;
import fr.treeptik.dao.impl.sql.PossedeJDBC;

public class SQLFactory extends AbstractDAOFactory {

	@Override
	public AbstractDAO getPersonne() {
		return new PersonneJDBC();
	}

	@Override
	public AbstractDAO getNumero() {
		return new NumeroJDBC();
	}
	public AbstractDAO getPossede() {
		return new PossedeJDBC();
		
	}

}
