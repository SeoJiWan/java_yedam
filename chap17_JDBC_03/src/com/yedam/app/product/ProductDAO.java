package com.yedam.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductDAO extends DAO {
	/*
	 * 필드
	 */
	// 싱글톤
	private static ProductDAO dao = null;
	
	
	/*
	 * 생성자
	 */
	// 싱글톤
	private ProductDAO() {}
	
	
	/*
	 * 메서드
	 */
	// 싱글톤 - 인스턴스 생성
	public static ProductDAO getProductDAO() {
		if (dao == null) {
			dao = new ProductDAO();
		}
		return dao;
	}
	
	// CRUD
	// 등록
	public void insert(Product product) {
		try {
			connect();
			String sql = "INSERT INTO product VALUES (product_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProdctName());
			pstmt.setInt(2, product.getProductPrice());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + "행이 삽입되었습니다.");
			}
			else {
				System.out.println("삽입되지 않았습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 수정 - 가격
	public void update(Product product) {
		try {
			connect();
			String sql = "UPDATE product SET product_price = ? WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductPrice());
			pstmt.setInt(2, product.getProductId());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + "행의 가격이 수정되었습니다.");
			}
			else {
				System.out.println("가격이 수정되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 삭제
	public void delete(int productId) {
		try {
			connect();
			String sql = "DELETE FROM product WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + "행이 삭제되었습니다.");
			}
			else {
				System.out.println("삭제되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 단건조회 - 제품번호
	public Product selectOne(int productId) {
		Product product = new Product();
		
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				product.setProductId(rs.getInt(1));
				product.setProdctName(rs.getString(2));
				product.setProductPrice(rs.getInt(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return product;
	}
	
	// 메서드 오버로딩
	// 단건조회 - 제품이름
	public Product selectOne(String productName) {
		Product product = new Product();
		
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				product.setProductId(rs.getInt(1));
				product.setProdctName(rs.getString(2));
				product.setProductPrice(rs.getInt(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return product;
	}
	
	// 전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();
		
		try {
			connect();
			String sql = "SELECT * FROM product";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProdctName(rs.getString(2));
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

}
