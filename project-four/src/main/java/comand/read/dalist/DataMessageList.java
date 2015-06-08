package comand.read.dalist;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import data.info.entity.Message;
import data.info.factorydaoorder.DaoFactory;

/**
 * access data list massage clients
 * 
 * @author Sergey
 *
 */
public class DataMessageList implements DataList {
	private static final Logger logger1 = Logger
			.getLogger(DataMessageList.class);
	/**
	 * @see DaoFactory factory Dao realization entity
	 */
	private DaoFactory factory;
	/**
	 * login id client
	 */
	private int logId;

	/**
	 * Initialization DaoFactory
	 * 
	 * @param factory
	 * @return
	 */
	public DataMessageList(DaoFactory factory, int logId) {
		this.factory = factory;
		this.logId = logId;

	}

	/**
	 * return list message which owned client
	 */
	@Override
	public List<? extends Object> execute() {
		ArrayList<Message> messageList = (ArrayList<Message>) factory
				.createMrssageDao().findAll();
		ArrayList<Message> newmassgeList = new ArrayList<Message>();

		for (Message message : messageList) {
			if (message.getIdLogin() == logId) {
				newmassgeList.add(message);
			}
		}
		return newmassgeList;

	}

}
