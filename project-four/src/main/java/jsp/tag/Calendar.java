package jsp.tag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import search.loginname.SearchNameLogin;
import data.info.connectionjdbc.JDBCConnection;
import data.info.entity.AllocationCalendarsRooms;
import data.info.factorydaoorder.JDBCFactoryDao;
import data.info.factorydaoorder.DaoFactory;
/**
 * table calendar 
 * @author Sergey
 *
 */
public class Calendar extends TagSupport {
	private static final Logger logger1 = Logger.getLogger(Calendar.class);

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		JDBCConnection con = JDBCConnection.getInstance();
		DaoFactory newDaoFactory = new JDBCFactoryDao(con);
		try {
			JspWriter out = pageContext.getOut();
			out.print("<table id='tabl'><tr><th>номер комнаты</th><th>клиент</th>"
					+ "<th>дата заезда</th><th>дата выезда</th><th>цена проживания</th></tr>");
			ArrayList<AllocationCalendarsRooms> listCalendar = (ArrayList<AllocationCalendarsRooms>) newDaoFactory
					.creatCalendarRoomsDao().findAll();
			SearchNameLogin serchNameLogin = new SearchNameLogin(newDaoFactory);
			for (AllocationCalendarsRooms calendar : listCalendar) {
				out.print("<tr><td>" + calendar.getIdRoom() + "</td>" + "<td>"
						+ serchNameLogin.getlogName(calendar.getIdClient())
						+ "</td>" + "<td>" + calendar.getArrivalDate()
						+ "</td>" + "<td>" + calendar.getEvictionDate()
						+ "</td>" + "<td>" + calendar.getCost() + "</td>"
						+ "</tr>");
			}
			out.print("</table>");

		} catch (IOException ioException) {
			logger1.error("Error: " + ioException.getMessage());
		}
		return SKIP_BODY;
	}

}
