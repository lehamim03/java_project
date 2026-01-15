package Plub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class imgViewF1 extends JFrame implements Runnable{
	static ImageIcon F1;
	static JPanel Background,F1pic,pluspic;
	static JButton plus, init;
	private int width = 1300;
	private int height = 700;
	public imgViewF1(){
		Font font1 = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 19);
		setTitle("교내 동아리 통합 시스템 (Plub)");
	    setVisible(true);
	    setLocation(100, 100);
	    setSize(1300, 700);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    Background = new JPanel();
        Background.setLayout(null);
        Background.setSize(1300,700);
        Background.setBackground(Color.white);
        add(Background);
	    F1 = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/2.png");
	    Image picF1 = F1.getImage();
	    F1pic = new JPanel() {
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		g.drawImage(picF1, 0, 0, this.getWidth(), this.getHeight(), this);
        	}
        };
        F1pic.setLayout(null);
        F1pic.setBackground(Color.black);
        F1pic.setSize(790, 580);
        F1pic.setLocation(10, 10);
        Background.add(F1pic);
              
        plus = new JButton();
        plus.setText("확대");
        plus.setFont(font1);
        plus.setSize(70,50);
        plus.setLocation(1200, 10);
        plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F1pic.setSize(1300, 700);

			}   	
	   });
        Background.add(plus);
        
        init = new JButton();
        init.setText("복구");
        init.setFont(font1);
        init.setSize(70,50);
        init.setLocation(1200, 80);
        init.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F1pic.setSize(790,580);
				
			}   	
	   });
        Background.add(init);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Image imgF1;
		try {
			imgF1 = ImageIO.read(new File("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/2.png"));
			Image resizeImage = imgF1.getScaledInstance( 200, 200, Image.SCALE_SMOOTH);
			BufferedImage newImageF1 = new BufferedImage( 200, 200, BufferedImage.TYPE_INT_RGB );
			Graphics g = newImageF1.getGraphics();

			g.drawImage(resizeImage, 0, 0, null);

			g.dispose();
			
			ImageIO.write(newImageF1, "png", new File("C:/save/F1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void main(String[]args) {
		imgViewF1 imgviewf1 = new imgViewF1();
		Thread thread = new Thread(imgviewf1); // imgViewB1을 Runnable로 사용하기 위해 스레드에 전달
		thread.start(); // 스레드 시작
	}
}

