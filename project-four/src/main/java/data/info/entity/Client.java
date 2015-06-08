package data.info.entity;

import java.time.LocalDate;

/**
 * class client hotel
 * 
 * @author Sergey
 *
 */
public class Client {
   /**client
    * id 
    */
	private int  idClient ;
	/**
    * first name client
    */
   private String firstName;
   /**
    * last second Name client
    */
   private String  secondName;
   /**
    * birthday client 
    */
   private LocalDate birthday;
   /**
    * series and number passport
    */
   private String seriesNumberPas;
   /**
    * id login in table login
    */
   private int  idLogin;
   /**
    * post clien default client
    */
   private String post;
   /**
    * number telephone
    */
	private String telephone;
	/**
   *  empty constructor 
   */
	public Client() {

	}
	
	/**
	 * 
	 * @param firstName first name client 
	 * @param secondName  second name  client
	 * @param birthday birthday client
	 * @param seriesNumberPas series number passport client
	 * @param idLogin id log at registration
	 */ 

	public Client(String firstName, String secondName, LocalDate birthday,
			String seriesNumberPas, int idLogin) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthday = birthday;
		this.seriesNumberPas = seriesNumberPas;
		this.idLogin = idLogin;
		this.post = "client";
	
	}
	/**
	 * 
	 *@param firstName first name client 
	 * @param secondName  second name  client
	 *  @param idLogin id log at registration
	 */
	public Client(String firstName, String secondName, int idLogin) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.idLogin = idLogin;
	}
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	/**
	 * 
	 * @return firstName client
	 */

	public String getFirstName() {
		return firstName;
	}
     /**
      * set new firstName client
      * @param firstName
      */
	public void setFirstName(String name) {
		this.firstName = name;
	}
       /**
        * 
        * @return last firstName client
        */
	public String getSecondName() {
		return secondName;
	}
       /**
        *  set new last firstName client 
        * @param lastName  new last  firstName client 
        */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	} 
	/**
	 * 
	 * @return date birthday client
	 */

	public LocalDate getBirthday() {
		return birthday;
	}
      /**
       * set new date birthday
       * @param birthday  new birthday
       */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	  /**
	   *  
	   * @return series and number passport client
	   */

	public String getSeriesNumberPas() {
		return seriesNumberPas;
	}
       /**
        * add new series and number passport client 
        * @param seriesNumberPas
        */
	public void setSeriesNumberPas(String seriesNumberPas) {
		this.seriesNumberPas = seriesNumberPas;
	}  
	 /**
	  *  
	  * @return id log in table login
	  */

	public int getIdLogin() {
		return idLogin;
	}
       /** 
        * new id login 
        * 
        * @param idLogin
        */
	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}
     /**
      *  
      * @return post client 
      */
	public String getPost() {
		return post;
	}
     /**
      * set new post 
      * @param post
      */
	
	public void setPost(String post) {
		this.post = post;
	}
	/**
	 * 
	 * @return telephone client
	 */
	public String getTelephone() {
		return telephone;
	}
	 /**
	  * set new telephone
	  * @param telephone
	  */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
