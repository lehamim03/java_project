package Plub;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import client.*;
import client.datacommunication.ClientSocket;
import client.frame.*;
import controller.*;
import server.userdb.UserDAO;

@SuppressWarnings("serial")
public class Inquiry extends JFrame {
	private ArrayList<JTextField> userInfos = new ArrayList<JTextField>();
	public ClientSocket clientSocket;
	private JTextField field;
	
	public class MainPanel {
	    public static MainFrame frame = new MainFrame();  // 프레임 객체 초기화
	    // 나머지 코드
	}
	
	public void TestMessage() {
        if(Play.classificationList.getSelectedValue() == null) {
        	JOptionPane.showMessageDialog(null, "동아리를 선택해주세요!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
        else {
        	if(Play.clubList.getSelectedValue() == null) {
            	JOptionPane.showMessageDialog(null, "동아리를 선택해주세요!","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            }
            else {
            	/*new MainFrame();*/
            	try {
            		  IndexPanel indexPanel = new IndexPanel();
            	      MainPanel.frame.change(indexPanel);
				    } catch (Exception e1) {
				      e1.printStackTrace();
				    }
            }
        }
	}
}
			