package search.loginname;

import java.util.ArrayList;

import data.info.entity.Login;
import data.info.factorydaoorder.DaoFactory;

/**
 * search name by id
 * 
 * @author Sergey
 *
 */
public class SearchNameLogin {
	/**
	 * factory dao
	 */
	private DaoFactory factory;

	/**
	 * initializes factory
	 * 
	 * @param factory
	 */
	public SearchNameLogin(DaoFactory factory) {
		this.factory = factory;
	}

	/**
	 * 
	 * @return name category by id category
	 */

	public String getlogName(int id) {
		String nameCategory = "";
		ArrayList<Login> listLogin = (ArrayList<Login>) factory
				.createLoginDao().findAll();
		for (Login log : listLogin) {
			if (log.getIdLogin() == id) {
				return log.getLogin();
			}

		}
		return nameCategory;
	}
}
