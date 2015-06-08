package comand.write.login;

import data.info.entity.Personnel;
import data.info.factorydaoorder.DaoFactory;

/**
 * write personnel date in base
 * 
 * @author Sergey
 *
 */
public class PersonnelWrite implements CommandWriteLog {
	/**
	 * @see DaoFactory factory Dao realization entity
	 */
	private DaoFactory factory;
	/**
	 * @see Personnel
	 */
	private Personnel newPersonnel;

	/**
	 * 
	 * @param factory
	 */
	/**
	 * intialization DaoFactory
	 * 
	 * @param factory
	 * @return
	 */
	public PersonnelWrite(DaoFactory factory, Personnel personnel) {
		this.factory = factory;
		this.newPersonnel = personnel;
	}

	@Override
	public void execute() {

		factory.creatPersonnelDao().create(newPersonnel);

	}

}
