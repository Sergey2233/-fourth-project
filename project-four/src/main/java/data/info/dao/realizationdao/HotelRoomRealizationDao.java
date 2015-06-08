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
import data.info.dao.interfacedao.HotelRoomDao;
import data.info.entity.HotelRoom;
/**
 * access date table hotel_room
 * @author Sergey
 *
 */
public class HotelRoomRealizationDao implements HotelRoomDao {
	private static final Logger logger1 = Logger
			.getLogger(HotelRoomRealizationDao.class);

	/**
	 * connection jdbc
	 */
	private JDBCConnection conn;

	/*
	 * initialization connection with data base
	 * 
	 * @param conn
	 */

	public  HotelRoomRealizationDao(JDBCConnection conn) {
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
	public void create(HotelRoom hotelRoom) {
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement(
								"INSERT INTO hootel_rooms (id_category,cost_one_night,"
								+ "additionally_category) "
										+ " VALUES( ? , ? , ? )",
								Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, hotelRoom.getIdCategory());
				statement.setDouble(2, hotelRoom.getCostOneNight());
				statement.setInt(3, hotelRoom.getAdditionallyCategory());
				statement.executeUpdate();
				ResultSet key = statement.getGeneratedKeys();
				int itemId = 0;
				if (key.next()) {
					itemId = key.getInt(1);
					hotelRoom.setIdRoom(itemId);
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
	public HotelRoom find(int id) {
		Connection con = conn.getConnection();
		HotelRoom hotelRoom = new HotelRoom();
		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement("SELECT * FROM hootel_rooms where id = ?");
				statement.setInt(1, id);
				ResultSet result2 = statement.executeQuery();
			
				while (result2.next()) {
					
					hotelRoom.setIdRoom(result2.getInt("id_room"));
					hotelRoom.setIdCategory(result2.getInt("id_category"));
					hotelRoom.setCostOneNight(result2.getDouble("cost_one_night"));
					hotelRoom.setAdditionallyCategory(result2.getInt("additionally_category"));
					
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

		return hotelRoom;
	}

	@Override
	public List<HotelRoom> findAll() {
		Connection con = conn.getConnection();
		ArrayList<HotelRoom> hotelRoomAll = new ArrayList<HotelRoom>();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement("SELECT * FROM hotel_rooms ");
				ResultSet result2 = statement.executeQuery();
			
				while (result2.next()) {
				     HotelRoom hotelRoom = new HotelRoom();
					hotelRoom.setIdRoom(result2.getInt("id_room"));
					hotelRoom.setIdCategory(result2.getInt("id_category"));
					hotelRoom.setCostOneNight(result2.getDouble("cost_one_night"));
					hotelRoom.setAdditionallyCategory(result2.getInt("additionally_category"));
					hotelRoomAll.add(hotelRoom);
					
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

		return hotelRoomAll;
	}

	@Override
	public void update(HotelRoom hotelRoom) {
		String updateTableSQL = "UPDATE hotel_rooms SET  id_category=?,cost_one_night=?,"
								+ "additionally_category=?"
				+ " WHERE id_client = ?";
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(updateTableSQL);
				statement.setInt(1, hotelRoom.getIdCategory());
				statement.setDouble(2, hotelRoom.getCostOneNight());
				statement.setInt(3, hotelRoom.getAdditionallyCategory());
				statement.setInt(4, hotelRoom.getIdRoom());
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
		String deleteSQL = "DELETE FROM hotel_rooms WHERE id_client = ?";
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
