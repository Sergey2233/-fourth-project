package comand.read.dalist;

import java.util.ArrayList;

import data.info.connectionjdbc.JDBCConnection;
import data.info.entity.Category;
import data.info.factorydaoorder.JDBCFactoryDao;
import data.info.factorydaoorder.DaoFactory;

/**
 * access data list category
 * 
 * @author Sergey
 *
 */
public class DataCategoryList {
	/*
	 * list category
	 */
	private ArrayList<Category> categoryList;

	/*
	 * empty constructor
	 */
	public DataCategoryList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return list category
	 */
	public ArrayList<Category> getCategoryList() {
		return categoryList;
	}

	/**
	 * set new category list
	 */
	public void setCategoryList() {
		JDBCConnection con = JDBCConnection.getInstance();
		DaoFactory factory = new JDBCFactoryDao(con);
		this.categoryList = (ArrayList<Category>) factory.createCategoryDao()
				.findAll();
	}

}
