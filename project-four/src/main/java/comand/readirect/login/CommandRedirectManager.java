package comand.readirect.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import filterall.TypeClientCookie;
/**
 * redirect client Manager
 * @author Sergey
 *
 */
public class CommandRedirectManager implements CommandRedirectLog {
	private static final Logger logger1 = Logger
			.getLogger(TypeClientCookie.class);
	private Properties config;
	private InputStream inputStream;
	/**
	 * constructor  initialized properties
	 */
	public  CommandRedirectManager(){
	this.config = new Properties();
	this.inputStream = getClass().getClassLoader()
				.getResourceAsStream("redirect.properties");
		}

	@Override
	public void execute(ServletResponse response) {
		
		try {

			config.load(inputStream);
			((HttpServletResponse) response).sendRedirect(config
					.getProperty("manager.jsp"));
		} catch (FileNotFoundException e) {
			logger1.error(e);
		} catch (IOException e) {

			logger1.error(e);
		}

	}

}
