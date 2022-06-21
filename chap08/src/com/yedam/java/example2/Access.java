package com.yedam.java.example2;

// 저장소에 대해 사용방법을 정의
public interface Access {
	
	// 등록
	void insert(Student student);
	
	// 수정
	void update(Student student);
	
	// 삭제
	void delete(int studentId);
	
	// 전체조회
	Student[] selectAll();
	
	// 단건조회
	Student selectOne(int studentId);

}
