package com.yedam.app.products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductsDAO extends DAO{
	
	/*
	 * Field
	 */
	private static ProductsDAO pDAO = null;
	

	/*
	 * Constructor
	 */
	private ProductsDAO() {}

	
	/*
	 * Method
	 */
	public static ProductsDAO getProductsDAO() {
		if (pDAO == null) {
			pDAO = new ProductsDAO();
		}
		return pDAO;
	}
	
	public void insert(Product product) {
		try {
			connect();
			
			String sql = "INSERT INTO products (product_id, product_name, product_price)"
						+ " VALUES (products_seq.nextval, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getProductPrice());
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(result + "행이 삽입되었습니다.");
			}
			else {
				System.out.println("행 삽입에 실패했습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 재고 수정
	public void updateStock(Product product) {
		try {
			connect();
			
			String sql = "UPDATE products SET product_stock = ?"
						+ " WHERE product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getProductStock());
			ps.setInt(2, product.getProductId());
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(result + "행이 수정되었습니다.");
			}
			else {
				System.out.println("행 수정에 실패했습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 수정 - 이름, 가격
	public void updateInfo(Product product) {
		try {
			connect();
			
			String sql = "UPDATE products SET product_name = ?, product_price =? WHERE product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getProductPrice());
			ps.setInt(3, product.getProductId());
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(result + "행이 수정되었습니다.");
			}
			else {
				System.out.println("행 수정에 실패했습니다.");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	
	public void delete(int productId) {
		try {
			connect();
			
			String sql = "DELETE FROM products WHERE product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(result + "행이 삭제되었습니다.");
			}
			else {
				System.out.println("행 삭제에 실패했습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
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
				product.setProductStock(rs.getInt(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return product;
	}
	
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
				product.setProductStock(rs.getInt(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return product;
	}
	
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		
		try {
			connect();
			
			String sql = "SELECT * FROM products ORDER BY product_id";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Product product = new Product();
				
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getInt(3));
				product.setProductStock(rs.getInt(4));
				
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	

}
