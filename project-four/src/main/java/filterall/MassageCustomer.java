package filterall;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import search.log.CheckHaveLogin;
import comand.read.dalist.DataMessageList;
import comand.read.data.DataIdLogin;
import data.info.connectionjdbc.JDBCConnection;
import data.info.entity.Message;
import data.info.factorydaoorder.JDBCFactoryDao;
import data.info.factorydaoorder.DaoFactory;

/**
 * Servlet Filter implementation class MassageCustomer
 */
@WebFilter("/MassageCustomer")
public class MassageCustomer implements Filter {
	private static final Logger logger1 = Logger
			.getLogger(TypeClientCookie.class);

	/**
	 * Default constructor.
	 */
	public MassageCustomer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		getTypeClient(request);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * return type client
	 * 
	 * @param request
	 * @return int 1 or 2
	 * @see CheckCorrectClient
	 */
	public void getTypeClient(ServletRequest request) {
		JDBCConnection connection = JDBCConnection.getInstance();
		DaoFactory factoryDao = new JDBCFactoryDao(connection);
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		String login = (String) session.getAttribute("idlogName");
		if (login != null) {
			DataIdLogin dataidLogin = new DataIdLogin(factoryDao, login);
			int idLogin = dataidLogin.execute();
			DataMessageList datamessagelist = new DataMessageList(factoryDao,
					idLogin);
			@SuppressWarnings("unchecked")
			ArrayList<Message> listMessage = (ArrayList<Message>) datamessagelist
					.execute();
			if (session != null) {
				session.setAttribute("messagelist", listMessage);
			}
		}
	}

}
