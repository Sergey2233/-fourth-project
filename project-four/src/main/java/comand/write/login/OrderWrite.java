package comand.write.login;

import data.info.entity.Order;
import data.info.factorydaoorder.DaoFactory;

/**
 * write order client in base
 * 
 * @author Sergey
 *
 */
public class OrderWrite implements CommandWriteLog {
	/**
	 * @see DaoFactory factory Dao realization entity
	 */
	private DaoFactory factory;
	private Order newOrder;

	/**
	 * 
	 * @param factory
	 */
	/**
	 * Initialization DaoFactory
	 * 
	 * @param factory
	 */
	public OrderWrite(DaoFactory factory, Order newOrder) {
		this.factory = factory;
		this.newOrder = newOrder;
	}

	@Override
	public void execute() {

		factory.createOrderDao().create(newOrder);

	}

}
