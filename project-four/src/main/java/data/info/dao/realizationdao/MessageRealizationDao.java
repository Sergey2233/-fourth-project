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
import data.info.dao.interfacedao.MessageDao;
import data.info.entity.Message;

public class MessageRealizationDao implements MessageDao {
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

	public MessageRealizationDao(JDBCConnection conn) {
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
	public void create(Message message) {
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(
						"INSERT INTO messagecost (cost_living,reservations,id_login,id_room) "
								+ " VALUES( ?,?,?,? )",
						Statement.RETURN_GENERATED_KEYS);
				statement.setDouble(1, message.getCostLiving());
				String bool = (new Boolean(message.isReservation())).toString();
				statement.setString(2, bool);
				statement.setInt(3, message.getIdLogin());
				statement.setInt(4, message.getIdRoom());
				statement.executeUpdate();
				ResultSet key = statement.getGeneratedKeys();
				int itemId = 0;
				if (key.next()) {
					itemId = key.getInt(1);
					message.setIdMesage(itemId);
					;
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
	public Message find(int id) {

		Connection con = conn.getConnection();
		Message message = new Message();

		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement("SELECT * FROM messagecost where id = ?");
				statement.setInt(1, id);
				ResultSet result2 = statement.executeQuery();
				while (result2.next()) {
					message.setIdLogin(result2.getInt("id_message_cost"));
					message.setCostLiving(result2.getDouble("cost_living"));
					message.setReservation(result2.getBoolean("reservations"));
					message.setIdLogin(result2.getInt("id_login"));
					message.setIdLogin(result2.getInt("id_room"));
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

		return message;
	}

	@Override
	public List<Message> findAll() {

		Connection con = conn.getConnection();

		ArrayList<Message> messageAll = new ArrayList<Message>();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement("SELECT * FROM messagecost");
				ResultSet result2 = statement.executeQuery();

				while (result2.next()) {
					Message message = new Message();
					message.setIdMesage(result2.getInt("id_message_cost"));
					message.setCostLiving(result2.getDouble("cost_living"));
					message.setReservation(result2.getBoolean("reservations"));
					message.setIdLogin(result2.getInt("id_login"));
					message.setIdRoom(result2.getInt("id_room"));
					messageAll.add(message);

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

		return messageAll;
	}

	@Override
	public void update(Message message) {
		String updateTableSQL = "UPDATE messagecost SET cost_living =?,reservations =?,id_login=?,id_room=?"
				+ " WHERE id = ?";
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(updateTableSQL);
				statement.setDouble(1, message.getCostLiving());
				statement.setBoolean(2, message.isReservation());
				statement.setInt(3, message.getIdLogin());
				statement.setInt(4, message.getIdRoom());
				statement.setInt(5, message.getIdMesage());
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
		String deleteSQL = "DELETE FROM messagecost WHERE id_message_cost = ?";
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
