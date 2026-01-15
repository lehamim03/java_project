package Plub;
import javax.swing.*;
import java.awt.*;

public class Myaccount extends JFrame{
	static JPanel background=new JPanel();
	public JTextField idTextField;
	public JPasswordField passwordField;
	
	public Myaccount() {
		Myaccount();
	}
	public void Myaccount() {
		setTitle("Plub (교내동아리 통합 시스템) 계정 찾기"); //타이틀
		setSize(375,600); //프레임의 크기
		setResizable(false); //창의 크기를 변경하지 못하게
		setLocationRelativeTo(null); //창이 가운데 나오게
		setLayout(null); //레이아웃을 내맘대로 설정가능하게 해줌.
		setVisible(true); //창이 보이게
		background.setLayout(null); //레이아웃 설정하기 위해.
		background.setBounds(0, 0, 375, 600); //패널의 위치와 크기.
		background.setBackground(new Color(0xff103259, true));
		add(background); //프레임에 패널을 추가.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[]args) {
		new Myaccount();
	}
}
