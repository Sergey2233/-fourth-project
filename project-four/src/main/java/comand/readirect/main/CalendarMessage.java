package comand.readirect.main;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import comand.read.data.DataIdLogin;
import comand.readirect.login.CommandRedirectManager;
import comand.write.login.CalendarWrite;
import comand.write.login.MessageWrite;
import data.info.connectionjdbc.JDBCConnection;
import data.info.entity.AllocationCalendarsRooms;
import data.info.entity.Message;
import data.info.factorydaoorder.JDBCFactoryDao;
import data.info.factorydaoorder.DaoFactory;
/**
 * calendar message 
 * @author Sergey
 *
 */
public class CalendarMessage implements ActionCommand {
	private static final Logger logger1 = Logger
			.getLogger(CalendarMessage.class);
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		addMassage(request, response);
		new CommandRedirectManager().execute(response);
	}
	/**
	 * create new calendar data and message and write in base
	 * 
	 * @param request
	 * @param response
	 */
	public static void addMassage (HttpServletRequest request,
			HttpServletResponse response) {
		boolean registration = false;
		JDBCConnection connection = JDBCConnection.getInstance();
		DaoFactory newDaoFactory = new JDBCFactoryDao(connection);
		int idRoom = Integer.parseInt(request.getParameter("idroom"));
		DataIdLogin idlogin = new DataIdLogin(newDaoFactory,
				request.getParameter("logdName"));
		int idLog = idlogin.execute();
		Double cost = 0.0;
		if (!(request.getParameter("errivelDateYear").equals(""))) {
			logger1.info("ififififififiififififiififififififiif");
			LocalDate dateArrivel = LocalDate.of(
					Integer.parseInt(request.getParameter("errivelDateYear")),
					Integer.parseInt(request.getParameter("errivelDateMonth")),
					Integer.parseInt(request.getParameter("errivelDateDay")));
			LocalDate dateEviction = LocalDate
					.of(Integer.parseInt(request
							.getParameter("evictionDateYear")),
							Integer.parseInt(request
									.getParameter("evictionDateMonth")),
							Integer.parseInt(request
									.getParameter("evictionDateDay")));

			cost = Double.parseDouble(request.getParameter("cost"));

			AllocationCalendarsRooms calendar = new AllocationCalendarsRooms(
					idRoom, idLog, dateArrivel, dateEviction, cost);
			CalendarWrite calendarWrite = new CalendarWrite(newDaoFactory,
					calendar);
			calendarWrite.execute();
			registration = true;
		} else {
			registration = false;
		}
		Message message = new Message(cost, registration, idLog, idRoom);
		MessageWrite messageWrite = new MessageWrite(newDaoFactory, message);
		messageWrite.execute();

	}
}
