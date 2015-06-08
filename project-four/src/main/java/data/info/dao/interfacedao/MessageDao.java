package data.info.dao.interfacedao;

import java.util.List;
import data.info.entity.Message;

/**
 * access message in base
 * 
 * @author Sergey
 *
 */
public interface MessageDao {

	/**
	 * create new Message in table Login
	 * 
	 * @param login
	 */
	void create(Message login);

	/**
	 * return Message by id message
	 * 
	 * @param id
	 *            message
	 * 
	 * @return Massage
	 */
	Message find(int id);

	/**
	 * return all list Massage
	 * 
	 * @return list Massage
	 */
	List<Message> findAll();

	/**
	 * update Message in table
	 * 
	 * @param Message
	 */
	void update(Message message);

	/**
	 * delete Message by id
	 * 
	 * @param id
	 */
	void delete(int id);
}
