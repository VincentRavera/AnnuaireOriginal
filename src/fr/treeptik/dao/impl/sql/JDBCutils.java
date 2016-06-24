package fr.treeptik.dao.impl.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.treeptik.dao.exeception.DAOException;

public class JDBCutils {
	private static Connection connex;
	public static Connection getConnection() throws DAOException{
		try {
			if (connex==null || connex.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				connex = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/annuaire",
						"root", "ic06");
				connex.setAutoCommit(false);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DAOException("Erreur JDBCutils getConnection"
					+e.getMessage(), e);
		}
		return connex;
		
	}
	public static void comit() throws DAOException{
		try {
			connex.commit();
		} catch (SQLException e) {
			throw new DAOException("ERREUR JDBCutils commit"
		+e.getMessage(), e);
		}
	}

}
