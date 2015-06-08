package data.info.dao.interfacedao;

import java.util.List;

import data.info.entity.HotelRoom;

/**
 * interface access date table hotel rooms
 * 
 * @author Sergey
 * @see HotelRoms
 */
public interface HotelRoomDao {
	/**
	 * create new HotelRoom
	 * 
	 * @param orderItem
	 */
	void create(HotelRoom orderItem);

	/**
	 * 
	 * @param id
	 *            hotel room
	 * @return HotelRoom
	 */
	HotelRoom find(int id);

	/**
	 * 
	 * @return list HootelRoom
	 */
	List<HotelRoom> findAll();

	/**
	 * update HootelRoom in table
	 * 
	 * @param hotelRoom
	 */
	void update(HotelRoom hotelRoom);

	/**
	 * delete data in table hotel room by id
	 * 
	 * @param id
	 */
	void delete(int id);

}
