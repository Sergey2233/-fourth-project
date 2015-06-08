package data.info.dao.realizationdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import data.info.connectionjdbc.JDBCConnection;
import data.info.dao.interfacedao.ClientDao;
import data.info.entity.Client;

/**
 * access of table client
 * 
 * @author Sergey
 *
 */
public class ClienRealizationDao implements ClientDao {
	private static final Logger logger1 = Logger
			.getLogger(ClienRealizationDao.class);

	/**
	 * connection jdbc
	 */
	private JDBCConnection conn;

	/*
	 * initialization connection with data base
	 * 
	 * @param conn
	 */

	public ClienRealizationDao(JDBCConnection conn) {
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
	public void createClientReg(Client user) {
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(
						"INSERT INTO clients (first_name,second_name,id_login) "
								+ " VALUES( ? , ? , ? )",
						Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, user.getFirstName());
				statement.setString(2, user.getSecondName());
				statement.setInt(3, user.getIdLogin());
				statement.executeUpdate();
				ResultSet key = statement.getGeneratedKeys();
				int itemId = 0;
				if (key.next()) {
					itemId = key.getInt(1);
					user.setIdClient(itemId);
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
	public void create(Client user) {
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement(
								"INSERT INTO clients (first_name,second_name,"
										+ "birthday,series_number_pas,id_login,post,telephone)"
										+ " VALUES( ? , ? , ? ,? , ?, ?,?)",
								Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, user.getFirstName());
				statement.setString(2, user.getSecondName());
				statement.setDate(3, getDate(user.getBirthday()));
				statement.setString(4, user.getSeriesNumberPas());
				statement.setInt(5, user.getIdLogin());
				statement.setString(6, user.getPost());
				statement.setString(7, user.getTelephone());
				statement.executeUpdate();
				ResultSet key = statement.getGeneratedKeys();
				int itemId = 0;
				if (key.next()) {
					itemId = key.getInt(1);
					user.setIdClient(itemId);
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
	public Client find(int id) {
		Connection con = conn.getConnection();
		Client client = new Client();
		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement("SELECT * FROM clients where id = ?");
				statement.setInt(1, id);
				ResultSet result2 = statement.executeQuery();
				while (result2.next()) {
					client.setIdClient(result2.getInt("id_client"));
					client.setFirstName(result2.getString("first_name"));
					client.setSecondName(result2.getString("second_name"));
					client.setBirthday(getLocalDate(result2.getDate("birthday")));
					client.setSeriesNumberPas(result2
							.getString("series_number_pas"));
					client.setIdLogin(result2.getInt("id_login"));
					client.setPost(result2.getString("post"));
					client.setTelephone(result2.getString("telephone"));
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

		return client;
	}

	@Override
	public List<Client> findAll() {
		Connection con = conn.getConnection();
		ArrayList<Client> clientAll = new ArrayList<Client>();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement("SELECT * FROM clients ");
				ResultSet result2 = statement.executeQuery();

				while (result2.next()) {
					Client client = new Client();
					client.setIdClient(result2.getInt("id_client"));
					client.setFirstName(result2.getString("first_name"));
					client.setSecondName(result2.getString("second_name"));
					client.setBirthday(getLocalDate(result2.getDate("birthday")));
					client.setSeriesNumberPas(result2
							.getString("series_number_pas"));
					client.setIdLogin(result2.getInt("id_login"));
					client.setPost(result2.getString("post"));
					client.setTelephone(result2.getString("telephone"));
					clientAll.add(client);

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

		return clientAll;

	}

	@Override
	public void update(Client user) {
		String updateTableSQL = "UPDATE clients SET  first_name = ?,"
				+ "second_name = ?,birthday = ?,series_number_pas = ?,id_login = ?,"
				+ "post = ?, telephone = ? WHERE id_client = ?";
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(updateTableSQL);
				statement.setString(1, user.getFirstName());
				statement.setString(2, user.getSecondName());
				statement.setDate(3, getDate(user.getBirthday()));
				statement.setString(4, user.getSeriesNumberPas());
				statement.setInt(5, user.getIdLogin());
				statement.setString(6, user.getPost());
				statement.setString(7, user.getTelephone());
				statement.setInt(8, user.getIdClient());
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
		String deleteSQL = "DELETE FROM clients WHERE id_client = ?";
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

	/**
	 * Translate LoDate in java.sql.Date
	 * 
	 * @param localDate
	 *            LocalDate
	 * @return
	 */
	private static java.sql.Date getDate(LocalDate localDate) {

		return new java.sql.Date(localDate.toEpochDay());
	}

	/**
	 * Translate java.sql.Date in LocalDate
	 * 
	 * @param java
	 *            .sql.Date
	 * @return
	 */
	private static LocalDate getLocalDate(java.sql.Date date) {
		LocalDate localdate = date.toLocalDate();
		return localdate;
	}

	@Override
	public void delete(Client client) {
		String deleteSQL = "DELETE FROM clients WHERE first_name = ? AND second_nmae = ?";
		Connection con = conn.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			try {
				preparedStatement = con.prepareStatement(deleteSQL);
				preparedStatement.setString(1, client.getFirstName());
				preparedStatement.setString(2, client.getSecondName());
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
