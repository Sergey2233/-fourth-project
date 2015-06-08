package jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import filterall.TypeClientCookie;

/**
 * class Registration for taglib regist for define clients site
 * 
 * @author Sergey
 *
 */
public class Registration extends TagSupport {
	private static final Logger logger1 = Logger.getLogger(Registration.class);

	private static final long serialVersionUID = 1L;
	private String enter;

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();

			out.print("  <form action='..\\MainServlet' method='post'>"
					+" <input type = 'hidden' name='command' value='athentication'/>"
					+ "<table id='tabl'><tr><td><input type='text' "
					+ "name='logName' required='required' /></td>"
					+ "<td><input type='password' name='password'"
					+ " required='required' /></td> <td><input type='submit'"
					+ " value='" + enter + "' /></td></tr></table>"
					+ " </form>  ");

		} catch (IOException ioException) {
			logger1.error("Error: " + ioException.getMessage());
		}
		return SKIP_BODY;
	}

	public void setEnter(String enter) {
		this.enter = enter;
	}

}
