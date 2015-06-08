package comand.write.login;

import data.info.entity.AllocationCalendarsRooms;
import data.info.factorydaoorder.DaoFactory;

public class CalendarWrite implements CommandWriteLog {
	/**
	 * @see DaoFactory factory Dao realization entity
	 */
	private DaoFactory factory;
	/**
	 * calendar employment
	 * 
	 * @see AllocationCalendarsRooms
	 */
	private AllocationCalendarsRooms calendar;

	/**
	 * 
	 * @param factory
	 */
	/**
	 * Initialization DaoFactory
	 * 
	 * @param factory
	 */
	public CalendarWrite(DaoFactory factory,
			AllocationCalendarsRooms calendar) {
		this.factory = factory;
		this.calendar = calendar;
	}

	@Override
	public void execute() {

		factory.creatCalendarRoomsDao().create(calendar);

	}
}
