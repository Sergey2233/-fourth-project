package jsp.tag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import search.category.SearchCategory;
import data.info.connectionjdbc.JDBCConnection;
import data.info.entity.HotelRoom;
import data.info.factorydaoorder.JDBCFactoryDao;
import data.info.factorydaoorder.DaoFactory;

/**
 * table list room
 * 
 * @author Sergey
 *
 */
public class ListRoom extends TagSupport {
	private static final Logger logger1 = Logger.getLogger(ListRoom.class);

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		JDBCConnection con = JDBCConnection.getInstance();
		DaoFactory newDaoFactory = new JDBCFactoryDao(con);
		SearchCategory nameCategory = new SearchCategory(newDaoFactory);
		try {
			JspWriter out = pageContext.getOut();

			out.print(" <table id='tabl'><tr><th>номер комнаты</th><th>категория</th>"
					+ "<th>цена за одну ночь</th><th>дополнительные категория</th></tr>");
			ArrayList<HotelRoom> hotelRoomList = (ArrayList<HotelRoom>) newDaoFactory
					.createHotelRoomDao().findAll();
			for (HotelRoom hotel : hotelRoomList) {
				out.print("<tr><td>"
						+ hotel.getIdRoom()
						+ "</td>"
						+ "<td>"
						+ nameCategory.getCategoryName(hotel.getIdCategory())
						+ "</td>"
						+ "<td>"
						+ hotel.getCostOneNight()
						+ "</td>"
						+ "<td>"
						+ nameCategory.getCategoryName(hotel
								.getAdditionallyCategory()) + "</td></tr>");
			}
			out.print("</table>");
		} catch (IOException ioException) {
			logger1.error("Error: " + ioException.getMessage());
		}
		return SKIP_BODY;
	}

}
