package java_gui_study;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JLabel_JTextFieldTest {

	public static void main(String[] args) {

		JFrame jf = new JFrame();

		jf.setSize(380, 180);
		jf.setTitle("로그인");
		jf.setLocation(1000, 500);
		jf.setLayout(null);

		// JLabel 생성
		JLabel jl = new JLabel("아이디 : ");
		jl.setSize(80, 30);
		jl.setLocation(30, 30);
		jl.setHorizontalAlignment(JLabel.CENTER);
		// 만든 JLabel 을 추가
		jf.add(jl);

		// JTextField 생성
		JTextField jt = new JTextField();
		jt.setSize(130, 30);
		jt.setLocation(110, 30);
		// 생성된 JTextField 추가
		jf.add(jt);

		// JLabel 생성
		JLabel jl2 = new JLabel("비밀번호 : ");
		jl2.setSize(80, 30);
		jl2.setLocation(30, 60);
		jl2.setHorizontalAlignment(JLabel.CENTER);
//		jl2.setBackground(Color.red);
		// 만든 JLabel 을 추가
		jf.add(jl2);

		// JTextField 생성
		JTextField jt2 = new JTextField();
		jt2.setSize(130, 30);
		jt2.setLocation(110, 60);
		// 생성된 JTextField 추가
		jf.add(jt2);

		jf.setVisible(true);

	}

}
