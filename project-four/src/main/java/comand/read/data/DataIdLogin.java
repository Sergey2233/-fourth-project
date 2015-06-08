package comand.read.data;

import java.util.ArrayList;

import data.info.entity.Login;
import data.info.factorydaoorder.DaoFactory;

/**
 * read data login.
 * 
 * @author Sergey
 *
 */
public class DataIdLogin implements DataRead {
	/**
	 * @see DaoFactory factory Dao realization entity
	 */
	private DaoFactory factory;
	/**
	 * name login
	 */

	private String nameLogin;

	/**
	 * 
	 * @param factory
	 */
	/**
	 * Initialization DaoFactory
	 * 
	 * @param factory
	 * @return
	 */
	public DataIdLogin(DaoFactory factory, String nameLogin) {
		this.factory = factory;
		this.nameLogin = nameLogin;
	}

	/**
	 * return id login on name login
	 */
	@Override
	public int execute() {
		ArrayList<Login> loginList = (ArrayList<Login>) factory
				.createLoginDao().findAll();
		for (Login login : loginList) {
			if (login.getLogin().equals(nameLogin)) {
				return login.getIdLogin();
			}

		}
		return 0;
	}

}
