package com.yedam.app;

import java.util.List;

import com.yedam.app.histroy.History;
import com.yedam.app.histroy.HistroyDAO;
import com.yedam.app.product.Product;
import com.yedam.app.product.ProductDAO;

public class Main {
	
	public static void main(String[] args) {
		
//		List<Product> selectAll = ProductDAO.getProductDAO().selectAll();
//		selectAll.forEach(System.out::println);
//		
//		// test 용
//		History history = new History();
//		history.setProductId(1);
//		history.setProductCategory(1);
//		history.setProductAmount(1000);
//		
////		HistroyDAO.getHistroyDAO().insert(history);
////		HistroyDAO.getHistroyDAO().update(history);
////		HistroyDAO.getHistroyDAO().delete(1);
		
		new StockManagement();
	}

}
