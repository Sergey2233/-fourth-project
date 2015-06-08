package data.info.dao.realizationdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import data.info.connectionjdbc.JDBCConnection;
import data.info.dao.interfacedao.LoginDao;
import data.info.entity.Login;

/**
 * access date table login
 * 
 * @author Sergey
 *
 */
public class LoginRealizationDao implements LoginDao {
	private static final Logger logger1 = Logger
			.getLogger(LoginRealizationDao.class);

	/**
	 * connection jdbc
	 */
	private JDBCConnection conn;

	/*
	 * initialization connection with data base
	 * 
	 * @param conn
	 */

	public LoginRealizationDao(JDBCConnection conn) {
		this.conn = conn;

	}

	/**
	 * 
	 * @return JDBCConnection
	 */
	public JDBCConnection getJDBCConnection() {
		return conn;
	}

	/**
	 * set new JDBCConnection
	 * 
	 * @param conn
	 */

	public void setConn(JDBCConnection conn) {
		this.conn = conn;
	}

	@Override
	public void create(Login login) {
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(
						"INSERT INTO login (login,password) "
								+ " VALUES( ? , ? )",
						Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, login.getLogin());
				statement.setString(2, login.getPassword());
				statement.executeUpdate();
				ResultSet key = statement.getGeneratedKeys();
				int itemId = 0;
				if (key.next()) {
					itemId = key.getInt(1);
					login.setIdLogin(itemId);
				}
			} finally {
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			}

		} catch (Exception ex) {
			logger1.error(ex);
		}

	}

	@Override
	public Login find(int id) {
		Connection con = conn.getConnection();
		Login login = new Login();

		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement("SELECT * FROM login where id = ?");
				statement.setInt(1, id);
				ResultSet result2 = statement.executeQuery();
				while (result2.next()) {
					login.setIdLogin(result2.getInt("id"));
					login.setLogin(result2.getString("login"));
					login.setPassword(result2.getString("password"));
				}
			} finally {
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			}

		} catch (Exception ex) {
			logger1.error(ex);
		}

		return login;
	}

	@Override
	public List<Login> findAll() {

		logger1.info("connection" + conn.getConnection() != null);

		Connection con = conn.getConnection();

		ArrayList<Login> loginAll = new ArrayList<Login>();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement("SELECT * FROM login");
				ResultSet result2 = statement.executeQuery();

				while (result2.next()) {
					Login login = new Login();
					login.setIdLogin(result2.getInt("id"));
					login.setLogin(result2.getString("login"));
					login.setPassword(result2.getString("password"));
					loginAll.add(login);

				}
			} finally {
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			}

		} catch (Exception ex) {
			logger1.error(ex);
		}

		return loginAll;

	}

	@Override
	public void update(Login login) {
		String updateTableSQL = "UPDATE clients SET  login = ?, password = ?"
				+ " WHERE id = ?";
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(updateTableSQL);
				statement.setString(1, login.getLogin());
				statement.setString(2, login.getPassword());
				statement.setInt(3, login.getIdLogin());
				statement.executeUpdate();
			} finally {
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			}

		} catch (Exception ex) {
			logger1.error(ex);
		}

	}

	@Override
	public void delete(int id) {
		String deleteSQL = "DELETE FROM login WHERE id_client = ?";
		Connection con = conn.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			try {
				preparedStatement = con.prepareStatement(deleteSQL);
				preparedStatement.setInt(1, id);
				// execute delete SQL statement
				preparedStatement.executeUpdate();
			} finally {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (con != null) {
					con.close();
				}
			}
		} catch (SQLException e) {

			logger1.error(e);
		}

	}

}
