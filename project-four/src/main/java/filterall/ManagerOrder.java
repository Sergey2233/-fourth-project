package filterall;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import comand.read.dalist.DataOrderList;
import data.info.connectionjdbc.JDBCConnection;
import data.info.entity.Order;
import data.info.factorydaoorder.JDBCFactoryDao;
import data.info.factorydaoorder.DaoFactory;

/**
 * Servlet Filter implementation class ManagerOrder
 */
public class ManagerOrder implements Filter {
	private static final Logger logger1 = Logger.getLogger(ManagerOrder.class);

	/**
	 * Default constructor.
	 */
	public ManagerOrder() {
		super();
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
		getTypeClient(request);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

	/**
	 * return type client
	 * 
	 * @param request
	 * @return int 1 or 2
	 * @see CheckCorrectClient
	 */
	@SuppressWarnings("unchecked")
	public void getTypeClient(ServletRequest request) {
		JDBCConnection connection = JDBCConnection.getInstance();
		DaoFactory factoryDao = new JDBCFactoryDao(connection);
		DataOrderList oderList = new DataOrderList(factoryDao);
		ArrayList<Order> list = (ArrayList<Order>) oderList.execute();
		HttpSession session = ((HttpServletRequest) request).getSession(true);

		if (list != null) {
			if (session != null) {
				session.setAttribute("listOrder", list);
			}
		}

	}

}
