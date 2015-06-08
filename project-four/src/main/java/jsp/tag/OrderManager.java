package jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

/**
 * class manager form order
 *
 * @author Sergey
 *
 */
public class OrderManager extends TagSupport {
	private static final Logger logger1 = Logger.getLogger(OrderManager.class);

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();

			out.print("  <form action='..\\MainServlet' method='post'><table id='tabl'><tr>"
					+" <input type = 'hidden' name='command' value='calendar'/>"
					+ "<td>номер комнаты:</td><td><input type='text' name='idroom' required='required' /></td> </tr>"
					+ "<tr><td> логин:</td><td><input type='text' name='logdName' required='required' /></td></tr>"
					+ "<tr><td>дата заезда:</td><td><input type='text' name='errivelDateYear'  /></td>"
					+ "<td><input type='text' name='errivelDateMonth'/></td> "
					+ "<td><input type='text' name='errivelDateDay'/></td></tr>"
					+ "<tr><td>дата выеезда:</td><td><input type='text' name='evictionDateYear'+"
					+ " /></td><td><input type='text' name='evictionDateMonth'"
					+ " /></td> <td><input type='text' name='evictionDateDay'"
					+ " /></td></tr><tr><td>цена проживание:</td>"
					+ "<td><input type='text' name='cost' required='required' /></td>"
					+ "</tr><tr><td><input type='submit' value='подтвиржение' /></td>"
					+ "</tr></table></form>");

		} catch (IOException ioException) {
			logger1.error("Error: " + ioException.getMessage());
		}
		return SKIP_BODY;
	}
}
