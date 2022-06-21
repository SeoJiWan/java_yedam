package com.yedam.java.ch1101;

import java.util.Objects;

public class Key {
	
	public int number;

	
	/**
	 * @param number
	 */
	public Key(int number) {
		this.number = number;
	}



	// 이클립스 제공 equals 메서드 오버라이딩
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Key other = (Key) obj;
//		return number == other.number;
//	}
	
	// 교수님 equals 메서드 오버라이딩
	@Override
	public boolean equals(Object object) {
		if (object instanceof Key) {
			Key key = (Key) object;
			if (this.number == key.number) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return "Key [number = " + number + "]";
	}

}
