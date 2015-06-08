package comand.write.login;

import data.info.entity.Login;
import data.info.factorydaoorder.DaoFactory;
/**write login in table login
 * 
 * @author Sergey
 *
 */
public class LoginWrite implements CommandWriteLog {
   /**
    * @see DaoFactory 
    * factory Dao realization entity 
    */
	private  DaoFactory factory;
	  private  Login newLogin;
	/**
	 * 
	 * @param factory
	 */
	/**	
	 * Initialization DaoFactory 
	 * @param factory
	 */
	public  LoginWrite(DaoFactory factory,Login newLogin){
		this.factory = factory;
		this.newLogin =  newLogin;
	}
	@Override
	public void execute( ) {
		
		  factory.createLoginDao().create(newLogin);
 
	}
	
	

}
