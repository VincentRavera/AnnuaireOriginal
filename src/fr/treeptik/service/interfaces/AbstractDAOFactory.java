package fr.treeptik.service.interfaces;

import fr.treeptik.dao.AbstractDAO;

public abstract class AbstractDAOFactory {
	public abstract AbstractDAO getPersonne();
	public abstract AbstractDAO getNumero();
	
	public static AbstractDAOFactory getFactory(FactoryType type){
		if (type.equals(FactoryType.SQL))
			return new SQLFactory();
		if (type.equals(FactoryType.XML))
			return new XMLFactory();
		/*if (type.equals(FactoryType.DAO))
			return new DAOfactory();*/
			
		return null;
	}

}
