package Plub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controller.Controller;
import enums.CommonWord;
import util.UserInfoPanel;

public class Sign_up extends JFrame {
	static String[] school = {"수원대학교", "수원과학대학교","협성대학교","경기대학교","아주대학교","용인대학교","을지대학교","단국대학교"};	
	static JLabel text =new JLabel();
	static JLabel textId = new JLabel();
	static JLabel textPassword = new JLabel();
	static JLabel textPassword1 = new JLabel();
	static JLabel textName = new JLabel();
	static JLabel textSchool = new JLabel();
	static JLabel textNum = new JLabel();
	static JButton confirm = new JButton();
	static JComboBox School = new JComboBox(school);
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
	public JTextField idTextField, passwordField, passwordField1, nameField, numField;
	
	private ArrayList<JTextField> userInfos = new ArrayList<JTextField>();
	
	public Sign_up() {
		Sign_up();
		setPanel();
	}
	
	public void Sign_up() {
		setTitle("Plub (교내동아리 통합 시스템) 회원가입"); //타이틀
		setSize(375,800); //프레임의 크기
		setResizable(false); //창의 크기를 변경하지 못하게
		setLocationRelativeTo(null); //창이 가운데 나오게
		setLayout(null); //레이아웃을 내맘대로 설정가능하게 해줌.
		setVisible(true); //창이 보이게
		background.setLayout(null); //레이아웃 설정하기 위해.
		background.setBounds(0, 0, 375, 800); //패널의 위치와 크기.
		background.setBackground(new Color(0xff103259, true));
		add(background); //프레임에 패널을 추가.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setPanel() {
		
		confirm.setText("회원가입하기");
        confirm.setSize(120, 30);
        confirm.setLocation(130, 700);
        background.add(confirm);
        
		Font font = new Font("맑은 고딕",Font.PLAIN,20);
		text.setFont(font);
		text.setBounds(118, 138, 200, 38);
		text.setText("Plub 회원가입");
		text.setForeground(Color.white);
		background.add(text);
		
		textId.setFont(font);
		textId.setBounds(60, 170, 200, 38);
		textId.setText("ID");
		textId.setForeground(Color.white);
		background.add(textId);
		
		textPassword.setFont(font);
		textPassword.setBounds(57, 250, 200, 38);
		textPassword.setText("비밀번호");
		textPassword.setForeground(Color.white);
		background.add(textPassword);
		
		textPassword1.setFont(font);
		textPassword1.setBounds(57, 330, 200, 38);
		textPassword1.setText("비밀번호 확인");
		textPassword1.setForeground(Color.white);
		background.add(textPassword1);
		
		textName.setFont(font);
		textName.setBounds(60,410,200,38);
		textName.setText("이름");
		textName.setForeground(Color.white);
		background.add(textName);
		
		textSchool.setFont(font);
		textSchool.setBounds(57,500,200,38);
		textSchool.setText("학교");
		textSchool.setForeground(Color.white);
		background.add(textSchool);
		
		textNum.setFont(font);
		textNum.setBounds(59,590,200,38);
		textNum.setText("학번");
		textNum.setForeground(Color.white);
		background.add(textNum);
		
		idTextField = new JTextField();
        idTextField.setBounds(59, 210, 242, 38);
        idTextField.setText("아이디");
        idTextField.setForeground(Color.gray);
        background.add(idTextField);
        
        passwordField = new JTextField();
        passwordField.setBounds(59, 290, 242, 38);
        passwordField.setText("비밀번호");
        passwordField.setForeground(Color.gray);
        background.add(passwordField);
        
        passwordField1 = new JTextField();
        passwordField1.setBounds(59, 370, 242, 38);
        passwordField1.setText("비밀번호 확인");
        passwordField1.setForeground(Color.gray);
        background.add(passwordField1);
        
        nameField = new JTextField();
        nameField.setBounds(59, 455, 242, 38);
        nameField.setText("이름");
        nameField.setForeground(Color.gray);
        background.add(nameField);
        
        School.setBounds(58, 545, 242, 38);
        background.add(School);
        
        numField = new JTextField();
        numField.setBounds(57, 630, 242, 38);
        numField.setText("학번");
        numField.setForeground(Color.gray);
        background.add(numField);

        idTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (idTextField.getText().equals("아이디")) {
                    idTextField.setText("");
                    idTextField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (idTextField.getText().isEmpty()) {
                    idTextField.setText("아이디");
                    idTextField.setForeground(Color.gray);
                }
            }
        });
        
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("비밀번호")) {
                	passwordField.setText("");
                	passwordField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                	passwordField.setText("비밀번호");
                	passwordField.setForeground(Color.gray);
                }
            }
        });
        
        passwordField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField1.getText().equals("비밀번호 확인")) {
                	passwordField1.setText("");
                	passwordField1.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField1.getText().isEmpty()) {
                	passwordField1.setText("비밀번호 확인");
                	passwordField1.setForeground(Color.gray);
                }
            }
        });
        
        nameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (nameField.getText().equals("이름")) {
                	nameField.setText("");
                	nameField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (nameField.getText().isEmpty()) {
                	nameField.setText("이름");
                	nameField.setForeground(Color.gray);
                }
            }
        });
        
        numField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (numField.getText().equals("학번")) {
                	numField.setText("");
                	numField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (numField.getText().isEmpty()) {
                	numField.setText("학번");
                	numField.setForeground(Color.gray);
                }
            }
        });
       /* 
        confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Start();
			}
	        	
	   });
	   */
	}

	
	public static void main(String[]args) {
		new Sign_up();
	}
}




