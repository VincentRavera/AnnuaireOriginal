package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.dao.exeception.DAOException;

public interface GenericDAO<T, K> {
	T add (T entity) throws DAOException;
	void remove(T entity) throws DAOException;
	void removeById(K key) throws DAOException;
	List<T> findAll() throws DAOException;
	
	

}
