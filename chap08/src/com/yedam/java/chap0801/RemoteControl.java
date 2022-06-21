package com.yedam.java.chap0801;

public interface RemoteControl {
	
	// 상수 필드
	public static final int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0; // static final 으로 자바가 자동 컴파일
	
	
	// 추상 메서드
	public abstract void turnOn();
	
	void turnOff(); // public abstract 으로 자바가 자동 컴파일
	
	void setVolume(int volume);
}
