package fr.treeptik.dao.impl.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.treeptik.dao.AbstractDAO;
import fr.treeptik.dao.PossedeDAOSQL;
import fr.treeptik.dao.exeception.DAOException;
import fr.treeptik.pojosample.sql.Possede;

public class PossedeJDBC extends AbstractDAO implements PossedeDAOSQL{
	
	Connection connexion = JDBCutils.getConnection();

	@Override
	public Possede add(Possede entity) throws DAOException {
		try {
			PreparedStatement statement = connexion.prepareStatement(
					"INSERT INTO Numero (idPersonne, idNumero)"
					+"VALUES(?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, entity.getIdPersonne());
			statement.setInt(2, entity.getIdNumero());
			statement.executeUpdate();
			
			
			return entity;
			
		} catch (SQLException e) {
			throw new DAOException("Erreur PossedeDAOSQL add() "
					+e.getMessage(), e);
		}
			
	}

	@Override
	public void remove(Possede entity) throws DAOException {
		PreparedStatement prepStatement;
		try {
			prepStatement = connexion.prepareStatement(
					"DELETE FROM Possede p WHERE p.idNumero=?");
			prepStatement.setInt(1, entity.getIdNumero());
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Erreur PossedeDAOSQL remove() "
					+ e.getMessage(), e);
		}
	}

	@Override
	public void removeById(Integer key) throws DAOException {
		PreparedStatement prepStatement;
		try {
			prepStatement = connexion.prepareStatement(
					"DELETE FROM Possede p WHERE p.idPersonne=?");
			prepStatement.setInt(1, key);
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Erreur PossedeDAOSQL removeById() "
					+ e.getMessage(), e);
		}
	}

	@Override
	public List<Possede> findAll() throws DAOException {
		try {
			PreparedStatement prepStatement = connexion.prepareStatement(
					"SELECT * FROM Possede p");
			prepStatement.executeQuery();
			
			ResultSet resultSet = prepStatement.getResultSet();
			List<Possede> possedes = new ArrayList<Possede>();
			
			while (resultSet.next()) {
				Possede possede = new Possede(
						resultSet.getInt("idPersonne"),
						resultSet.getInt("idNumero"));
				possedes.add(possede);
				
			}
			return possedes;
			
		} catch (SQLException e) {
			throw new DAOException("Erreur PossedeDAOSQL findAll() "
					+ e.getMessage(), e);
		}
	}


}
