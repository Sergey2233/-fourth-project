package data.info.dao.realizationdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import data.info.connectionjdbc.JDBCConnection;
import data.info.dao.interfacedao.CategoryDao;
import data.info.entity.Category;

public class CategoryRealizationDao implements CategoryDao {
	private static final Logger logger1 = Logger
			.getLogger(ClienRealizationDao.class);

	/**
	 * connection jdbc
	 */
	private JDBCConnection conn;

	/*
	 * initialization connection with data base
	 * 
	 * @param conn
	 */

	public CategoryRealizationDao(JDBCConnection conn) {
		this.conn = conn;

	}

	/**
	 * 
	 * @return JDBCConnection
	 */
	public JDBCConnection getJDBCConnection() {
		return conn;
	}

	/**
	 * set new JDBCConnection
	 * 
	 * @param conn
	 */

	public void setConn(JDBCConnection conn) {
		this.conn = conn;
	}

	@Override
	public void create(Category category) {
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(
						"INSERT INTO category (name_category,discribe) "
								+ " VALUES(  ? , ? )",
						Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, category.getNameCategory());
				statement.setString(2, category.getDescription());
				statement.executeUpdate();
				ResultSet key = statement.getGeneratedKeys();
				int itemId = 0;
				if (key.next()) {
					itemId = key.getInt(1);
					category.setIdCategory(itemId);
				}
			} finally {
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			}

		} catch (Exception ex) {
			logger1.error(ex);
		}

	}

	@Override
	public Category find(int id) {
		Connection con = conn.getConnection();
		Category newCategory = new Category();
		PreparedStatement statement = null;
		try {
			try {
				statement = con
						.prepareStatement("SELECT * FROM category where id = ?");
				statement.setInt(1, id);
				ResultSet result2 = statement.executeQuery();
				while (result2.next()) {
					newCategory.setIdCategory(result2.getInt("id_category"));
					newCategory.setNameCategory(result2
							.getString("name_category"));
					newCategory.setDescription(result2.getString("discribe"));

				}
			} finally {
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			}

		} catch (Exception ex) {
			logger1.error(ex);
		}

		return newCategory;

	}

	@Override
	public List<Category> findAll() {
		Connection con = conn.getConnection();
		ArrayList<Category> categoryAll = new ArrayList<Category>();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement("SELECT * FROM category ");
				ResultSet result2 = statement.executeQuery();

				while (result2.next()) {
					Category newCategory = new Category();
					newCategory.setIdCategory(result2.getInt("id_category"));
					newCategory.setNameCategory(result2
							.getString("name_category"));
					newCategory.setDescription(result2.getString("discribe"));
					categoryAll.add(newCategory);

				}
			} finally {
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			}

		} catch (Exception ex) {
			logger1.error(ex);
		}

		return categoryAll;

	}

	@Override
	public void update(Category category) {
		String updateTableSQL = "UPDATE category SET"
				+ "name_category = ?,discribe = ?WHERE id_client = ?";
		Connection con = conn.getConnection();
		PreparedStatement statement = null;
		try {
			try {
				statement = con.prepareStatement(updateTableSQL);
				statement.setString(1, category.getNameCategory());
				statement.setString(2, category.getDescription());
				statement.setInt(3, category.getIdCategory());
				statement.executeUpdate();
			} finally {
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			}

		} catch (Exception ex) {
			logger1.error(ex);
		}

	}

	@Override
	public void delete(int id) {
		String deleteSQL = "DELETE FROM category WHERE id_client = ?";
		Connection con = conn.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			try {
				preparedStatement = con.prepareStatement(deleteSQL);
				preparedStatement.setInt(1, id);
				// execute delete SQL statement
				preparedStatement.executeUpdate();
			} finally {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (con != null) {
					con.close();
				}
			}
		} catch (SQLException e) {

			logger1.error(e);
		}

	}

}
