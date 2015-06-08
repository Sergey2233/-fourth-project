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
import data.info.dao.interfacedao.AllocationCalendarsRoomsDao;
import data.info.entity.AllocationCalendarsRooms;

/**
 * access date table allocation_calendars_rooms
 * 
 * @author Sergey
 *
 */
public class CalendarsRoomsRealizationDao implements
		AllocationCalendarsRoomsDao {
	private static final Logger logger1 = Logger
			.getLogger(CalendarsRoomsRealizationDao.class);

	/**
	 * connection jdbc
	 */
	private JDBCConnection conn;

	/*
	 * initialization connection with data base
	 * 
	 * @param conn
	 */

	public CalendarsRoomsRealizationDao(JDBCConnection conn) {
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
	public void create(AllocationCalendarsRooms allocationCalendar) {
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(
						"INSERT INTO allocation_calendars_rooms (id_room,id_client,"
								+ "arrival_date,eviction_date,cost_living) "
								+ " VALUES( ? , ? , ? ,? , ?)",
						Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, allocationCalendar.getIdRoom());
				statement.setInt(2, allocationCalendar.getIdClient());
				statement.setDate(3,
						getDate(allocationCalendar.getArrivalDate()));
				statement.setDate(4,
						getDate(allocationCalendar.getEvictionDate()));
				statement.setDouble(5, allocationCalendar.getCost());
				statement.executeUpdate();
				ResultSet key = statement.getGeneratedKeys();
				int itemId = 0;
				if (key.next()) {
					itemId = key.getInt(1);
					allocationCalendar.setIdCalendarRooms(itemId);
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
	public AllocationCalendarsRooms findById(int id) {
		Connection con = conn.getConnection();
		AllocationCalendarsRooms allCalendarRooms = new AllocationCalendarsRooms();
		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement("SELECT * FROM allocation_calendars_rooms where id = ?");
				statement.setInt(1, id);
				ResultSet result2 = statement.executeQuery();
				statement.executeUpdate();
				while (result2.next()) {
					allCalendarRooms.setIdCalendarRooms(result2
							.getInt("id_allocation"));
					allCalendarRooms.setIdClient(result2.getInt("id_client"));
					allCalendarRooms.setIdRoom(result2.getInt("id_room"));
					allCalendarRooms.setArrivalDate(getLocalDate(result2
							.getDate("arrival_date")));
					allCalendarRooms.setEvictionDate(getLocalDate(result2
							.getDate("eviction_date")));
					allCalendarRooms.setCost(result2.getDouble("cost_living"));
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

		return allCalendarRooms;

	}

	@Override
	public void update(AllocationCalendarsRooms allocationCalendar) {
		String updateTableSQL = "UPDATE allocation_calendars_rooms SET  id_room = ?,"
				+ "id_client = ?,arrival_date = ?,eviction_date = ?,cost_living = ?"
				+ " WHERE id_client = ?";
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(updateTableSQL);
				statement.setInt(1, allocationCalendar.getIdRoom());
				statement.setInt(2, allocationCalendar.getIdClient());
				statement.setDate(3,
						getDate(allocationCalendar.getArrivalDate()));
				statement.setDate(4,
						getDate(allocationCalendar.getEvictionDate()));
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
		String deleteSQL = "DELETE FROM allocation_calendars_rooms WHERE id_allocation = ?";
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
	public List<AllocationCalendarsRooms> findAll() {
		Connection con = conn.getConnection();
		ArrayList<AllocationCalendarsRooms> calendarRoomsAll = new ArrayList<AllocationCalendarsRooms>();
		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement("SELECT * FROM allocation_calendars_rooms  ");
				ResultSet result2 = statement.executeQuery();

				while (result2.next()) {
					AllocationCalendarsRooms allCalendarRooms = new AllocationCalendarsRooms();
					allCalendarRooms.setIdCalendarRooms(result2
							.getInt("id_allocation"));
					allCalendarRooms.setIdClient(result2.getInt("id_client"));
					allCalendarRooms.setIdRoom(result2.getInt("id_room"));
					allCalendarRooms.setArrivalDate(getLocalDate(result2
							.getDate("arrival_date")));
					allCalendarRooms.setEvictionDate(getLocalDate(result2
							.getDate("eviction_date")));
					allCalendarRooms.setCost(result2.getDouble("cost_living"));
					calendarRoomsAll.add(allCalendarRooms);

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

		return calendarRoomsAll;
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
