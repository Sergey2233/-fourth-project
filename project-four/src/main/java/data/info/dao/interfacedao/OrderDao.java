package data.info.dao.interfacedao;

import java.util.List;

import data.info.entity.Order;

public interface OrderDao {
	/**
	 * Create order
	 * 
	 * @param oder
	 */
	void create(Order order);

	/**
	 * 
	 * @param id
	 *            order
	 * @return order
	 */
	Order find(int id);

	/**
	 * 
	 * @return list order
	 */
	List<Order> findAll();

	/**
	 * Update order in base
	 * 
	 * @param user
	 */
	void update(Order user);

	/**
	 * delete order by id
	 * 
	 * @param id
	 */
	void delete(int id);

}
