package Plub;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class PageImage2_2 extends JFrame{
	static JPanel Background= new JPanel();
	static JPanel backgroundimg;
	static ImageIcon riders;
	public PageImage2_2() {
		setTitle("교내 동아리 통합 시스템 (Plub)");
	    setVisible(true);
	    setLocation(100, 100);
	    setSize(800, 700);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    Background = new JPanel();
        Background.setLayout(null);
        Background.setSize(800,700);
        Background.setBackground(Color.white);
        add(Background);
        riders = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/riders.jpg");
	    Image riderspic = riders.getImage();
	    backgroundimg = new JPanel() {
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		g.drawImage(riderspic, 0, 0, this.getWidth(), this.getHeight(), this);
        	}
        };
        backgroundimg.setLayout(null);
        backgroundimg.setBackground(Color.black);
        backgroundimg.setSize(790, 580);
        backgroundimg.setLocation(0, 0);
        Background.add(backgroundimg);
	}

}
