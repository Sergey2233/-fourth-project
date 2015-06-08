package filterall;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;


/**
 * Servlet Filter implementation class LocalFilter
 */
@WebFilter("/LocalFilter")
public class LocalFilter implements Filter {
	private static final Logger logger1 = Logger.getLogger(LocalFilter.class);

	/**
	 * Default constructor.
	 */
	public LocalFilter() {
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
		getChack(request, response);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * check local language and add local in session
	 */
	public void getChack(ServletRequest request, ServletResponse response) {
		HttpSession session = (((HttpServletRequest) request).getSession(true));
		String local = request.getParameter("loc");

		Locale locale = new Locale(local);
		Config.set(session, Config.FMT_LOCALE, locale);

	}

	/**
	 * add cookie to local
	 * 
	 * @param login
	 * @param response
	 */
	public static void addCokie(String local, ServletRequest request,
			ServletResponse response) {
		Cookie[] cookies = ((HttpServletRequest) request).getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("local")) {
					cookie.setValue(local);
				}
			}

		} else {

			Cookie cookie1 = new Cookie("local", local);
			cookie1.setMaxAge(365 * 24 * 60 * 60);
			((HttpServletResponse) response).addCookie(cookie1);
		}

	}
}
