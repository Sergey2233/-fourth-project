package comand.readirect.login;

import javax.servlet.ServletResponse;

/**
 * command interface redirect in other page
 * 
 * @author Sergey
 *
 */
public interface CommandRedirectLog {
	/**
	 * redirect other page
	 * 
	 * @param response
	 */
	public void execute(ServletResponse response);
}
