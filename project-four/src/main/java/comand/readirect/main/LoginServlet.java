package comand.readirect.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



import comand.readirect.login.CommandRedirectCustomer;
import comand.write.login.ClientWrite;
import comand.write.login.LoginWrite;
import data.info.connectionjdbc.JDBCConnection;
import data.info.entity.Client;
import data.info.entity.Login;
import data.info.factorydaoorder.JDBCFactoryDao;
import data.info.factorydaoorder.DaoFactory;
/**
 * login   write and name , surname in base 
 * @author Sergey
 *
 */
public class LoginServlet implements ActionCommand {
	private static final Logger logger1 = Logger.getLogger(LoginServlet.class);
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		parseLogin( request,response);
		new CommandRedirectCustomer().execute(response);
	
		
	}
	/**
	 * create new client and login and write in base
	 * 
	 * @param request
	 * @param response
	 */
	public static void parseLogin(HttpServletRequest request,
			HttpServletResponse response) {
		JDBCConnection connection = JDBCConnection.getInstance();
		String login = request.getParameter("login");
		addCokie(login, response);
		String password = request.getParameter("password");
		Login newLogin = new Login(login, password);
		DaoFactory newDaoFactory = new JDBCFactoryDao(connection);
		LoginWrite writelog = new LoginWrite(newDaoFactory, newLogin);
		writelog.execute();
		String firstName = request.getParameter("firstName");
		String secondName = request.getParameter("secondName");
		Client newClient = new Client(firstName, secondName,
				newLogin.getIdLogin());
		ClientWrite writClient = new ClientWrite(newDaoFactory, newClient);
		writClient.execute();

	}

	/**
	 * add cookie to response
	 * 
	 * @param login
	 * @param response
	 */
	public static void addCokie(String login, HttpServletResponse response) {
		Date now = new Date();
		String timestamp = now.toString();
		Cookie cookie = new Cookie("logName", login);
		cookie.setMaxAge(365 * 24 * 60 * 60);
		response.addCookie(cookie);
	}

}
