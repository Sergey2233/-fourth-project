package comand.write.login;

import data.info.entity.Client;

import data.info.factorydaoorder.DaoFactory;

/**
 * write client in base
 * 
 * @author Sergey
 *
 */
public class ClientWrite implements CommandWriteLog {

	/**
	 * @see DaoFactory factory Dao realization entity
	 */
	private DaoFactory factory;
	/**
	 * @see Client
	 */
	private Client newClient;

	/**
	 * 
	 * @param factory
	 */
	/**
	 * intialization DaoFactory
	 * 
	 * @param factory
	 */
	public ClientWrite(DaoFactory factory, Client newClient) {
		this.factory = factory;
		this.newClient = newClient;
	}

	@Override
	public void execute() {

		factory.createClientDao().createClientReg(newClient);

	}

}
