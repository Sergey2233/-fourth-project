package data.info.dao.interfacedao;

import java.util.List;

import data.info.entity.Client;

/**
 * interface access data in table client
 * 
 * @author Sergey
 * @see Client
 */
public interface ClientDao {
	/**
	 * register client
	 * 
	 * @param user
	 */
	void createClientReg(Client user);

	/**
	 * Create Client
	 * 
	 * @param user
	 */
	void create(Client user);

	/**
	 * 
	 * @param id
	 *            client
	 * @return client
	 */
	Client find(int id);

	/**
	 * 
	 * @return list client
	 */
	List<Client> findAll();

	/**
	 * Update client in base
	 * 
	 * @param user
	 */
	void update(Client user);

	/**
	 * delete client by id
	 * 
	 * @param id
	 */
	void delete(int id);

	/**
	 * delete client by first name and last name
	 * 
	 * @param id
	 */
	void delete(Client client);
}
