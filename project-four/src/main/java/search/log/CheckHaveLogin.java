package search.log;

import java.util.ArrayList;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;
import data.info.entity.Client;
import data.info.entity.Login;
import data.info.entity.Personnel;
import data.info.factorydaoorder.DaoFactory;

/**
 * Check if have login and password in table and determines type client
 * 
 * @author Sergey
 *
 */
public class CheckHaveLogin {
	private static final Logger logger1 = Logger
			.getLogger(CheckHaveLogin.class);
	/**
	 * manager in hotel.
	 */
	public static final String PERSONNEL_MANAGER = "manager";
	/**
	 * system manager in hotel.
	 */
	public static final String PERSONNEL_SYSTEM_MANAGER = "systemmanager";
	/**
	 * @see DaoFactory
	 */
	private DaoFactory factory;
	/**
	 * id login client
	 */
	private int idLogClintSite;

	/**
	 * initializes JDBCFactory
	 */
	public CheckHaveLogin(DaoFactory factory) {
		this.factory = factory;

	}

	/**
	 * check cookie type client site
	 * 
	 * @return 1 if manager client 2 if system manager 0 if client hotel
	 */
	public int checkTypeClient(String log) {
		int clientType = 0;
		if (checkLoginCookie(log)) {
			if (checkClientLogin(idLogClintSite)) {
				clientType = 0;
			} else if (checkManagerLogin(idLogClintSite)) {
				clientType = 1;
			} else if (checkSystemManagerLogin(idLogClintSite)) {
				clientType = 2;
			} else {

			}

		}
		return clientType;
	}

	/**
	 * 
	 * @return 1 if manager client 2 if system manager 0 if client hotel
	 */
	public int checkTypeClient(String log, String password) {
		int clientType = 0;
		if (checkLogin(log, password)) {
			if (checkClientLogin(idLogClintSite)) {
				return 0;
			} else if (checkManagerLogin(idLogClintSite)) {
				return 1;
			} else if (checkSystemManagerLogin(idLogClintSite)) {
				return 2;
			}

		}
		return clientType;

	}

	/**
	 * belongs login system manager hotel
	 * 
	 * @param idLogin
	 * @return
	 */

	public boolean checkSystemManagerLogin(int idLogin) {

		ArrayList<Personnel> listPersonnel = (ArrayList<Personnel>) factory
				.creatPersonnelDao().findAll();
		if (listPersonnel != null) {
			for (Client client : listPersonnel) {

				if (checkIdPostSystemManager(idLogin, client)) {
					return true;
				}
			}
		}

		return false;

	}

	/**
	 * belongs login manager hotel
	 * 
	 * @param idLogin
	 *            id login manager
	 * @return
	 */

	public boolean checkManagerLogin(int idLogin) {

		ArrayList<Personnel> listPersonnel = (ArrayList<Personnel>) factory
				.creatPersonnelDao().findAll();
		if (listPersonnel != null) {
			for (Client client : listPersonnel) {
				if (checkIdPostManager(idLogin, client)) {
					return true;
				}
			}
		}

		return false;

	}

	/**
	 * check have id login in table Personnel if have personnel post manager
	 * 
	 * @param idLogin
	 *            id login
	 * @param client
	 *            client site
	 * @return
	 */
	public boolean checkIdPostSystemManager(int idLogin, Client client) {
		return (idLogin == client.getIdLogin())
				&& (PERSONNEL_SYSTEM_MANAGER.equalsIgnoreCase(client.getPost()));
	}

	/**
	 * @param idLogin
	 *            id login
	 * @param client
	 *            client site
	 * @return
	 */
	public boolean checkIdPostManager(int idLogin, Client client) {
		return ((idLogin == client.getIdLogin()) && (PERSONNEL_MANAGER
				.equalsIgnoreCase(client.getPost())));
	}

	/**
	 * check belongs login client hotel
	 * 
	 * @param idLogin
	 *            id login
	 * @return
	 */
	public boolean checkClientLogin(int idLogin) {

		ArrayList<Client> listClient = (ArrayList<Client>) factory
				.createClientDao().findAll();
		if (listClient != null) {
			for (Client client : listClient) {

				if (idLogin == client.getIdLogin()) {
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * check login and password
	 * 
	 * @param Log
	 *            name login client
	 * @param password
	 *            password client
	 * @return true if login and password correct
	 */

	public boolean checkLogin(String log, String password) {

		ArrayList<Login> listLogin = (ArrayList<Login>) factory
				.createLoginDao().findAll();
		if (listLogin != null) {
			for (Login login : listLogin) {
				if (getEqualsLoginPassword(log, password, login)) {
					idLogClintSite = login.getIdLogin();
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * check cookie have login
	 * 
	 * @param Log
	 *            name login client
	 * @param password
	 *            password client
	 * @return true if login and password correct
	 */

	public boolean checkLoginCookie(String log) {
		ArrayList<Login> listLogin = (ArrayList<Login>) factory
				.createLoginDao().findAll();
		if (listLogin != null) {
			for (Login login : listLogin) {
				if (login.getLogin().equalsIgnoreCase(log)) {
					idLogClintSite = login.getIdLogin();
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * equals inject name login and password if correct and have in base data
	 * then return true else false
	 * 
	 * @param log
	 *            object login client
	 * @param password
	 *            password
	 * @param login
	 *            name login
	 * @return
	 */
	public boolean getEqualsLoginPassword(String log, String password,
			Login login) {
		return (login.getLogin().equalsIgnoreCase(log))
				&& (login.getPassword().equalsIgnoreCase(password));
	}

	/**
	 * return JDBSDaoFactory
	 * 
	 * @return
	 */
	public DaoFactory getFactory() {
		return factory;
	}

	/**
	 * set new Factory
	 * 
	 * @param factory
	 */
	public void setFactory(DaoFactory factory) {
		this.factory = factory;
	}

	/**
	 * return get id login client site
	 * 
	 * @return
	 */
	public int getIdLogClintSite() {
		return idLogClintSite;
	}

	/**
	 * set new id Login client site
	 * 
	 * @param idLogClintSite
	 */
	public void setIdLogClintSite(int idLogClintSite) {
		this.idLogClintSite = idLogClintSite;
	}

}
