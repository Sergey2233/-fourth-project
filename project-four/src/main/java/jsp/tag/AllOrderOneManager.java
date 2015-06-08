package jsp.tag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.log4j.Logger;
import data.info.entity.Order;


/**
 * all order one manager
 * 
 * @author Sergey
 *
 */
public class AllOrderOneManager extends TagSupport {
	private static final Logger logger1 = Logger
			.getLogger(AllOrderOneManager.class);

	private static final long serialVersionUID = 1L;
	private ArrayList<Order> listOrder1;

	@Override
	public int doStartTag() throws JspException {

		try {
			JspWriter out = pageContext.getOut();
			out.print("<table><tr><th>телефон</th>"
					+ "<th>категория</th><th>дата заселения</th><th>дата выселения</th><th>логин</th></tr>");

			for (Order order : listOrder1) {
				out.print("<tr><td>" + order.getTelephone() + "</td>" + "<td>"
						+ order.getCategoryRoom() + "</td>" + "<td>"
						+ order.getArrivalDate() + "</td>" + "<td>"
						+ order.getEvictionDate() + "</td>" + "<td>"
						+ order.getIdLogin() + "</td></tr>");
			}
			out.print("</table>");
		} catch (IOException ioException) {
			logger1.error("Error: " + ioException.getMessage());
		}
		return SKIP_BODY;
	}

	public ArrayList<Order> getListOrder1() {
		return listOrder1;
	}

	public void setListOrder1(ArrayList<Order> listOrder1) {
		this.listOrder1 = listOrder1;
	}
}
