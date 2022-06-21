package com.yedam.app.deal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ReceivingGoodsDAO extends DAO{
	/*
	 * Field
	 */
	private static ReceivingGoodsDAO dao = null;

	
	/*
	 * Constructor
	 */
	private ReceivingGoodsDAO() {}

	
	/*
	 * Method
	 */
	public static ReceivingGoodsDAO getReceivingGoodsDAO() {
		if (dao == null) {
			dao = new ReceivingGoodsDAO();
		}
		return dao;
	}
	
	//등록
	public void insert(DealInfo info) {
		try {
			connect();
			String sql = "INSERT INTO receiving_goods (product_id, product_amount) "
					+ "VALUES (?, ?)";
			ps = conn.prepareStatement(sql);
			int result = ps.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + " 행 삽입에 성공했습니다.");
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
	
	//단건조회 - 입고내역 존재유무
	public boolean selectInfo(int productId) {
		boolean isSelected = false;
		
		try {
			connect();
			String sql = "SELECT count(*) AS cnt FROM receiving_goods "
						+ "WHERE product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				int cnt = rs.getInt("cnt");
				if (cnt > 0) {
					isSelected = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return isSelected;
	}
	
	//단건조회 - 입고수량
	public int selectAmount(int productId) {
		int amount = 0;
		try {
			connect();
			String sql = "SELECT NVL(SUM(product_amount), 0) as sum FROM receiving_goods "
						+ "WHERE product_id = ?";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				amount = rs.getInt("sum");
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return amount;
	}
	
	//전체조회 - 현재까지 입고된 내역
	public List<DealInfo> selectAll() {
		List<DealInfo> list = new ArrayList<>();
		
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount "
						+ "FROM products p "
						+ "JOIN receiving_goods r ON (p.product_id = r.product_id) "
						+ "ORDER BY r.deal_date";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate(1));
				info.setProductId(rs.getInt(2));
				info.setProductName(rs.getString(3));
				info.setProductAmount(rs.getInt(4));
				
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//전체조회 - 해당 날짜에 입고된 내역
	public List<DealInfo> selectAll(Date date) {
		List<DealInfo> list = new ArrayList<>();
		
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount "
						+ "FROM products p "
						+ "JOIN receiving_goods r ON (p.product_id = r.product_id) "
						+ "WHERE deal_date = ? "
						+ "ORDER BY r.deal_date";
			ps = conn.prepareStatement(sql);
			ps.setDate(1, date);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate(1));
				info.setProductId(rs.getInt(2));
				info.setProductName(rs.getString(3));
				info.setProductAmount(rs.getInt(4));
				
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//전체조회 - 해당 제품의 입고된 내역
	public List<DealInfo> selectAll(int productId) {
		List<DealInfo> list = new ArrayList<>();
		
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount "
						+ "FROM products p "
						+ "JOIN receiving_goods r ON (p.product_id = r.product_id) "
						+ "WHERE product_id = ? "
						+ "ORDER BY r.deal_date";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate(1));
				info.setProductId(rs.getInt(2));
				info.setProductName(rs.getString(3));
				info.setProductAmount(rs.getInt(4));
				
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
