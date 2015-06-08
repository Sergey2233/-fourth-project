package data.info.dao.interfacedao;

import java.util.List;

import data.info.entity.Personnel;

/**
 * access date personnel in table personnel
 * 
 * @author Sergey
 * @see PersonnelDao
 */
public interface PersonnelDao {
	/**
	 * create new Personnel in table personnel
	 * 
	 * @param personnelDao
	 */
	void create(Personnel personnel);

	/**
	 * 
	 * @param id
	 * @return personnel by id
	 */
	Personnel find(int id);

	/**
	 * 
	 * @return list all personnel
	 */
	List<Personnel> findAll();

	/**
	 * update personnel by id
	 * 
	 * @param personnelDao
	 */
	void update(Personnel personnel);

	/**
	 * delete personnel by id
	 * 
	 * @param id
	 */
	void deletePersonnelById(int id);

	/**
	 * delete personnel by first name and last name
	 * 
	 * @param id
	 */
	void deletePersonnelByName(Personnel personnel);

}
