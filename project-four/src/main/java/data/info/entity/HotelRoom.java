package data.info.entity;

/**
 * class room in hotel
 * 
 * @author Sergey
 *
 */
public class HotelRoom {
	/**
	 * id room and number in hotel
	 */
	private int idRoom;
	/**
	 * id category in table category
	 */
	private int idCategory;
	/**
	 * cost one night
	 */
	private double costOneNight;
	/**
	 * additional categories in the rooms hotel
	 */
	private int additionallyCategory;
	
	/**
	 * empty hotel room
	 */
	public HotelRoom(){
		
	}

	/**
	 * 
	 * @param idRoom
	 *            id and number room
	 * @param idCategory
	 *            id category in table category
	 * @param costOneNight
	 *            cost one night
	 * @param additionallyCategory
	 *            additionally category in room hotel
	 */
	public HotelRoom(int idRoom, int idCategory, double costOneNight,
			int additionallyCategory) {
		super();
		this.idRoom = idRoom;
		this.idCategory = idCategory;
		this.costOneNight = costOneNight;
		this.additionallyCategory = additionallyCategory;
	}

	/**
	 * 
	 * @return id room and number room
	 */
	public int getIdRoom() {
		return idRoom;
	}

	/**
	 * set new id and number room in hotel
	 * 
	 * @param idRoom
	 */

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	/**
	 * 
	 * return id category room
	 */
	public int getIdCategory() {
		return idCategory;
	}

	/**
	 * set new category room
	 * 
	 * @param idCategory
	 */

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	/**
	 * 
	 * @return cost for one night
	 */

	public double getCostOneNight() {
		return costOneNight;
	}

	/**
	 * set new cost one night
	 * 
	 * @param costOneNight
	 */

	public void setCostOneNight(double costOneNight) {
		this.costOneNight = costOneNight;
	}

	/**
	 * 
	 * @return additionally category
	 */
	public int getAdditionallyCategory() {
		return additionallyCategory;
	}

	/**
	 * set new additionally category
	 * 
	 * @param additionallyCategory
	 */

	public void setAdditionallyCategory(int additionallyCategory) {
		this.additionallyCategory = additionallyCategory;
	}

}
