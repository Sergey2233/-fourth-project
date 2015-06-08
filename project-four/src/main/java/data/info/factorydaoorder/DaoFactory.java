package data.info.factorydaoorder;

import java.util.Properties;

import org.apache.log4j.Logger;

import data.info.dao.interfacedao.AllocationCalendarsRoomsDao;
import data.info.dao.interfacedao.CategoryDao;
import data.info.dao.interfacedao.ClientDao;
import data.info.dao.interfacedao.HotelRoomDao;
import data.info.dao.interfacedao.LoginDao;
import data.info.dao.interfacedao.MessageDao;
import data.info.dao.interfacedao.OrderDao;
import data.info.dao.interfacedao.PersonnelDao;


public abstract class DaoFactory {
	private static final Logger logger1 = Logger.getLogger(JDBCFactoryDao.class);
      /**
       *  
       * @return calendar rooms  dao in hotel
       */
	public abstract AllocationCalendarsRoomsDao creatCalendarRoomsDao();
     /**
      * 
      * @return client dao 
      */
	public abstract ClientDao createClientDao();
    /**
     * create  rooms dao in hotel
     * @return
     */
	public abstract HotelRoomDao createHotelRoomDao();
      /**
       * 
       * @return login dao client
       */
	public abstract LoginDao createLoginDao();
      /**
       * 
       * @return order dao clients
       */
	public abstract OrderDao  createOrderDao();
 /**
  * 
  * @return personnel dao  hotel
  */
	public abstract PersonnelDao creatPersonnelDao();
	/**
	 * 
	 * @return category dao hotel room
	 */
	public abstract CategoryDao  createCategoryDao();
	/**
	 * 
	 * @return service room  dao in hotel
	 */


	 /**
     * 
     * @return message dao 
     */
	public abstract MessageDao createMrssageDao();
      /**
       * init Factory dao with property fail
       * @return Factory dao 
       */
	

	
}
