package data.info.entity;
/**
 * login client and personnel
 * @author Sergey
 *
 */
public class Login {

	/**
	 * id log
	 * 
	 */
	private int idLogin;
	/**
	 * login client and manager and system manager
	 */
	private String login;
	/**
	 * password client and manager and system manager
	 */
	private String password;
	/**
	 * empty constructor
	 */
	
	public Login() {
		super();
		
	}
	/**
	 * 
	 * @param idLogin id log
	 * @param login login 
	 * @param password password 
	 */ 
	public Login( String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	/**
	 * 
	 * @return id log
	 */
	public int getIdLogin() {
		return idLogin;
	}
	/**
	 * 
	 * @param idLogin new id log
	 */
	
	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}
	/**
	 * 
	 * @return name login client and manager and system manager
	 */ 
	public String getLogin() {
		return login;
	}
	  /**
	   * 
	   * @param login new log name client and manager hotel and system manager
	   */
	  
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * 
	 * @return password client and manager hotel and system manager
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
