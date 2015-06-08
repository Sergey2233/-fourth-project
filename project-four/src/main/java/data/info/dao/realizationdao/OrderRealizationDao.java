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
import data.info.dao.interfacedao.OrderDao;
import data.info.entity.Order;

/**
 * acces table order
 * 
 * @author Sergey
 *
 */
public class OrderRealizationDao implements OrderDao {

	private static final Logger logger1 = Logger
			.getLogger(OrderRealizationDao.class);

	/**
	 * connection jdbc
	 */
	private JDBCConnection conn;

	/*
	 * initialization connection with data base
	 * 
	 * @param conn
	 */

	public OrderRealizationDao(JDBCConnection conn) {
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
	public void create(Order order) {
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement(
								"INSERT INTO order1 (categoryroom,telephone,arrival_date,eviction_date,idlogin)"
										+ " VALUES( ?,?,?,?,?)",
								Statement.RETURN_GENERATED_KEYS);

				statement.setString(1, order.getCategoryRoom());
				statement.setString(2, order.getTelephone());
				statement.setDate(3, getDate(order.getArrivalDate()));
				statement.setDate(4, getDate(order.getEvictionDate()));
				statement.setString(5, order.getIdLogin());
				statement.executeUpdate();
				ResultSet key = statement.getGeneratedKeys();
				int itemId = 0;
				if (key.next()) {
					itemId = key.getInt(1);
					order.setIdOder(itemId);
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
	public Order find(int id) {
		Connection con = conn.getConnection();
		Order order = new Order();
		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement("SELECT * FROM order1 where id = ?");
				statement.setInt(1, id);
				ResultSet result2 = statement.executeQuery();
				while (result2.next()) {
					order.setIdOder(result2.getInt("id_oder"));

					order.setCategoryRoom(result2.getString("category_room"));
					order.setTelephone(result2.getString("telephone"));
					order.setArrivalDate(getLocalDate(result2
							.getDate("arrival_date")));
					order.setEvictionDate(getLocalDate(result2
							.getDate("aviction_date")));
					order.setIdLogin(result2.getString("id_login"));
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

		return order;
	}

	@Override
	public List<Order> findAll() {
		Connection con = conn.getConnection();
		ArrayList<Order> orderAll = new ArrayList<Order>();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement("SELECT * FROM order1 ");
				ResultSet result2 = statement.executeQuery();

				while (result2.next()) {
					Order order = new Order();
					order.setIdOder(result2.getInt("id_order"));
					order.setCategoryRoom(result2.getString("categoryroom"));
					order.setTelephone(result2.getString("telephone"));
					order.setArrivalDate(getLocalDate(result2
							.getDate("arrival_date")));
					order.setEvictionDate(getLocalDate(result2
							.getDate("eviction_date")));
					order.setIdLogin(result2.getString("idlogin"));
					orderAll.add(order);

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

		return orderAll;
	}

	@Override
	public void update(Order order) {
		String updateTableSQL = "UPDATE order1 SET  first_name = ?,"
				+ "second_name = ?,categoryroom = ?,telephone = ?,arrivaldate = ?,evictiondate = ? idlogin = ?"
				+ " WHERE id_order = ?";
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(updateTableSQL);
				statement.setString(3, order.getCategoryRoom());
				statement.setString(4, order.getTelephone());
				statement.setDate(5, getDate(order.getArrivalDate()));
				statement.setDate(6, getDate(order.getEvictionDate()));
				statement.setString(7, order.getIdLogin());
				statement.setInt(8, order.getIdOder());
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

		String deleteSQL = "DELETE FROM order1 WHERE id_order = ?";
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
