package data.info.entity;

import java.time.LocalDate;
/**
 * class  personnel  client
 * @author Sergey
 *
 */
public class Personnel extends Client {
	/**
	 * when start work personnel
	 */
	private LocalDate startWork;
	/**
	 * when end work personnel
	 */
	private LocalDate endWork;
	/**
	 * where live personnel
	 */
	private String address;

	/**
	 * empty constructor
	 */
	public Personnel() {

	}

	/**
	 * @parm id  personnel id 
	 * 
	 * @param name
	 *            name personnel
	 * @param lastName
	 *            last name personnel
	 * @param birthday
	 *            birthday personnel
	 * @param seriesNumberPas
	 *            series number passport personnel
	 * @param idLogin
	 *            id log at registration personnel
	 * @param post
	 *            post personnel
	 * @param startWork
	 *            when personnel start work in hotel
	 * @param endWork
	 *            when personnel end work in hotel
	 * @param address
	 *            address where live personnel
	 */

	public Personnel(String name, String lastName, LocalDate birthday,
			String seriesNumberPas, int idLogin, String post,
			LocalDate startWork, LocalDate endWork, String address) {
		super(name, lastName, birthday, seriesNumberPas, idLogin);
	
		this.startWork = startWork;
		this.endWork = endWork;
		this.address = address;
	}

	/**
	 * 
	 * @return date start work.
	 */
	public LocalDate getStartWork() {
		return startWork;
	}

	/**
	 * set new date start work
	 * 
	 * @param startWork
	 */
	public void setStartWork(LocalDate startWork) {
		this.startWork = startWork;
	}

	/**
	 * 
	 * @return date end work personnel in hotel
	 */
	public LocalDate getEndWork() {
		return endWork;
	}

	/**
	 * set new date end work personnel in hotel
	 * 
	 * @param endWork
	 */
	public void setEndWork(LocalDate endWork) {
		this.endWork = endWork;
	}

	/**
	 * return address where live personnel
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * set new address where live personnel
	 * 
	 * @param address
	 */

	public void setAddress(String address) {
		this.address = address;
	}
}