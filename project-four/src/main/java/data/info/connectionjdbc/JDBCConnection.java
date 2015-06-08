package data.info.connectionjdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;


/**
 * connection pull with date base
 * 
 * @author Admin
 */
public class JDBCConnection {
	private static final Logger logger1 = Logger
			.getLogger(JDBCConnection.class);

	/**
	 * empty constructor
	 */
	private JDBCConnection() {

	}

	/**
	 * object JDBCConnection
	 */
	private static JDBCConnection instance;

	/**
	 * 
	 * @return single object JDBCConnection
	 */
	public static JDBCConnection getInstance() {
		if (instance == null) {
			instance = new JDBCConnection();
		}
		return instance;
	}

	/**
	 * 
	 * @return connection witch base 
	 */
	public Connection getConnection() {
		try {

			InitialContext context = new InitialContext();
			Properties config = new Properties();
			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream("connection.properties");
			config.load(inputStream);
            DataSource ds = (DataSource) context.lookup(config
					.getProperty("jdbc.connection"));
			return ds.getConnection();
		} catch (NamingException ex) {
			logger1.error(ex);
		} catch (SQLException exx) {
			logger1.error(exx);
		} catch (FileNotFoundException e) {
			logger1.error(e);
		} catch (IOException e) {
			logger1.error(e);
		}
		return null;
	}

}
