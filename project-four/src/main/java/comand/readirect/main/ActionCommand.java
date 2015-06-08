package comand.readirect.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * command  interface  
 * @author Sergey
 *
 */
public interface ActionCommand {
 /**
  *  execution of actions command 
  */
	public  void  execute(HttpServletRequest request, HttpServletResponse response);
}
