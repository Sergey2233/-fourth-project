package data.info.dao.realizationdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import data.info.connectionjdbc.JDBCConnection;
import data.info.dao.interfacedao.PersonnelDao;
import data.info.entity.Personnel;

/**
 * access date table Personnel
 * 
 * @author Sergey
 *
 */
public class PersonnelRealizationDao implements PersonnelDao {
	private static final Logger logger1 = Logger
			.getLogger(PersonnelRealizationDao.class);

	/**
	 * connection jdbc
	 */
	private JDBCConnection conn;

	/*
	 * initialization connection with data base
	 * 
	 * @param conn
	 */

	public PersonnelRealizationDao(JDBCConnection conn) {
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
	public void create(Personnel personnel) {
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement(
								"INSERT INTO personel (first_name,second_name,"
										+ "birthday,series_number_pas,id_login,post,start_work,end_work,address) "
										+ " VALUES(?,?,?,?,?,?,?,?,?)",
								Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, personnel.getFirstName());
				statement.setString(2, personnel.getSecondName());
				statement.setDate(3, getDate(personnel.getBirthday()));
				statement.setString(4, personnel.getSeriesNumberPas());
				statement.setInt(5, personnel.getIdLogin());
				statement.setString(6, personnel.getPost());
				statement.setDate(7, getDate(personnel.getStartWork()));
				statement.setDate(8, getDate(personnel.getEndWork()));
				statement.setString(9, personnel.getAddress());
				statement.executeUpdate();
				ResultSet key = statement.getGeneratedKeys();
				int itemId = 0;
				if (key.next()) {
					itemId = key.getInt(1);
					personnel.setIdClient(itemId);
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
	public Personnel find(int id) {
		Connection con = conn.getConnection();
		Personnel personnel = new Personnel();
		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement("SELECT * FROM personnel where id = ?");
				statement.setInt(1, id);
				ResultSet result2 = statement.executeQuery();
				statement.executeUpdate();
				while (result2.next()) {

					personnel.setIdClient(result2.getInt("id_personnel"));
					personnel.setFirstName(result2.getString("first_name"));
					personnel.setSecondName(result2.getString("second_name"));
					personnel.setBirthday(getLocalDate(result2
							.getDate("birthday")));
					personnel.setSeriesNumberPas(result2
							.getString("series_number_pas"));
					personnel.setIdLogin(result2.getInt("id_login"));
					personnel.setPost(result2.getString("post"));
					personnel.setStartWork(getLocalDate(result2
							.getDate("start_work")));
					personnel.setEndWork(getLocalDate(result2
							.getDate("end_work")));
					personnel.setAddress(result2.getString("address"));
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

		return personnel;
	}

	@Override
	public List<Personnel> findAll() {
		Connection con = conn.getConnection();
		ArrayList<Personnel> personnelAll = new ArrayList<Personnel>();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement("SELECT * FROM personnel ");
				ResultSet result2 = statement.executeQuery();

				while (result2.next()) {
					Personnel personnel = new Personnel();

					personnel.setIdClient(result2.getInt("id_personnel"));
					personnel.setFirstName(result2.getString("first_name"));
					personnel.setSecondName(result2.getString("second_name"));
					personnel.setBirthday(getLocalDate(result2
							.getDate("birthday")));
					personnel.setSeriesNumberPas(result2
							.getString("series_number_pas"));
					personnel.setIdLogin(result2.getInt("id_login"));
					personnel.setPost(result2.getString("post"));
					personnel.setStartWork(getLocalDate(result2
							.getDate("start_work")));
					// personnel.setEndWork(getLocalDate(result2.getDate("end_work")));
					personnel.setAddress(result2.getString("address"));
					personnelAll.add(personnel);
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

		return personnelAll;
	}

	@Override
	public void update(Personnel personnel) {
		String updateTableSQL = "UPDATE personnel SET  first_name = ?,"
				+ "second_name = ?,birthday = ?,series_number_pas = ?,id_login = ?,post = ? ,start_work =?,end_work=?,address=?"
				+ " WHERE id_client = ?";
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(updateTableSQL);
				statement.setString(1, personnel.getFirstName());
				statement.setString(2, personnel.getSecondName());
				statement.setDate(3, getDate(personnel.getBirthday()));
				statement.setString(4, personnel.getSeriesNumberPas());
				statement.setInt(5, personnel.getIdLogin());
				statement.setString(6, personnel.getPost());
				statement.setDate(7, getDate(personnel.getStartWork()));
				statement.setDate(8, getDate(personnel.getEndWork()));
				statement.setString(9, personnel.getAddress());
				statement.setInt(10, personnel.getIdClient());
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
	public void deletePersonnelById(int id) {
		String deleteSQL = "DELETE FROM personnel WHERE id_client = ?";
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

	@Override
	public void deletePersonnelByName(Personnel personnel) {
		String deleteSQL = "DELETE FROM personnel WHERE first_name = ? AND second_nmae = ?";
		Connection con = conn.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			try {
				preparedStatement = con.prepareStatement(deleteSQL);
				preparedStatement.setString(1, personnel.getFirstName());
				preparedStatement.setString(2, personnel.getSecondName());
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
		if (localDate == null) {
			return null;
		}
		Date date = Date.valueOf(localDate.toString());
		return date;
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

}
