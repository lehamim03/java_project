package Plub;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.Controller;
import enums.CommonWord;
import util.UserInfoPanel;
import client.frame.*;

@SuppressWarnings("serial")
public class Start extends JFrame{    
    private ArrayList<JTextField> userInfos = new ArrayList<JTextField>();
    static JButton login=new JButton("로그인"); //로그인 버튼
    static JButton nonlogin=new JButton("비로그인"); //비로그인 버튼
    static JLabel signup=new JLabel();
    static JLabel myaccount=new JLabel();
    static JPanel background=new JPanel() {/*패널정의*/
            Image backgroundimg=new ImageIcon(Start.class.getResource("/Plub/img/Plub로고.png")).getImage();//배경이미지
            public void paint(Graphics g) {//그리는 함수
                super.paint(g);
                int x = 128; // 배경 이미지를 그릴 x 좌표
                int y = 46; // 배경 이미지를 그릴 y 좌표
                int width = 103; // 배경 이미지의 가로 크기
                int height = 92; // 배경 이미지의 세로 크기
                g.drawImage(backgroundimg, x, y, width, height, null);
                
                int tx1 = 168; // 글씨의 x 좌표
                int ty1 = 351; // 글씨의 y 좌표
                
                g.setColor(Color.gray); // 글씨의 색상을 빨간색으로 설
                g.drawString("또는", tx1, ty1);

                int tx3 = 177; // 글씨의 x 좌표
                int ty3 = 515; // 글씨의 y 좌표
                
                g.drawString("|", tx3, ty3);

            }
    };

    // 아이디와 비밀번호를 입력받는 JTextField
    public JTextField idTextField;
    public JPasswordField passwordField;
    
    public Start() { //생성자
        backgroundframe();
        setpanel();//setpanel함수를 실행
    }
    
    public void backgroundframe() {
        setTitle("Plub (교내동아리 통합 시스템)"); //타이틀
        setSize(375,600); //프레임의 크기
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
    public void setpanel() { /*패널 관련 설정*/
        
        Font font = new Font("맑은 고딕",Font.PLAIN,13);
        
        signup.setFont(font);
        signup.setText("회원가입");
        signup.setBounds(104,504,58,18);
        signup.setForeground(Color.gray);
        background.add(signup);
        
        myaccount.setFont(font);
        myaccount.setText("내 계정 찾기");
        myaccount.setBounds(200,502,75,18);
        myaccount.setForeground(Color.gray);
        background.add(myaccount);
        
        /*위치 설정*/
        login.setBounds(59, 286, 242, 41);//버튼1의 위치 설정
        nonlogin.setBounds(59, 370, 242, 41);//버튼1의 위치 설정
        background.setBounds(0, 0, 375, 600); //패널의 위치와 크기.
        /*레이아웃 지정*/
        background.setLayout(null); //레이아웃 설정하기 위해.
        /*패널이나 프레임에 추가*/
        add(background);//프레임에 패널을 추가
        background.add(login);//패널1에 로그인 버튼을 추가
        background.add(nonlogin);//패널1에 비로그인 버튼을 추가
        
        // 아이디 입력란 설정
        idTextField = new JTextField();
        idTextField.setBounds(59, 205, 242, 38);
        idTextField.setText("아이디");
        idTextField.setForeground(Color.gray);
        background.add(idTextField);

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
     // 비밀번호 입력란 설정
        passwordField = new JPasswordField();
        passwordField.setBounds(59, 243, 242, 37);
        passwordField.setText("비밀번호");
        passwordField.setForeground(Color.gray);
        background.add(passwordField);

        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String password = String.valueOf(passwordField.getPassword());
                if (password.equals("비밀번호")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String password = String.valueOf(passwordField.getPassword());
                if (password.isEmpty()) {
                    passwordField.setText("비밀번호");
                    passwordField.setForeground(Color.gray);
                }
            }
        });
        
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  loginUser();
                
            }
        });
        
        nonlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "게스트로 로그인합니다!");
                background.setVisible(false); 
                new Play();
            }
        });
        
        signup.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Sign_up();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {
                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                signup.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                signup.setForeground(Color.gray);
            }
        });
        
        myaccount.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Myaccount();
            }
            @Override
            public void mousePressed(MouseEvent e) {
                
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                myaccount.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                myaccount.setForeground(Color.gray);
            }
        });
    }
    
    private void loginUser() {
        Controller controller = Controller.getInstance();
        controller.findUser(userInfos);
      }
    
    /*메인함수*/
    public static void main(String[] args) {
        Start start = new Start(); 
    }
}
