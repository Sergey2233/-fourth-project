package comand.read.dalist;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import data.info.entity.Order;
import data.info.factorydaoorder.DaoFactory;

/**
 * access data list order
 * 
 * @author Sergey
 *
 */
public class DataOrderList implements DataList {
	private static final Logger logger1 = Logger.getLogger(DataOrderList.class);
	/**
	 * @see DaoFactory factory Dao realization entity
	 */
	private DaoFactory factory;

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
	public DataOrderList(DaoFactory factory) {
		this.factory = factory;

	}

	/**
	 * return list order
	 */

	@Override
	public List<? extends Order> execute() {
		ArrayList<Order> orderList = (ArrayList<Order>) factory
				.createOrderDao().findAll();
		return orderList;
	}

}
