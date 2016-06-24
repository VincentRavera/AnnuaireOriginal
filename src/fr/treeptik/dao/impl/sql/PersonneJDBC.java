package fr.treeptik.dao.impl.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.treeptik.pojosample.sql.Numero;
import fr.treeptik.pojosample.sql.Personne;
import fr.treeptik.dao.AbstractDAO;
import fr.treeptik.dao.PersonneDAOSQL;
import fr.treeptik.dao.exeception.DAOException;

public class PersonneJDBC extends AbstractDAO implements PersonneDAOSQL{
	
	Connection connexion = JDBCutils.getConnection();
	@Override
	public Personne add(Personne entity) throws DAOException {
		try {
			PreparedStatement prepStatement = connexion.prepareStatement(
					"INSERT INTO Personne (nom, prenom, dateNaissance)"
					+ "?, ?, ?", Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, entity.getNom());
			prepStatement.setString(2, entity.getPrenom());
			if (entity.getDateNaissance()!=null) {
				prepStatement.setDate(3, new Date(
						entity.getDateNaissance().getTime()));
			}
			else {
				prepStatement.setDate(3, null);
			}
			prepStatement.executeUpdate();
			ResultSet key = prepStatement.getGeneratedKeys();
			key.next();
			entity.setId(key.getInt(1));
			
			return entity;
		} catch (SQLException e) {
			throw new DAOException("Erreur PersonneDAOSQL add() "
					+e.getMessage(), e);
		}
	}

	@Override
	public void remove(Personne entity) throws DAOException {
		PreparedStatement prepStatement;
		try {
			prepStatement = connexion.prepareStatement(
					"DELETE FROM Personne p WHERE p.id=?");
			prepStatement.setInt(1, entity.getId());
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Erreur PersonneDAOSQL remove() "
					+ e.getMessage(), e);
		}
		
	}

	@Override
	public void removeById(Integer key) throws DAOException {
		PreparedStatement prepStatement;
		try {
			prepStatement = connexion.prepareStatement(
					"DELETE FROM Personne p WHERE p.id=?");
			prepStatement.setInt(1, key);
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Erreur PersonneDAOSQL removeById() "
					+ e.getMessage(), e);
		}
		
	}

	@Override
	public List<Personne> findAll() throws DAOException {
		try {
			PreparedStatement prepStatement = connexion.prepareStatement(
					"SELECT * FROM Personne p");
			prepStatement.executeQuery();
			
			ResultSet resultSet = prepStatement.getResultSet();
			List<Personne> personnes = new ArrayList<Personne>();
			
			while (resultSet.next()) {
				PreparedStatement prep2 = connexion.prepareStatement(
						"SELECT tel, type FROM Numero n"
						+ "INNER JOIN Possede po"
						+ "ON po.idNumero=n.id"
						+ "INNER JOIN Personne pe"
						+ "ON pe.id=po.idPersonne"
						+ "WHERE pe.id=?");
				prep2.setInt(1, resultSet.getInt("id"));
				prep2.executeQuery();
				ResultSet numeroSet = prep2.getResultSet();
				List<Numero> nums = new ArrayList<Numero>();
				while (numeroSet.next()) {
					Numero num = new Numero(
							numeroSet.getInt("id"),
							numeroSet.getString("tel"),
							numeroSet.getString("type"));
					nums.add(num);
				}
				Personne personne = new Personne(
						resultSet.getInt("id"),
						resultSet.getString("nom"),
						resultSet.getString("prenom"),
						resultSet.getDate("Date"),
						nums);
				personnes.add(personne);
				
			}
			return personnes;
			
		} catch (SQLException e) {
			throw new DAOException("Erreur PersonneDAOSQL findAll() "
					+ e.getMessage(), e);
		}
	}

}
