package data.info.dao.interfacedao;

import java.util.List;

import data.info.entity.Category;
/** category room hotel
 * 
 * @author Sergey
 *
 */
public interface CategoryDao {

	/**
	 * Create Client
	 * 
	 * @param user
	 */
	void create(Category category);

	/**
	 * 
	 * @param id
	 *            category
	 * @return category
	 */
	Category find(int id);

	/**
	 * 
	 * @return list client
	 */
	List<Category> findAll();

	/**
	 * Update client in base
	 * 
	 * @param user
	 */
	void update(Category category);

	/**
	 * delete client by id
	 * 
	 * @param id
	 */
	void delete(int id);

}
