package com.yedam.java._0604_game;

public interface Keypad {
	
	// 필드
	public int NORMAL_MODE = 0;
	public int HARD_MODE = 1;
	
	
	// 메서드
	void leftUpButton();
	
	void leftDownButton();
	
	void rightUpButton();
	
	void rightDownButton();
	
	void changeMode();
}
