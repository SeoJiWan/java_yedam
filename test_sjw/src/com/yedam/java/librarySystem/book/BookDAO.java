package com.yedam.java.librarySystem.book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.librarySystem.common.DAO;

public class BookDAO extends DAO {
	
	/*
	 * Field
	 */
	// single ton
	private static BookDAO bookDAO = null;

	
	/*
	 * Constructor
	 */
	// single ton
	private BookDAO() {}
	

	/*
	 * Method
	 */
	// single ton
	public static BookDAO getBookDAO() {
		if (bookDAO == null) {
			bookDAO = new BookDAO();
		}
		return bookDAO;
	}
	
	// CRUD
	// 등록
	public void insert(Book book) {
		try {
			connect();
			
			String sql = "INSERT INTO books (book_name, book_writer, book_content)"
						+ "VALUES (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getBookWriter());
			ps.setString(3, book.getBookContent());
			
			int result = ps.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + "행 삽입에 성공했습니다.");
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
	
	// 수정 - 대여 or 반납
	public void update(Book book) {
		try {
			connect();
			
			int curRental = book.getBookRental();
			
			String sql = "UPDATE books "
						+ "SET book_rental = ? "
						+ "WHERE book_name = ?";
			ps = conn.prepareStatement(sql);
			if (curRental == 0) {
				ps.setInt(1, 1);
			}
			else {
				ps.setInt(1, 0);
			}
			ps.setString(2, book.getBookName());
			
			int result = ps.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + "행 수정에 성공했습니다.");
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
	
	// 조회 - 대여가능
	public List<Book> selectRentalPossible() {
		List<Book> list = new ArrayList<Book>();
		try {
			connect();
			
			String sql = "SELECT * FROM books WHERE book_rental = 0";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				
				book.setBookName(rs.getString(1));
				book.setBookWriter(rs.getString(2));
				book.setBookContent(rs.getString(3));
				book.setBookRental(rs.getInt(4));
				
				list.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
	
	// 조회 - 특정내용
	public List<Book> selectByContent(String content) {
		List<Book> list = new ArrayList<Book>();
		try {
			connect();
			
			String sql = "SELECT * FROM books WHERE book_content like '%?%'";
			ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				
				book.setBookName(rs.getString(1));
				book.setBookWriter(rs.getString(2));
				book.setBookContent(rs.getString(3));
				book.setBookRental(rs.getInt(4));
				
				list.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
	
	// 전체조회
	public List<Book> selectAll() {
		List<Book> list = new ArrayList<Book>();
		try {
			connect();
			
			String sql = "SELECT * FROM books";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				
				book.setBookName(rs.getString(1));
				book.setBookWriter(rs.getString(2));
				book.setBookContent(rs.getString(3));
				book.setBookRental(rs.getInt(4));
				
				list.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
	
	// 단건조회 - 이름으로
	public Book selectOne(String name) {
		Book book = null;
		try {
			connect();
			
			String sql = "SELECT * FROM books WHERE book_name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				book = new Book();
				
				book.setBookName(rs.getString(1));
				book.setBookWriter(rs.getString(2));
				book.setBookContent(rs.getString(3));
				book.setBookRental(rs.getInt(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return book;
	}

}
