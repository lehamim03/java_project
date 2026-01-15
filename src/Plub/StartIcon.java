package Plub;
import javax.swing.*;

import client.frame.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartIcon extends JFrame{
	static JLabel text1 = new JLabel();
	private static JButton btn1 = new JButton();
	private static JButton btn2 = new JButton();
	static JPanel background=new JPanel() {/*패널정의*/
		Image backgroundimg=new ImageIcon(Start.class.getResource("/Plub/img/Plub로고.png")).getImage();//배경이미지
		public void paint(Graphics g) {//그리는 함수
			super.paint(g);
		    int x = 128; // 배경 이미지를 그릴 x 좌표
		    int y = 46; // 배경 이미지를 그릴 y 좌표
		    int width = 103; // 배경 이미지의 가로 크기
		    int height = 92; // 배경 이미지의 세로 크기
		    g.drawImage(backgroundimg, x, y, width, height, null);

		}
};
	
	public void Frame() {
		setTitle("Plub (교내동아리 통합 시스템)"); //타이틀
		setSize(375,300); //프레임의 크기
		setResizable(false); //창의 크기를 변경하지 못하게
		setLocationRelativeTo(null); //창이 가운데 나오게
		setLayout(null); //레이아웃을 내맘대로 설정가능하게 해줌.
		setVisible(true); //창이 보이게
		background.setLayout(null); //레이아웃 설정하기 위해.
		background.setBounds(0, 0, 375, 600); //패널의 위치와 크기.
		background.setBackground(new Color(0xff103259, true));
		add(background); //프레임에 패널을 추가.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame이 정상적으로 종료되게
	}
	
	public void Panel() {
		Font font = new Font("맑은 고딕",Font.PLAIN,20);
		text1.setFont(font);
		text1.setText("Plub을 실행합니다...");
		text1.setBounds(95,150, 200,30);
		text1.setForeground(Color.gray);
		background.add(text1);
		
		btn1.setText("실행");
		btn1.setBounds(60, 200, 100, 30);
		background.add(btn1);
		
		btn2.setText("종료");
		btn2.setBounds(200, 200, 100, 30);
		background.add(btn2);
	}
	
	public StartIcon() {
		Frame();
		Panel();
	}
	public static void main(String[]args) {
		StartIcon starticon = new StartIcon();
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame();
			    mainFrame.setVisible(true);
			    starticon.setVisible(false);
			}
	        	
	   });
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
	        	
	   });
		
	}

}
