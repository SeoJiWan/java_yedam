package com.yedam.app.histroy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.yedam.app.common.DAO;

public class HistroyDAO extends DAO{

	/*
	 * 필드
	 */
	// single ton
	private static HistroyDAO histroyDAO = null;
	
	
	/*
	 * 생성자
	 */
	// single ton
	private HistroyDAO() {}
	
	
	/*
	 * 메서드
	 */
	// single ton -> create instance 
	public static HistroyDAO getHistroyDAO() {
		if (histroyDAO == null) {
			histroyDAO = new HistroyDAO();
		}
		return histroyDAO;
	}
	
	//// CRUD
	// 등록
	public void insert(History history) {
		try {
			connect();
			
			String sql = "INSERT INTO product_history VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductId());
			pstmt.setInt(2, history.getProductCategory());
			pstmt.setInt(3, history.getProductAmount());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + "행이 삽입");
			}
			else {
				System.out.println("삽입 안됨");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			disconnect();
		}
	}
	
	// 수정 - 수량
	public void update(History history) {
		try {
			connect();
			
			String sql = "UPDATE product_history SET product_amount = ? WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductAmount());
			pstmt.setInt(2, history.getProductId());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + "행이 수정");
			}
			else {
				System.out.println("수정 안됨");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			disconnect();
		}
	}
	
	// 삭제
	public void delete(int productId) {
		try {
			connect();
			
			String sql = "DELETE product_history WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + "행이 삭제");
			}
			else {
				System.out.println("삭제 안됨");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			disconnect();
		}
	}
	
	// 단건조회 - 각 상품에 대한 입고
	public int selectInAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) "
					+ "FROM product_history WHERE product_id = ? "
					+ "AND product_category = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return result;
	}
	
	// 단건조회 - 각 상품에 대한 출고량
	public int selectOutAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) FROM "
					+ "product_history WHERE product_id = ? "
					+ "AND product_category = 2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return result;
	}
	
	// 전체조회 - 전체 상품의 각 재고
	public Map<Integer, Integer> selectAllAmount() {
		// key : product_id, value : sum(product_amount)
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// 입고된 제품들의 수량 합 담을 map
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>(); // category : 1
		// 출고된 제품들의 수량 합 담을 map
		Map<Integer, Integer> outMap = new HashMap<Integer, Integer>();  // category : 2
		
		
		try {
			connect();
			
			// 각 제품에 따른 입고량과 출고량 쿼리
			String sql = "SELECT product_id, product_category, SUM(product_amount)"
					+ "FROM product_history GROUP BY product_id, product_category";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int category = rs.getInt(2);
				if (category == 1) {
					inMap.put(rs.getInt(1), rs.getInt(3));
				}
				else {
					outMap.put(rs.getInt(1), rs.getInt(3));
				}
			}
			
			Set<Integer> keySet = inMap.keySet();
			for (int key: keySet) {
				int inAmount = inMap.get(key);
				Integer outAmount = outMap.get(key);
				if (outAmount != null) {
					map.put(key, (inAmount - outAmount));
				}
				else {
					map.put(key, inAmount);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return map;
	
	}
		
	
	
	
	
	
	
	
}
