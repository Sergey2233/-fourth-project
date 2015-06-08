package jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagOrder extends TagSupport {

	private static final long serialVersionUID = 1L;
	String[] categoryO = { "SNGL", "DBL", "ETWIN", "4PAX", "3ADL", "Studio",
			"Suite", "Mini Suite", "Junior Suite", "Senior Suite",
			"Executive Suite", "King Suite", "Superior", "APT" };
	private String name;
	private String lastName;
	private String category;
	private String phon;
	private String date_of_depaerture;
	private String arrival_date;
	private String book;

	public String[] getCategoryO() {
		return categoryO;
	}

	public void setCategoryO(String[] categoryO) {
		this.categoryO = categoryO;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();

			pageContext.getOut().print("<input type = 'hidden' name='command' value= 'orderservlet'/><table id='tabl'>");
			pageContext.getOut().print(
					"<tr><td> " + category
							+ ":</td><td><select name='roomHotel'>");
			for (int i = 0; i < categoryO.length; i++) {
				pageContext.getOut().print(
						"<option value='" + categoryO[i] + "'>" + categoryO[i]
								+ "</option>");
			}

			pageContext
					.getOut()
					.print("</select></td></tr> <tr><td>"
							+ phon
							+ ":</td>"
							+ "<td><input type='text' name='telephone' required='required' /></td></tr> <tr>"
							+ "<td>" + arrival_date
							+ ":</td><td><select name='monthIn'>");
			for (int i = 1; i <= 12; i++) {
				pageContext.getOut().print(
						"<option value='" + i + "'>" + i + "</option>");
			}
			pageContext.getOut().print(
					"</select></td> <td><select name='dayIn'>");
			for (int i = 1; i <= 31; i++) {
				pageContext.getOut().print(
						"<option value='" + i + "'>" + i + "</option>");
			}
			pageContext.getOut().print(
					"</select></td></tr><tr><td>" + date_of_depaerture
							+ ":</td><td><select name='monthOut'>");
			for (int i = 1; i <= 12; i++) {
				pageContext.getOut().print(
						"<option value='" + i + "'>" + i + "</option>");
			}
			pageContext.getOut().print(
					"</select></td><td><select name='dayOut'>");
			for (int k = 1; k <= 31; k++) {
				pageContext.getOut().print(
						"<option value='" + k + "'>" + k + "</option>");
			}
			pageContext.getOut().print(
					"</select></td>	</tr><tr> <td><input type='submit' value ='"
							+ book + "' /></td></tr></table>");

		} catch (IOException ioException) {
			throw new JspException("Error: " + ioException.getMessage());
		}
		return SKIP_BODY;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPhon(String phon) {
		this.phon = phon;
	}

	public void setDate_of_depaerture(String date_of_depaerture) {
		this.date_of_depaerture = date_of_depaerture;
	}

	public void setArrival_date(String arrival_date) {
		this.arrival_date = arrival_date;
	}

	public void setBook(String book) {
		this.book = book;
	}

}