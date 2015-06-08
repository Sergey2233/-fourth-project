package data.info.dao.interfacedao;

import java.util.List;

import data.info.entity.AllocationCalendarsRooms;

/**
 * interface access data in table allocation calendar rooms
 * 
 * @author Sergey
 * @see AllocationCalendarsRooms
 */
public interface AllocationCalendarsRoomsDao {
	/**
	 * create AllocationCalendarsRooms.
	 * 
	 * @param allocationCalendar
	 */
	void create(AllocationCalendarsRooms allocationCalendar);

	/**
	 * 
	 * @param id
	 *            allocation calendar rooms.
	 * @return AllocationCalendarsRooms
	 * 
	 */

	AllocationCalendarsRooms findById(int id);

	/**
	 * return list allocation calendar rooms.
	 * 
	 * @return
	 */

	List<AllocationCalendarsRooms> findAll();

	/**
	 * update allocation calendar rooms
	 * 
	 * @param calendarRooms
	 */

	void update(AllocationCalendarsRooms calendarRooms);

	/**
	 * delete in table AllocationCalendarsRooms.
	 * 
	 * @param id
	 */

	void delete(int id);

}
