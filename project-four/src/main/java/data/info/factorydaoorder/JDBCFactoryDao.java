package data.info.factorydaoorder;

import data.info.connectionjdbc.JDBCConnection;
import data.info.dao.interfacedao.AllocationCalendarsRoomsDao;
import data.info.dao.interfacedao.CategoryDao;
import data.info.dao.interfacedao.ClientDao;
import data.info.dao.interfacedao.HotelRoomDao;
import data.info.dao.interfacedao.LoginDao;
import data.info.dao.interfacedao.MessageDao;
import data.info.dao.interfacedao.OrderDao;
import data.info.dao.interfacedao.PersonnelDao;
import data.info.dao.realizationdao.CalendarsRoomsRealizationDao;
import data.info.dao.realizationdao.CategoryRealizationDao;
import data.info.dao.realizationdao.ClienRealizationDao;
import data.info.dao.realizationdao.HotelRoomRealizationDao;
import data.info.dao.realizationdao.LoginRealizationDao;
import data.info.dao.realizationdao.MessageRealizationDao;
import data.info.dao.realizationdao.OrderRealizationDao;
import data.info.dao.realizationdao.PersonnelRealizationDao;

/**
 * factory dao entity
 * 
 * @author Sergey
 *
 */
public class JDBCFactoryDao extends DaoFactory {
	/**
	 * @see JDBCConnection
	 */
	private JDBCConnection conn;

	
	/**
	 * empty constructor
	 */
	public JDBCFactoryDao() {
		super();

	}

	public JDBCFactoryDao(JDBCConnection conn) {
		this.conn = conn;

	}

	/**
	 * public
	 */

	@Override
	public AllocationCalendarsRoomsDao creatCalendarRoomsDao() {
		return new CalendarsRoomsRealizationDao(conn);
	}

	@Override
	public ClientDao createClientDao() {
		return new ClienRealizationDao(conn);
	}

	@Override
	public HotelRoomDao createHotelRoomDao() {
		return new HotelRoomRealizationDao(conn);
	}

	@Override
	public LoginDao createLoginDao() {
		return new LoginRealizationDao(conn);
	}

	@Override
	public OrderDao createOrderDao() {
		return new OrderRealizationDao(conn);
	}

	@Override
	public PersonnelDao creatPersonnelDao() {
		return new PersonnelRealizationDao(conn);
	}

	@Override
	public CategoryDao createCategoryDao() {
		return new CategoryRealizationDao(conn);
	}

	@Override
	public MessageDao createMrssageDao() {

		return new MessageRealizationDao(conn);
	}
	public JDBCConnection getConn() {
		return conn;
	}

	public void setConn(JDBCConnection conn) {
		this.conn = conn;
	}

}
