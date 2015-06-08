package search.category;

import java.util.ArrayList;

import data.info.entity.Category;
import data.info.factorydaoorder.DaoFactory;

/**
 * search category name by id
 * 
 * @author Sergey
 *
 */
public class SearchCategory {
	/**
	 * factory dao
	 */
	private DaoFactory factory;

	/**
	 * initializes factory
	 * 
	 * @param factory
	 */
	public SearchCategory(DaoFactory factory) {
		this.factory = factory;
	}

	/**
	 * 
	 * @return name category by id category
	 */

	public String getCategoryName(int id) {
		String nameCategory = "";
		ArrayList<Category> listCategory = (ArrayList<Category>) factory
				.createCategoryDao().findAll();
		for (Category category : listCategory) {
			if (category.getIdCategory() == id) {
				return category.getNameCategory();
			}

		}
		return nameCategory;
	}

}
