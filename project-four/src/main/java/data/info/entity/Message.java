package data.info.entity;
/**class message clients
 * 
 * @author Sergey
 *
 */
public class Message {
	/**
	 * id  message
	 */
	private int  idMesage;
	/**
	 * cost living in hotel at time
	 */
	private double costLiving;
	/**
	 * boolean if reservation room then true else false
	 */
	private boolean  reservation;
	/**
	 * id log client
	 */
	private int idLogin;
	/**
	 * empty constructor
	 */
	/**
	 * id room
	 */
	private int idRoom;
	public Message() {
		super();
	
	}
	/**
	 * 
	 * @param idMesage id message
	 * @param costLiving cost living in hotel 
	 * @param reservation reservation true or false
	 * @param idLogin id login clients
	 */
	public Message(double costLiving, boolean reservation,
			int idLogin,int idRoom) {
		super();
		this.costLiving = costLiving;
		this.reservation = reservation;
		this.idLogin = idLogin;
		this.idRoom = idRoom;
	} 
	 /**
	  *
	  * @return  number room  reservation
	  */
	public int getIdRoom() {
		return idRoom;
	}
	  /**
	   * set new number room reservation
	   * @param idRoom
	   */
	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}
	/**
	 * 
	 * @return id message
	 */
	public int getIdMesage() {
		return idMesage;
	}
	/**
	 * set new id massage
	 * @param idMesage
	 */
	public void setIdMesage(int idMesage) {
		this.idMesage = idMesage;
	}
	/**
	 * 
	 * @return cost living in hotel
	 */
	public double getCostLiving() {
		return costLiving;
	}
	 /**
	  * set new cost living in hotel
	  * @param costLiving
	  */
	public void setCostLiving(double costLiving) {
		this.costLiving = costLiving;
	}
	  /**
	   * 
	   * @return reservation or not reservation
	   */
	public boolean isReservation() {
		return reservation;
	}
	/**
	 * set reservation or not reservation
	 * @param reservation
	 */
	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	} 
	 /**
	  * 
	  * @return id login  client
	  */
	public int getIdLogin() {
		return idLogin;
	}
	  /**
	   *  set new id login
	   * @param idLogin
	   */
	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	} 
	

}
