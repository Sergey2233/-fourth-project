package data.info.dao.interfacedao;

import java.util.List;

import data.info.entity.Login;

/**
 * interface access to login table
 * 
 * @author Sergey
 * @see Login
 */
public interface LoginDao {
	/**
	 * create new Login in table Login
	 * 
	 * @param login
	 */
	void create(Login login);

	/**
	 * return Login by id login
	 * 
	 * @param id
	 *            id Login
	 * @return Login
	 */
	Login find(int id);

	/**
	 * return all list login
	 * 
	 * @return list login
	 */
	List<Login> findAll();

	/**
	 * update login in table
	 * 
	 * @param login
	 */
	void update(Login login);

	/**
	 * delete login by id
	 * 
	 * @param id
	 */
	void delete(int id);

}
