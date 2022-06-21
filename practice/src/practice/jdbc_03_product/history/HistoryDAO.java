package practice.jdbc_03_product.history;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import practice.jdbc_03_product.common.DAO;

public class HistoryDAO extends DAO {

	/*
	 * Field
	 */
	// single ton
	private static HistoryDAO dao = null;

	/*
	 * Constructor
	 */
	// single ton
	private HistoryDAO() {
	}

	/*
	 * Method
	 */
	// single ton - create instance by method
	public static HistoryDAO getHistoryDAO() {
		if (dao == null) {
			dao = new HistoryDAO();
		}
		return dao;
	}

	//// CRUD
	// insert in DB
	public void insert(History history) {
		try {
			connect();

			String sql = "INSERT INTO products_history VALUES (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, history.getProductId());
			ps.setString(2, history.getProductCategory());
			ps.setInt(3, history.getProductAmount());

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

	// update in DB
	public void udpate(History history) {
		try {
			connect();

			String sql = "UPDATE products_history SET product_amount = ? WHERE product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, history.getProductAmount());
			ps.setInt(2, history.getProductId());

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

			String sql = "DELETE products_history WHERE product_id = ?";
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
	
	// select all product's stock in DB
	public Map<Integer, Integer> selectAllAmount() {
		// key : productId,  value : productAmount
		Map<Integer, Integer> finalMap = new HashMap<Integer, Integer>(); // final product's stock
		// income product's stock
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>(); // status is IN
		// export product's stock
		Map<Integer, Integer> exMap = new HashMap<Integer, Integer>(); // status is EX
		
		
		try {
			connect();
			
			String sql = "SELECT product_id, product_category, SUM(product_amount) FROM products_history GROUP BY product_id, product_category"; 
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				if (rs.getString(2).equals("IN")) {
					inMap.put(rs.getInt(1), rs.getInt(3));
				}
				else {
					exMap.put(rs.getInt(1), rs.getInt(3));
				}
			}
			
			Set<Integer> keySet = inMap.keySet();
			for (Integer inKey : keySet) {
				
				if (exMap.containsKey(inKey)) {
					finalMap.put(inKey, inMap.get(inKey) - exMap.get(inKey));
				}
				else {
					finalMap.put(inKey, inMap.get(inKey));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return finalMap;
	}
	
//	// select id, name, price, stock
//		public Info selectOne() {
//			try {
//				connect();
//				
//				String sql = "SELECT p.product_id, p.product_name, p.product_price, h.product_amount FROM products p JOIN products_history ON (p.product_id = h.product_id)";
//				ps = conn.prepareStatement(sql);
//			} catch (SQLException e) {
//				// TODO: handle exception
//			}
//		}

}
