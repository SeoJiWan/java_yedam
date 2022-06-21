package com.yedam.java.chap0801;

public class RemotTest {

	public static void main(String[] args) {
//		RemoteControl remoteControl = new TV();
		RemoteControl remoteControl = new Audio();
		remoteControl.turnOn();
		remoteControl.setVolume(7);
		remoteControl.setVolume(12);
		remoteControl.turnOff();
		
		
		SmartControl smartControl = new TV();
		smartControl.searchInternet("www.naver.com");
		smartControl.executeApp("NetFlix");
		
		
		Control c = new TV();
		c.turnOn();
		c.executeApp("게임");

	}
}
