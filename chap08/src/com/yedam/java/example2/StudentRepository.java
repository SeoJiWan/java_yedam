package com.yedam.java.example2;

public class StudentRepository implements Access {

	// 필드
	private static StudentRepository studentRepository = new StudentRepository(); // 싱글 톤
	private Student[] dataList;
	private int listIdx;

	// 생성자
	private StudentRepository() { // private 으로 외부에서 new 연산자를 통한 인스턴스 생성을 막음. --> 싱글 톤
		init();
	}

	//// 메서드
	// 초기화
	private void init() {
		dataList = new Student[100];
		listIdx = -1;
	}

	// 싱글톤으로 인스턴스 생성
	public static StudentRepository getStudentRepository() { // 메소드를 활용하여 필드(인스턴스 생성)에 접근
		return studentRepository;
	}

	// 삽입
	@Override
	public void insert(Student student) {
		dataList[++listIdx] = student;
	}

	// 수정
	@Override
	public void update(Student student) {
		for (int i = 0; i <= listIdx; i++) {
			if (dataList[i].getStudentId() == student.getStudentId()) {
				dataList[i] = student;
			}
		}
	}

	// 삭제
	@Override
	public void delete(int studentId) {
		for (int i = 0; i <= listIdx; i++) {
			if (dataList[i].getStudentId() == studentId) {
				dataList[i] = null;
			}
		}

		cleanDataList();
	}

	// 삭제 후 데이터 정리
	private void cleanDataList() {
		// 기존 데이터 -> 임시변수
		Student[] tmpList = dataList;
		int tmpIdx = listIdx;

		// 기존 필드 초기화
		init();

		// 임시변수에서 데이터만 기존 필드로 복사
		for (int i = 0; i <= tmpIdx; i++) {
			if (tmpList[i] != null) {
				dataList[++listIdx] = tmpList[i];
			}
		}
	}

	// 전체조회
	@Override
	public Student[] selectAll() {
		Student[] list = new Student[listIdx + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	// 단일조회
	@Override
	public Student selectOne(int studentId) {
		Student selected = null;
			for (int i = 0; i <= listIdx; i++) {
				if (dataList[i].getStudentId() == studentId) {
					selected = dataList[i];
				}
			}

		return selected;
	}

}
