package practice.jdbc_03_product.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import practice.jdbc_03_product.common.DAO;

public class ProductDAO extends DAO {

	/*
	 * Field
	 */
	// single ton
	private static ProductDAO dao = null;

	/*
	 * Constructor
	 */
	// single ton
	private ProductDAO() {
	}

	/*
	 * Method
	 */
	// single ton
	public static ProductDAO getProductDAO() {
		if (dao == null) {
			dao = new ProductDAO();
		}
		return dao;
	}

	//// CRUD
	// insert in DB
	public void insert(Product product) {
		try {
			connect();
			String sql = "INSERT INTO products VALUES (pro_seq.nextval, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getProductPrice());

			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println(result + "행이 삽입되었습니다.");
			} else {
				System.out.println("행 삽입에 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// update price in DB
	public void update(Product product) {
		try {
			connect();
			String sql = "UPDATE products SET product_price = ? WHERE product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getProductPrice());
			ps.setInt(2, product.getProductId());

			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println(result + "행이 수정되었습니다.");
			} else {
				System.out.println("행 수정에 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// delete in DB
	public void delete(int productId) {
		try {
			connect();
			String sql = "DELETE products WHERE product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);

			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println(result + "행이 삭제되었습니다.");
			} else {
				System.out.println("행 삭제에 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// select all in DB
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();

		try {
			connect();
			String sql = "SELECT * FROM products";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getInt(3));

				list.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	// select one by id in DB
	public Product selectOne(int productId) {
		Product product = null;

		try {
			connect();
			String sql = "SELECT * FROM products WHERE product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);

			rs = ps.executeQuery();

			if (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getInt(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return product;
	}

	// select one by name in DB
	public Product selectOne(String productName) {
		Product product = null;

		try {
			connect();
			String sql = "SELECT * FROM products WHERE product_name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, productName);

			rs = ps.executeQuery();

			if (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getInt(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return product;
	}
}
