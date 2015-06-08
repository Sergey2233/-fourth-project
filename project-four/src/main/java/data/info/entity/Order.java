package data.info.entity;


import java.time.LocalDate;

/**
 * class oder client
 * 
 * @author Sergey
 *
 */
public class Order {
	/**
	 * number oder
	 */
	private int idOder;
	
	/**
	 * category room
	 */
	private String categoryRoom;
	/**
	 * telephone client
	 */
	private String telephone;
	/**
	 * arrival date
	 */
	private LocalDate arrivalDate;
	/**
	 * eviction date
	 */
	private LocalDate evictionDate;
    /**
     * id login with table login
     */
	private String idLogin;
	

	/**
	 * emty constructor
	 */
	public Order() {
		super();
		
	}

	/**
	 * 
	 * @param idOder
	 *            number oder
	 * @param firstName
	 *            first name client
	 * @param secondName
	 *            second name client
	 * @param categoryRoom
	 *            category room
	 * @param telephone
	 *            telephone
	 * @param arrivelDate
	 *            arrival data client in hotel
	 * @param evictionDate
	 *            eviction data client in hotel
	 */
	public Order( 
			String categoryRoom, String telephone, LocalDate arrivalDate,
			LocalDate evictionDate,String idLogin) {
		super();
		
		this.categoryRoom = categoryRoom;
		this.telephone = telephone;
		this.arrivalDate = arrivalDate;
		this.evictionDate = evictionDate;
		this.idLogin = idLogin;
	}

	/**
	 * get id oder
	 * 
	 * @return
	 */
	public int getIdOder() {
		return idOder;
	}

	/**
	 * set new id oder
	 * 
	 * @param idOder
	 */
	public void setIdOder(int idOder) {
		this.idOder = idOder;
	}

	
	
	/**
	 * get id category room hotel in table category.
	 * 
	 * @return
	 */
	public String getCategoryRoom() {
		return categoryRoom;
	}

	/**
	 * set new category room.
	 * 
	 * @param categoryRoom
	 */
	public void setCategoryRoom(String categoryRoom) {
		this.categoryRoom = categoryRoom;
	}

	/**
	 * 
	 * @return telephone client
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * set new telephone client
	 * 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * return date arrival client in hotel.
	 * 
	 * @return
	 */
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * set new arrival data
	 * 
	 * @param arrivalDate
	 */
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * 
	 * @return eviction date client.
	 */
	public LocalDate getEvictionDate() {
		return evictionDate;
	}

	/**
	 * set new date eviction client with hotel
	 * 
	 * @param evictionDate
	 */
	public void setEvictionDate(LocalDate evictionDate) {
		this.evictionDate = evictionDate;
	}
	/**
	 * 
	 * @return login id client
	 */
	public String getIdLogin() {
		return idLogin;
	}
      /**
       * set new  login client oder
       * @param idLogin
       */
	public void setIdLogin(String idLogin) {
		this.idLogin = idLogin;
	}

}
