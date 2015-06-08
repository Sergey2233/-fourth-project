package data.info.entity;

import java.time.LocalDate;
/**
 * caledar employment room 
 * @author Sergey
 *
 */
public class  AllocationCalendarsRooms {
	/**
	 * id calendar rooms
	 */
	private int idCalendarRooms;
	/**
	 * id rooms in table hotel_rooms
	 */
	private int idRoom;
	/**
	 * id client in table client
	 */
	private int idClient;
	/**
	 * arrival date client in hotel
	 */

	private LocalDate arrivalDate;
	/**
	 * eviction data when client eviction in hotel
	 */
	private LocalDate evictionDate;
   /**
    *  Price for all accommodation
    */
	 private double cost;
	
	/**
	 * empty constructor
	 */
	public  AllocationCalendarsRooms() {
		super();
		
	}
 
	/**
	 * 
	 * @param idCalendarRooms id oder
	 * @param idRoom id room in table room_hotel
	 * @param idClient id client in table client
	 * @param arrivalDate date arrival client in hotel
	 * @param evictionDate date when client eviction with hotel
	 */
	public AllocationCalendarsRooms( int idRoom,
			int idClient, LocalDate arrivalDate, LocalDate evictionDate, double cost) {
		super();
		this.idRoom = idRoom;
		this.idClient = idClient;
		this.arrivalDate = arrivalDate;
		this.evictionDate = evictionDate;
		this.cost = cost;
	}
       public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
        * return id reserve or live in hotel
        * @return
        */
	public int getIdCalendarRooms() {
		return idCalendarRooms;
	}
 /**
  * add id resrve or live hotel
  * @param idCalendarRooms
  */
	public void setIdCalendarRooms(int idCalendarRooms) {
		this.idCalendarRooms = idCalendarRooms;
	}
/**
 * 
 * @return id room in hotel in reserve or live
 */
	public int getIdRoom() {
		return idRoom;
	}
	/**
	 * set new id room in reserve or  live in hotel
	 * @param idRoom
	 */

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}
      
	/**
	 * 
	 * @return id client which reserve room 
	 */
	public int getIdClient() {
		return idClient;
	}
     /**
      * set new id client which reserve room in hotel
      * @param idClient
      */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	} 
	
    /**
     * 
     * @return date arrival client in hotel
     */
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
      /**
       * set new  date  when arrival client in hotel 
       * @param arrivalDate
       */
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
     /**
      * return  date when client eviction hotel
      * @return
      */
	public LocalDate getEvictionDate() {
		return evictionDate;
	}
      /**
       * set new date when client eviction hotel
       * @param evictionDate
       */
	public void setEvictionDate(LocalDate evictionDate) {
		this.evictionDate = evictionDate;
	}

}
