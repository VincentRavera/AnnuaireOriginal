package fr.treeptik.dao.impl.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.treeptik.dao.AbstractDAO;
import fr.treeptik.dao.NumeroDAOSQL;
import fr.treeptik.dao.exeception.DAOException;
import fr.treeptik.pojosample.sql.Numero;
import fr.treeptik.pojosample.sql.Personne;

public class NumeroJDBC extends AbstractDAO implements NumeroDAOSQL{

	Connection connexion = JDBCutils.getConnection();
	@Override
	public Numero add(Numero entity) throws DAOException {
		try {
		PreparedStatement statement = connexion.prepareStatement(
				"INSERT INTO Numero (tel, type)"
				+"VALUES(?, ?)",
				Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1, entity.getTel());
		statement.setString(2, entity.getType());
		statement.executeUpdate();
		
		ResultSet keys = statement.getGeneratedKeys();
		keys.next();
		entity.setId(keys.getInt(1));
		
		return entity;
		
	} catch (SQLException e) {
		throw new DAOException("Erreur NumeroDAOSQL add() "
				+e.getMessage(), e);
	}
		
	}

	@Override
	public void remove(Numero entity) throws DAOException {
		PreparedStatement prepStatement;
		try {
			prepStatement = connexion.prepareStatement(
					"DELETE FROM Numero n WHERE n.id=?");
			prepStatement.setInt(1, entity.getId());
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Erreur NumeroDAOSQL remove() "
					+ e.getMessage(), e);
		}
	}

	@Override
	public void removeById(Integer key) throws DAOException {
		PreparedStatement prepStatement;
		try {
			prepStatement = connexion.prepareStatement(
					"DELETE FROM Numero n WHERE n.id=?");
			prepStatement.setInt(1, key);
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Erreur PersonneDAOSQL removeById() "
					+ e.getMessage(), e);
		}
		
	}

	@Override
	public List<Numero> findAll() throws DAOException {
		try {
			PreparedStatement prepStatement = connexion.prepareStatement(
					"SELECT * FROM Numero n");
			prepStatement.executeQuery();
			
			ResultSet resultSet = prepStatement.getResultSet();
			List<Numero> numeros = new ArrayList<Numero>();
			
			while (resultSet.next()) {
				Numero numero = new Numero(
						resultSet.getInt("id"),
						resultSet.getString("tel"),
						resultSet.getString("type"));
				numeros.add(numero);
				
			}
			return numeros;
			
		} catch (SQLException e) {
			throw new DAOException("Erreur PersonneDAOSQL findAll() "
					+ e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> getNumeroOf(String name) {
		try {
			PreparedStatement prepStatement = connexion.prepareStatement(
					"SELECT * FROM Numero n"
					+ "INNER JOIN Possede po"
					+ "ON n.id=po.idNumero"
					+ "INNER JOIN Personne pe"
					+ "on pe.id=po.idPersonne"
					+ "WHERE pe.name=?");
			prepStatement.setString(1, name);
			prepStatement.executeQuery();
			
			ResultSet resultSet = prepStatement.getResultSet();
			List<Numero> numeros = new ArrayList<Numero>();
			
			while (resultSet.next()) {
				Numero numero = new Numero(
						resultSet.getInt("id"),
						resultSet.getString("tel"),
						resultSet.getString("type"));
				numeros.add(numero);
				
			}
			return numeros;
			
		} catch (SQLException e) {
			throw new DAOException("Erreur PersonneDAOSQL findAll() "
					+ e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> getNumeroOf(Personne entity) {
		try {
			PreparedStatement prepStatement = connexion.prepareStatement(
					"SELECT * FROM Numero n"
					+ "INNER JOIN Possede po"
					+ "ON n.id=po.idNumero"
					+ "INNER JOIN Personne pe"
					+ "on pe.id=po.idPersonne"
					+ "WHERE pe.id=?");
			prepStatement.setInt(1, entity.getId());
			prepStatement.executeQuery();
			
			ResultSet resultSet = prepStatement.getResultSet();
			List<Numero> numeros = new ArrayList<Numero>();
			
			while (resultSet.next()) {
				Numero numero = new Numero(
						resultSet.getInt("id"),
						resultSet.getString("tel"),
						resultSet.getString("type"));
				numeros.add(numero);
				
			}
			return numeros;
			
		} catch (SQLException e) {
			throw new DAOException("Erreur PersonneDAOSQL findAll() "
					+ e.getMessage(), e);
		}
		
	}

}
