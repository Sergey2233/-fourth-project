package filterall;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import comand.readirect.login.CommandRedirectCustomer;
import comand.readirect.login.CommandRedirectManager;
import comand.readirect.login.CommandRedirectSystemManager;
import search.log.CheckHaveLogin;
import data.info.connectionjdbc.JDBCConnection;
import data.info.factorydaoorder.JDBCFactoryDao;
import data.info.factorydaoorder.DaoFactory;

/**
 * check cookie what client enter site Servlet Filter implementation class
 * TypeClient
 */
public class TypeClientCookie implements Filter {
	private static final Logger logger1 = Logger
			.getLogger(TypeClientCookie.class);

	/**
	 * Default constructor.
	 */
	public TypeClientCookie() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		redirect1(request, response);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

	protected void redirect1(ServletRequest request, ServletResponse response) {
		int typeClientSite = getTypeClient(request);
		redirectJspClient(response, typeClientSite);
	}

	/**
	 * redirect on page client in addiction client
	 * 
	 * @param response
	 * @param typeClientSite
	 */
	public void redirectJspClient(ServletResponse response, int typeClientSite) {

		switch (typeClientSite) {
		case 1:
			new CommandRedirectManager().execute(response);
			break;
		case 2:
			new CommandRedirectSystemManager().execute(response);
			break;
		case 0:
			new CommandRedirectCustomer().execute(response);
			break;

		}

	}

	/**
	 * return type client
	 * 
	 * @param request
	 * @return int 1 or 2
	 * @see CheckCorrectClient
	 */
	public int getTypeClient(ServletRequest request) {
		JDBCConnection connection = JDBCConnection.getInstance();
		DaoFactory factoryDao = new JDBCFactoryDao(connection);
		CheckHaveLogin checkClient = new CheckHaveLogin(factoryDao);
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		int typeClientSite = 0;
		Cookie[] cookies = ((HttpServletRequest) request).getCookies();

		typeClientSite = checkCookie(checkClient, session, typeClientSite,
				cookies);

		return typeClientSite;
	}

	/**
	 * check cookie on login and end select type client
	 * 
	 * @param checkClient
	 * @param session
	 * @param typeClientSite
	 * @param cookies
	 * @param resourceLocal
	 * @return
	 */
	public int checkCookie(CheckHaveLogin checkClient, HttpSession session,
			int typeClientSite, Cookie[] cookies) {
		if (cookies != null) {
			for (Cookie cookie : cookies) {

				if (cookie.getName().equals("logName")) {

					if (session != null) {
						session.setAttribute("idlogName", cookie.getValue());
					}
					typeClientSite = checkClient.checkTypeClient(cookie
							.getValue());
					break;
				}
			}

		}
		return typeClientSite;
	}

}
