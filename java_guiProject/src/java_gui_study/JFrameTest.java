package java_gui_study;

import javax.swing.JFrame;

public class JFrameTest {
	
	public static void main(String[] args) {
		
		JFrame jf = new JFrame();
		
		// 프레임의 위치와 크기 함께 설정
		jf.setBounds(1000, 300, 300, 300);
		// 프레임 제목 설정
		jf.setTitle("hello jframe");
		// gui 창 닫으면 프로그램 종료
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면 표시 default : false
		jf.setVisible(true);
	}

}
