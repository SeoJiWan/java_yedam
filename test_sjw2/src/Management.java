
import java.util.List;
import java.util.Scanner;
import book.Book;
import book.BookDAO;


public class Management {

	/*
	 * Field
	 */
	private Scanner sc = new Scanner(System.in);
	private BookDAO dao = BookDAO.getBookDAO();
	

	/*
	 * Constructor
	 */
	public Management() {
		
		while (true) {
			printMenu();
			
			int menuNo = selectMenu();
			
			if (menuNo == 1) {
				// 전제조회
				findAllBooks();
			}
			else if (menuNo == 2) {
				// 단건조회
				findOneBook();
			}
			else if (menuNo == 3) {
				// 내용검색
				findBookByKeyword();
			}
			else if (menuNo == 4) {
				// 대여가능
				checkRentalPossible();
			}
			else if (menuNo == 5) {
				// 책 대여
				libraryService();
			}
			else if (menuNo == 6) {
				// 책 반납
				libraryService();
			}
			else if (menuNo == 7) {
				// 책 등록
				registerBook();
			}
			else if (menuNo == 9) {
				// 종료
				exit();
				break;
			}
			else {
				showInputError();
			}
		}
	}
	

	/*
	 * Method
	 */
	//// 주요 메서드
	// 메뉴출력
	private void printMenu() {
		System.out.println("=============================================================================");
		System.out.println("1.전체조회 | 2.단건조회 | 3.내용검색 | 4.대여가능 | 5.책 대여 | 6.책 반납 | 7.책 등록 | 9.종료");
		System.out.println("=============================================================================");
	}
	
	// 메뉴 선택
	private int selectMenu() {
		System.out.print("선택 >> ");
		return Integer.parseInt(sc.nextLine());
	}
	
	// 전체 조회
	private void findAllBooks() {
		List<Book> list = dao.selectAll();
		list.forEach(System.out::println);
	}
	
	// 단건 조회
	private void findOneBook() {
		String bookName = inputName();
		
		Book book = dao.selectOne(bookName);
		if (book != null) {
			System.out.println(book);
		}
		else {
			System.out.println(bookName + " 책은 등록되어 있지 않습니다.");
		}
	}
	
	// 내용 검색
	private void findBookByKeyword() {
		String bookKeyword = inputKeyword();
		
		List<Book> book = dao.selectByContent(bookKeyword);
		book.forEach(System.out::println);
	}
	
	// 대여 가능
	private void checkRentalPossible() {
		List<Book> list = dao.selectRentalPossible();
		list.forEach(System.out::println);
	}
	
	// 책 대여 or 반납
	private void libraryService() {
		String bookName = inputName();
		Book book = dao.selectOne(bookName);
		
		dao.update(book);
	}
	
	// 책 등록
	private void registerBook() {
		Book book = inputBookInfo();
		dao.insert(book);
	}
	
	// 종료
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	// 입력 에러
	private void showInputError() {
		System.out.println("메뉴를 확인해 주세요");
	}
	
	//// 부가메서드
	// 책 제목 입력
	private String inputName() {
		System.out.print("책제목 >> ");
		return sc.nextLine();
	}
	
	// 책 키워드 입력
	private String inputKeyword() {
		System.out.print("검색내용 >> ");
		return sc.nextLine();
	}
	
	// 책 정보 입력
	private Book inputBookInfo() {
		Book book = new Book();
		
		System.out.print("책제목 >> ");
		book.setBookName(sc.nextLine());
		System.out.print("저자명 >> ");
		book.setBookWriter(sc.nextLine());
		System.out.print("내용 >> ");
		book.setBookContent(sc.nextLine());

		return book;
	}
}
