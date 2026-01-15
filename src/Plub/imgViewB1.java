package Plub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class imgViewB1 extends JFrame implements Runnable{
	static ImageIcon B1;
	static JPanel Background,B1pic;
	static JButton plus, init;
	
	public imgViewB1(){
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
	    B1 = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/1.png");
	    Image picB1 = B1.getImage();
	    B1pic = new JPanel() {
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		g.drawImage(picB1, 0, 0, this.getWidth(), this.getHeight(), this);
        	}
        };
        B1pic.setLayout(null);
        B1pic.setBackground(Color.black);
        B1pic.setSize(790, 580);
        B1pic.setLocation(10, 10);
        Background.add(B1pic);
        
        plus = new JButton();
        plus.setText("확대");
        plus.setFont(font1);
        plus.setSize(70,50);
        plus.setLocation(1200, 10);
        plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				B1pic.setSize(1300, 700);

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
				B1pic.setSize(790,580);
				
			}   	
	   });
        Background.add(init);
        
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Image imgB1;
		try {
			imgB1 = ImageIO.read(new File("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/1.png"));
			Image resizeImage = imgB1.getScaledInstance( 200, 200, Image.SCALE_SMOOTH);
			BufferedImage newImageB1 = new BufferedImage( 200, 200, BufferedImage.TYPE_INT_RGB );
			Graphics g = newImageB1.getGraphics();

			g.drawImage(resizeImage, 0, 0, null);

			g.dispose();
			
			ImageIO.write(newImageB1, "png", new File("C:/save/B1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void main(String[]args) {
		imgViewB1 imgviewb1 = new imgViewB1();
		Thread thread = new Thread(imgviewb1); // imgViewB1을 Runnable로 사용하기 위해 스레드에 전달
		thread.start(); // 스레드 시작
	}
}
