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
 * command redirect other SystemManager
 * @author Sergey
 *
 */
public class CommandRedirectSystemManager implements CommandRedirectLog {
	private static final Logger logger1 = Logger.getLogger(TypeClientCookie.class);
	private Properties config;
	private InputStream inputStream;
	/**
	 * constructor  initialized properties
	 */
	public  CommandRedirectSystemManager(){
	this.config = new Properties();
	this.inputStream = getClass().getClassLoader()
				.getResourceAsStream("redirect.properties");
		}

		@Override
		public void execute( ServletResponse response) {
			
		try {
			
			 config.load(inputStream);
				((HttpServletResponse) response).sendRedirect(config.getProperty("managerSite.jsp"));
		} catch (FileNotFoundException e) {
			logger1.error(e);
		} catch (IOException e) {
		
			logger1.error(e);
		}
		
	   
		}
	}


