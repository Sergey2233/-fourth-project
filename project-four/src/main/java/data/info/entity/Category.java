package data.info.entity;

public class Category {
 /**
  * id category  
  */
	private int idCategory;
	private String nameCategory;
	private String description;
	/**
	 * empty constructor
	 */
	public Category() {
		super();
	
	}
	/**
	 * 
	 * @param idCategory id category 
	 * @param nameCategory name category
	 * @param description description 
	 */
	public Category( String nameCategory, String description) {
		super();
		this.nameCategory = nameCategory;
		this.description = description;
	}
	
	/**
	 *  
	 * @return id category
	 */
	public int getIdCategory() {
		return idCategory;
	}
	/**
	 * set new category
	 * @param idCategory
	 */
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	/**
	 * 
	 * @return name category
	 */
	public String getNameCategory() {
		return nameCategory;
	}
	/**
	 * set new name category 
	 * @param nameCategory
	 */
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	/**
	 * 
	 * @return description category
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * set new description 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	} 
	
	
}