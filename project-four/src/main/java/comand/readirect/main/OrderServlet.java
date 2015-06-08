package comand.readirect.main;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comand.readirect.login.CommandRedirectCustomer;
import comand.write.login.OrderWrite;

import data.info.connectionjdbc.JDBCConnection;
import data.info.entity.Order;
import data.info.factorydaoorder.JDBCFactoryDao;
import data.info.factorydaoorder.DaoFactory;
/**
 * order  write in base;
 * @author Sergey
 *
 */
public class OrderServlet implements ActionCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		parseLogin(request, response);
	}
	/**
	 * create new oder and write in base
	 * 
	 * @param request
	 * @param response
	 */
	public static void parseLogin(HttpServletRequest request,
			HttpServletResponse response) {
		JDBCConnection connection = JDBCConnection.getInstance();
		DaoFactory newDaoFactory = new JDBCFactoryDao(connection);
		String roomHotel = request.getParameter("roomHotel");
		String telephone = request.getParameter("telephone");
		String dateMonthIn = request.getParameter("monthIn");
		String dateDayIn = request.getParameter("dayIn");
		String dateMonthOut = request.getParameter("monthOut");
		String dateDayOut = request.getParameter("dayOut");
		LocalDate localDateIn = createDate(dateMonthIn, dateDayIn);
		LocalDate localDateOut = createDate(dateMonthOut, dateDayOut);
		String idlog = getIdLogin(request);
		Order newOrder = new Order( roomHotel, telephone,
				localDateIn, localDateOut, idlog);
		OrderWrite writelog = new OrderWrite(newDaoFactory, newOrder);
		writelog.execute();
		CommandRedirectCustomer customer = new CommandRedirectCustomer();
		customer.execute(response);
	}

	/**
	 * create LocalDate
	 */
	public static LocalDate createDate(String month, String day) {

		LocalDate local = null;
		int intDay = Integer.parseInt(day);
		int intMonth = Integer.parseInt(month);
		LocalDate currentlDate = LocalDate.now();
		if (currentlDate.getMonthValue() == 12
				&& currentlDate.getMonthValue() > intMonth) {
			local = LocalDate.of(currentlDate.getYear(), intMonth, intDay);
			local.plusYears(1);

		} else {
			local = LocalDate.of(currentlDate.getYear(), intMonth, intDay);

		}

		return local;

	}

	/**
	 * 
	 * @param newDaoFactory
	 *            factory dao
	 * @param request
	 *            HttpServlet
	 * @return id login client which to order room
	 */
	public static String getIdLogin(HttpServletRequest request) {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		String logName = "";
		if (session != null) {
			logName = (String) session.getAttribute("idlogName");
		}
		return logName;
	}
}
