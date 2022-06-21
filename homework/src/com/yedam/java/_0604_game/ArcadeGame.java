package com.yedam.java._0604_game;

public class ArcadeGame implements Keypad {

	// 필드
	private int currentMode = Keypad.NORMAL_MODE;
	
	
	/**
	 * @param currentMode
	 */
	public ArcadeGame(int currentMode) {
		this.currentMode = currentMode;
		System.out.println("ArcadeGame 실행");
	}
	
	public ArcadeGame() {
		System.out.println("ArcadeGame 실행");
	}

	
	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 앞쪽으로 이동한다.");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 뒤쪽으로 이동한다.");		
	}

	@Override
	public void rightUpButton() {
		if (currentMode == Keypad.NORMAL_MODE) {
			System.out.println("캐릭터가 일반공격.");		
		}
		else if (currentMode == Keypad.HARD_MODE) {
			System.out.println("캐릭터가 연속공격.");		
		}
	}

	@Override
	public void rightDownButton() {
		if (currentMode == Keypad.NORMAL_MODE) {
			System.out.println("캐릭터가 HIT 공격.");		
		}
		else if (currentMode == Keypad.HARD_MODE) {
			System.out.println("캐릭터가 DOUBLE HIT 공격.");		
		}
	}

	@Override
	public void changeMode() {
		String displayMode = "";
		if (currentMode == Keypad.NORMAL_MODE) {
			currentMode = Keypad.HARD_MODE;	
			displayMode = "HARD_MODE";
		}
		else if (currentMode == Keypad.HARD_MODE) {
			currentMode = Keypad.NORMAL_MODE;
			displayMode = "NORMAL_MODE";
		}
		System.out.println("현재 모드 : " + displayMode);
	}

}
