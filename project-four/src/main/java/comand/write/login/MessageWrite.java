package comand.write.login;

import data.info.entity.Client;
import data.info.entity.Message;
import data.info.factorydaoorder.DaoFactory;
/**
 * write massage clients in baze
 * @author Sergey
 *
 */
public class MessageWrite implements CommandWriteLog {
	 /**
	    * @see DaoFactory 
	    * factory Dao realization entity 
	    */
		private  DaoFactory factory;
		/**
		 * @see Client
		 */
		private  Message message;
		/**
		 * 
		 * @param factory
		 */
		/**	
		 * Initialization DaoFactory 
		 * @param factory
		 */
		public  MessageWrite (DaoFactory factory,Message message){
			this.factory = factory;
			this.message = message;
		}
      @Override
		public void execute() {
			 
			  factory.createMrssageDao().create(message);
		
	}
}
