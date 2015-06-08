package comand.readirect.main;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import search.log.CheckHaveLogin;
import comand.readirect.login.CommandRedirectCustomer;
import comand.readirect.login.CommandRedirectManager;
import comand.readirect.login.CommandRedirectSystemManager;
import data.info.connectionjdbc.JDBCConnection;
import data.info.factorydaoorder.JDBCFactoryDao;
import data.info.factorydaoorder.DaoFactory;
/**
 * Authentication 
 * @author Sergey
 *
 */
public class Athentication implements ActionCommand {
 /*
  *  variable customer  page
  */
	private  static final int 	CUSTOMER = 0;
	/**
	 * variable manager page
	 */
	
	private  static final int MANAGER =1 ;
	/**
	 * variable system  manager  page
	 */
	private  static final int MANAGERSYSTEM = 2;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int typeClient = parseLogin(request, response);
		redirectJspClient(response, typeClient);


	}

	
	/**
	 *
	 * return type client
	 * 
	 * @param request
	 * @return int 1 or 2
	 * @see CheckCorrectClient
	 *
	 *
	 * @param request
	 * @param response
	 */
	public int parseLogin(HttpServletRequest request,
			HttpServletResponse response) {
		JDBCConnection connection = JDBCConnection.getInstance();
		DaoFactory factoryDao = new JDBCFactoryDao(connection);
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		CheckHaveLogin checkClient = new CheckHaveLogin(factoryDao);
		String login = request.getParameter("logName");
		String password = request.getParameter("password");
		if (checkClient.checkLogin(login, password)) {
			addCokie(login, response);
			if (session != null) {
				//session.removeAttribute("idlogName");
				session.setAttribute("idlogName", login);
			}
		}
		int typeClientSite = checkClient.checkTypeClient(login, password);
		return typeClientSite;
	}

	/**
	 * add cookie to response
	 * 
	 * @param login
	 * @param response
	 */
	public static void addCokie(String login, HttpServletResponse response) {
		Cookie cookie = new Cookie("logName", login);
		cookie.setMaxAge(365 * 24 * 60 * 60);
		response.addCookie(cookie);
	}

	/**
	 * redirect on page client in addiction client
	 * 
	 * @param response
	 * @param typeClientSite
	 */
	public void redirectJspClient(ServletResponse response, int typeClientSite) {
		switch (typeClientSite) {
		case MANAGER:
			new CommandRedirectManager().execute(response);
			break;
		case MANAGERSYSTEM :
			new CommandRedirectSystemManager().execute(response);
			break;
		case CUSTOMER:
			new CommandRedirectCustomer().execute(response);
			break;

		}

	}
}
