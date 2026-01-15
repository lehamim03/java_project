package Plub;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class test extends JFrame {
	private JButton Chatbutton, club1, club2, club3, club4, floorB1, floor1, floor2, imgSend;
    private static JPanel Background, All, leftAll, Center, Center1, Center2, Center3, Center4, pictureB1, picture1, picture2;
    private static ImageIcon icon, FB1, F1, F2;

    public test() {
    	setTitle("교내 동아리 통합 시스템 (Plub)");
        setVisible(true);
        setLocation(100, 100);
        setSize(1300, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        icon = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/PlubLogoCut.png");
        Image img = icon.getImage();
        F2 = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/3.png");
        Image picF2 = F2.getImage();
        F1 = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/2.png");
        Image picF1 = F1.getImage();
        FB1 = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/1.png");
        Image picFB1 = FB1.getImage();
               
        Background = new JPanel();
        Background.setLayout(null);
        Background.setSize(1300,700);
        Background.setBackground(Color.white);
        add(Background);
        All = new JPanel();
        All.setLayout(null);
        All.setSize(1250, 625);
        All.setLocation(17, 18);
        All.setBackground(new Color(0xff103259, true));
        All.setBorder(new LineBorder(Color.black, 2, false));

        Background.add(All);
       
        Center = new JPanel() {
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		int x = 300; // 배경 이미지를 그릴 x 좌표
    		    int y = 140; // 배경 이미지를 그릴 y 좌표
    		    int width = 200; // 배경 이미지의 가로 크기
    		    int height = 200; // 배경 이미지의 세로 크기
    		    g.drawImage(img, x, y, width, height, null);
        	}
        };

        Center.setLayout(null);
        Center.setBackground(Color.white);
        Center.setSize(780, 480);
        Center.setLocation(430, 120);
        Center.setVisible(true);
        All.add(Center);
    }

    

    public static void main(String[] args) {
        new test();
    }
}
