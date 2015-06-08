package comand.readirect.main;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comand.readirect.login.CommandRedirectSystemManager;
import comand.write.login.LoginWrite;
import comand.write.login.PersonnelWrite;
import data.info.connectionjdbc.JDBCConnection;
import data.info.entity.Login;
import data.info.entity.Personnel;
import data.info.factorydaoorder.JDBCFactoryDao;
import data.info.factorydaoorder.DaoFactory;

public class AddPersonnel implements ActionCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		parseLogin(request, response);
		CommandRedirectSystemManager systemManager = new CommandRedirectSystemManager();
		systemManager.execute(response);
		
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
		String firstName = request.getParameter("nameP");
		String secondName = request.getParameter("secondNameP");
		String yearB = request.getParameter("PDateYear");
		String monthB = request.getParameter("PDateMonth");
		String dayB = request.getParameter("PDateDay");
		String seriesPas = request.getParameter("seriesPas");
		String post = request.getParameter("post");
		String yearStart = request.getParameter("stDateYear");
		String monthStart = request.getParameter("stDateMonth");
		String dayStart = request.getParameter("stDateDay");
		String address = request.getParameter("address");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		LocalDate locB = createDate(yearB, monthB, dayB);
		LocalDate locStart = createDate(yearStart, monthStart, dayStart);
		Login newlogin = new Login(login, password);
		LoginWrite loginWrit = new LoginWrite(newDaoFactory, newlogin);
		loginWrit.execute();
		Personnel personnel = new Personnel(firstName, secondName, locB,
				seriesPas, newlogin.getIdLogin(), post, locStart, null, address);
		PersonnelWrite perWrite = new PersonnelWrite(newDaoFactory, personnel);
		perWrite.execute();

	}

	/**
	 * create LocalDate
	 */
	public static LocalDate createDate(String year, String month, String day) {
		int intyear = Integer.parseInt(year);
		int intDay = Integer.parseInt(day);
		int intMonth = Integer.parseInt(month);
		LocalDate local = LocalDate.of(intyear, intMonth, intDay);
		return local;
	}


}
