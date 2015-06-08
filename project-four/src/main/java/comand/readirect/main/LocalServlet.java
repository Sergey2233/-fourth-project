package comand.readirect.main;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;
/**
 * local internationalization 
 * @author Sergey
 *
 */
public class LocalServlet implements ActionCommand {
	private static final Logger logger1 = Logger.getLogger(LocalServlet.class);
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		getChack(request, response);
		redirect(request, response);

	}

	/**
	 * check local language and add local in session
	 */
	public void getChack(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = (request.getSession(true));
		String local = request.getParameter("loc");
		Cookie cookie = new Cookie("local", local);
		response.addCookie(cookie);
		Locale locale = new Locale(local);
		Config.set(session, Config.FMT_LOCALE, locale);

	}

	/**
	 * add cookie to local
	 * 
	 * @param login
	 * @param response
	 */
	public static void addCokie(String local, HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("local")) {
					cookie.setValue(local);
				}
			}

		} else {

			Cookie cookie1 = new Cookie("local", local);
			cookie1.setMaxAge(365 * 24 * 60 * 60);
			response.addCookie(cookie1);
		}

	}

	/**
	 * redirect page which come request
	 * 
	 * @param request
	 * @param response
	 */

	public void redirect(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = (request.getSession(true));
		String page = (String) session.getAttribute("page");
		try {
			response.sendRedirect(page);
		} catch (IOException e1) {
			logger1.error(e1);
		}
	}
}
