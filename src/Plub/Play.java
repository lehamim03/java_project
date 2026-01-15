package Plub;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.Controller.*;

import server.datacommunication.Message;

public class Play<imgPanel> extends JFrame {
    private String[] Classification = {"중앙동아리", "가동아리", "연합동아리", "과동아리"};
    private String[] Centralclub = {"이클립스", "울림소리", "나래", "도레샘", "올어바웃", "Flavor", "퀘스천", "와우시날", "천마극회", "포동포동", "SCO", "RCY", "굿네이버스", "능동",
    								"유니피스", "라이더스", "아이디어스", "어스파이어", "SSG", "수북수북", "CCC", "기독교학생회", "가톨릭학생회", "IVF", "기백", "ACE", "FC두공갈"	};
    private String[] Temporaryclub = {"YMC", "FLAG"};
    private String[] Federatedclub = {"미팅놈들", "필사적으로", "위드유", "Wednesday Party", "플래시 스팟", "딴짓", "EXIT"};
    private String[] Departmentclub = {"CPU", "Write-up"};
    private String[] Promoteboard = {" < 와우시날 >", " - 영화감상 동아리 (중앙동아리)", " 유호피셜) 영화보단 술을 마시는 동아리, 하지만 재미있는 동아리", " 저희는 매달 문화의 날 정기모임이 있어 직접 극장을 가거나 학교 강의실을 빌려 영화를 보고 가볍게 뒤풀이를 합니다 !", " ※ 이런 분들이 오면 좋아요 !", " ! 편입복학했는데 밥 친구와 영화 취미를 함께 할 친구를 사귀고 싶으신 학우분들 (대환영)", " ! 시간표에 공강시간이 너무 많아서 동방에서 영화와 치킨으로 채우고 싶을 때", " ! 다른 과 친구들과도 한번 사귀어서 영화도 보고 놀고 싶은 학우분들", " ! 자취를 해서 혼자 있을 시간이 많아져 영화도 보고 친목도모도 하고 싶으신 학우분들", " ", 
            " < SSG >", " - 게임 동아리 (중앙동아리)", " 창민피셜) 동방 살면서 한 번밖에 안 간 곳, 하지만 재미있는 동아리", " 게임을 좋아하는 사람들은 여기로 오라 !", " ※ 이런 분들이 오면 좋아요 !", " ! 평소 온라인 게임을 즐겨 하는데 같이 할 사람이 없어 심심한 학우분들", " ! 다양한 과 친구들을 사귀어 보고 싶은 학우분들", " ", 
            " < FLAG >", " - 코딩 동아리 (가동아리) (단, 23년 기준 중앙동아리로 승격)", " 현우피셜) 열심히 하고자 하는 마음만 가지면 얻어가는 정보가 많은 곳", " FLAG는 개발(프론트엔드, 백엔드, 안드로이드, ios 등), 정보 보안, 클라우드 등 여러 IT 분야를 공부하는 학우들이 모여", " 함께 정보를 공유하고 공부를 하면서 성장해 나아가고 있습니다.", " ※ 이런 분들이 오면 좋아요 !", " ! IT 관련 분야에 관심 있는 사람들은 누구나 환영합니다.", " ! 졸업 예정자, 졸업생, 휴학생, 취준생, 신입생 등 누구든 환영합니다.", " ",
            " < 미팅놈들 >", " - 음식 동아리 (연합동아리)", " 수도권에 더 이상 혼밥러는 없게 하겠습니다 ! 회원 수 6,000명 !", " 전국 1위 동아리에서 매일 열리는 맛집 번개 모임으로 마음맞는 사람끼리 동네 맛집으로 향하시면 됩니다~", " ※ 이런 분들이 오면 좋아요 !", " ! 대(휴)학생, 대학원생 누구나 대환영", " ! 자율 참여 방식으로 참여율이 낮으셔도 가입 가능합니다.", " ", 
            " < Write-up >", " - 코딩 동아리 (과동아리)", " 정보보호 분야로 나아가고자 하는 학생들의 동아리로, 웹 해킹, 리버싱, 시스템 해킹, 암호학 등을 공부하는", " 학생들로 구성되어 있습니다.", " ※ 이런 분들이 오면 좋아요 !", " ! 공부를 열심히 할 마음을 가진 정보보호 학우분들", " "};
    
    static JLabel page1_1,page1_2,page1_3,page1_4=new JLabel();
    static JLabel page2_1,page2_2,page2_3,page2_4=new JLabel();
    static JLabel sindong;
    static JLabel mealplan;
    static JLabel loginname;
    static JLabel ssgtext1;
    static JLabel ssgtext2;
    static JLabel ssgimg1;
    static JLabel ssgimg2;
    static JLabel wowsinaltext1;
    static JLabel wowsinaltext2;
    static JLabel wowsinalimg1;
    static JLabel wowsinalimg2;
    static JLabel flagtext1;
    static JLabel flagtext2;
    static JLabel flagimg1;
    static JLabel flagimg2;
    
    private String[] Recruitclub = {"기본 동아리","이클립스", "울림소리", "나래", "도레샘", "올어바웃", "Flavor", "퀘스천", "와우시날", "천마극회", "포동포동", "SCO", "RCY", "굿네이버스", "능동",
									"유니피스", "라이더스", "아이디어스", "어스파이어", "SSG", "수북수북", "CCC", "기독교학생회", "가톨릭학생회", "IVF", "기백", "ACE", "FC두공갈", 
									"YMC", "FLAG", "CPU", "Write-up", "미팅놈들", "필사적으로", "위드유", "Wednesday Party", "플래시 스팟", "딴짓", "EXIT"};
    private String[] Recommendplace = {"기본 지도","여장군", "구석집", "유쓰동", "여너여너", "등촌", "탕화쿵푸", "나의유부", "밀플랜비", "청년다방", "영웅갈매기", "옥류관", "정가네", "탄탄석쇠", "일인자감자탕",
    								"신동랩", "최고당돈가스", "피자먹다", "밥집", "덮밥90도", "청마루", "샬레향", "마라시대", "황제갈비", "버거킹", "김밥천국", "챠이챠이", "진쿵푸", "청담",
    								"가장맛있는족발", "찌개지존", "할매순대국", "무쇠랑", "고봉민김밥", "한솥", "와우곱창", "핵밥", "한식뷔페", "무공돈가스", "맘스터치", "바보스", "짱닭"};

    public static JList<String> classificationList;
    public static JList<String> clubList;
    public static JList<String> PromoteList;
    public static JList<String> RecruitList;
    public static JList<String> RecommendList;
 
    private JButton Chatbutton, club1, club2, club3, club4, floorB1, floor1, floor2, imgSend, choose1, choose2, choose3, pagenext, pageback, review, promotion;
    private static JPanel Background, All, leftAll, Center, Center1, Center2, Center3, Center4, pictureB1, picture1, picture2, page1, page2, mapsAll, recruit, ssgpage, wowsinalpage, flagpage;
    private static ImageIcon icon, FB1, F1, F2, maps, sindongpic, mealplanpic, clubo,clubx, clubred, clubgreen;
    
    public Play() {
        setTitle("교내 동아리 통합 시스템 (Plub)");
        setVisible(true);
        setLocation(100, 100);
        setSize(1300, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        icon = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/Plub로고.png");
        Image img = icon.getImage();
        F2 = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/3.png");
        Image picF2 = F2.getImage();
        F1 = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/2.png");
        Image picF1 = F1.getImage();
        FB1 = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/1.png");
        Image picFB1 = FB1.getImage();
        maps = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/수원대지도.png");
        Image map = maps.getImage();
        sindongpic = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/신동랩.png");
        Image Pic1 = sindongpic.getImage();
        mealplanpic = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/밀플랜비.png");
        Image Pic2 = mealplanpic.getImage();
        clubo = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/O.png");
        Image o = clubo.getImage();
        Image changeo = o.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon chagneO = new ImageIcon(changeo);
        clubx = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/X.png");
        Image x = clubx.getImage();
        Image changex = x.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon changeX = new ImageIcon(changex);
        clubgreen = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/green.png");
        Image green = clubgreen.getImage();
        Image changegreen = green.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon chagneGreen = new ImageIcon(changegreen);
        clubred = new ImageIcon("C:/java/eclipse/workspaces/자바프로젝트/src/Plub/img/red.png");
        Image red = clubred.getImage();
        Image changered = red.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon chagneRed = new ImageIcon(changered);
        
        Font font1 = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 19);
        Font font2 = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 50);
        
        Background = new JPanel();
        Background.setLayout(null);
        Background.setSize(1300,700);
        Background.setBackground(Color.black);
        add(Background);
        All = new JPanel();
        All.setLayout(null);
        All.setSize(1250, 625);
        All.setLocation(17, 18);
        All.setBackground(new Color(0xff103259, true));
        All.setBorder(new LineBorder(Color.black, 2, false));
        
        loginname = new JLabel();
        loginname.setText(controller.Controller.username + "님 환영합니다.");
        loginname.setSize(300, 50);
        loginname.setLocation(1000,5);
        loginname.setFont(font1);
        loginname.setForeground(Color.white);
        All.add(loginname);

        Background.add(All);
       
        Center = new JPanel() {
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		int x = 290; // 배경 이미지를 그릴 x 좌표
    		    int y = 140; // 배경 이미지를 그릴 y 좌표
    		    int width = 200; // 배경 이미지의 가로 크기
    		    int height = 200; // 배경 이미지의 세로 크기
    		    g.drawImage(img, x, y, width, height, null);
        	}
        };

        Center.setLayout(null);
        Center.setBackground(Color.white);
        Center.setSize(775, 480);
        Center.setLocation(425, 120);
        Center.setVisible(true);
        All.add(Center);
        Center.setBorder(new LineBorder(Color.black,2,false));
        
        Center1 = new JPanel();
        Center1.setLayout(null);
        Center1.setBackground(Color.white);
        Center1.setSize(780, 480);
        Center1.setLocation(430, 120);
        Center1.setVisible(false);
        All.add(Center1);
        
        Center2 = new JPanel();   		
        Center2.setLayout(null);
        Center2.setBackground(Color.white);
        Center2.setSize(780, 480);
        Center2.setLocation(430, 120);
        Center2.setVisible(false);
        All.add(Center2);
        
        Center3 = new JPanel() {
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		int x = 300; // 배경 이미지를 그릴 x 좌표
    		    int y = 140; // 배경 이미지를 그릴 y 좌표
    		    int width = 200; // 배경 이미지의 가로 크기
    		    int height = 200; // 배경 이미지의 세로 크기
    		    g.drawImage(img, x, y, width, height, null);
        	}
        };
        		
        Center3.setLayout(null);
        Center3.setBackground(Color.white);
        Center3.setSize(780, 480);
        Center3.setLocation(430, 120);
        Center3.setVisible(false);
        All.add(Center3);
        
        Center4 = new JPanel();     		
        Center4.setLayout(null);
        Center4.setBackground(Color.white);
        Center4.setSize(780, 480);
        Center4.setLocation(430, 120);
        Center4.setVisible(false);
        All.add(Center4);
        
        mapsAll = new JPanel() {
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		int x = 0; // 배경 이미지를 그릴 x 좌표
    		    int y = 0; // 배경 이미지를 그릴 y 좌표
    		    // 배경 이미지의 세로 크기
    		    g.drawImage(map, x, y, this.getWidth(), this.getHeight(), null);
        	}
        };
        
        mapsAll.setSize(570,450);
        mapsAll.setLocation(15,15);
        mapsAll.setVisible(true);
        Center4.add(mapsAll);
        
        sindong = new JLabel() {
     	   public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		int x = 0; // 배경 이미지를 그릴 x 좌표
    		    int y = 0; // 배경 이미지를 그릴 y 좌표
    		     // 배경 이미지의 가로 크기
    		    ; // 배경 이미지의 세로 크기
    		    g.drawImage(Pic1, x, y, this.getWidth(), this.getHeight(), null);
        	}
        };
        sindong.setSize(570,450);
        sindong.setLocation(15,15);
        sindong.setVisible(false);
        Center4.add(sindong);
        
        mealplan = new JLabel() {
      	   public void paintComponent(Graphics g) {
         		super.paintComponent(g);
         		int x = 0; // 배경 이미지를 그릴 x 좌표
     		    int y = 0; // 배경 이미지를 그릴 y 좌표
     		     // 배경 이미지의 가로 크기
     		    ; // 배경 이미지의 세로 크기
     		    g.drawImage(Pic2, x, y, this.getWidth(), this.getHeight(), null);
         	}
         };
         
         mealplan.setSize(570,450);
         mealplan.setLocation(15,15);
         mealplan.setVisible(false);
         Center4.add(mealplan);
        
        PromoteList = new JList<>(Promoteboard);
        
        JScrollPane Promoteboard = new JScrollPane(PromoteList);
        Center1.add(Promoteboard);
        Promoteboard.setSize(780, 430);
        Promoteboard.setLocation(0, 0);
        Promoteboard.setVisible(false);
        
        review = new JButton();
        review.setText("홍보글 게시판");
        review.setSize(130,30);
        review.setLocation(25, 440);
        review.setBackground(new Color(0xE6F0FF));
        review.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page1.setVisible(false);
				page2.setVisible(false);
				Promoteboard.setVisible(true);
			}
	        	
	   });	
        Center1.add(review);
        
        promotion = new JButton();
        promotion.setText("홍보물 게시판");
        promotion.setSize(130,30);
        promotion.setLocation(640, 440);
        promotion.setBackground(new Color(0xE6F0FF));
        promotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Promoteboard.setVisible(false);
				page1.setVisible(true);
				page2.setVisible(false);
			}   	
	   });	
        Center1.add(promotion);
        
        page1 = new JPanel() {
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		int x = 300; // 배경 이미지를 그릴 x 좌표
    		    int y = 140; // 배경 이미지를 그릴 y 좌표
    		    int width = 200; // 배경 이미지의 가로 크기
    		    int height = 200; // 배경 이미지의 세로 크기
    		    g.drawImage(img, x, y, width, height, null);
        	}
        };
        page1.setLayout(null);
        page1.setBackground(Color.white);
        page1.setSize(780, 430);
        page1.setLocation(0, 0);
        page1.setVisible(true);
        Center1.add(page1);
        
        pagenext = new JButton();
        pagenext.setText(">>");
        pagenext.setSize(100,30);
        pagenext.setLocation(500, 440);
        pagenext.setFont(font1);
        pagenext.setBackground(new Color(0xE6F0FF));
        pagenext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page1.setVisible(false);
				page2.setVisible(true);
			}
	        	
	   });	
        Center1.add(pagenext);
        
        page2 = new JPanel() {
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		int x = 300; // 배경 이미지를 그릴 x 좌표
    		    int y = 140; // 배경 이미지를 그릴 y 좌표
    		    int width = 200; // 배경 이미지의 가로 크기
    		    int height = 200; // 배경 이미지의 세로 크기
    		    g.drawImage(img, x, y, width, height, null);
        	}
        };
        page2.setLayout(null);
        page2.setBackground(Color.white);
        page2.setSize(780, 430);
        page2.setLocation(0, 0);
        page2.setVisible(false);
        Center1.add(page2);
        
        pageback = new JButton();
        pageback.setText("<<");
        pageback.setSize(100,30);
        pageback.setLocation(200, 440);
        pageback.setFont(font1);
        pageback.setBackground(new Color(0xE6F0FF));
        pageback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page2.setVisible(false);
				page1.setVisible(true);
			}
	        	
	   });	
        Center1.add(pageback);
        
        page1_1 = new JLabel();
        page1_1.setFont(font1);
        page1_1.setBorder(new LineBorder(Color.black,3));
        page1_1.setBounds(0,0,780,100);
        page1_1.setText("SSG 홍보물 보기");
        page1.add(page1_1);

        page1_1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PageImage1_1();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        page1_2 = new JLabel();
        page1_2.setFont(font1);
        page1_2.setBorder(new LineBorder(Color.black,3));
        page1_2.setBounds(0,110,780,100);
        page1_2.setText("FLAG 홍보물 보기");
        page1.add(page1_2);
        
        page1_2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PageImage1_2();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        page1_3 = new JLabel();
        page1_3.setFont(font1);
        page1_3.setBorder(new LineBorder(Color.black,3));
        page1_3.setBounds(0,220,780,100);
        page1_3.setText("FLAVOR 홍보물 보기");
        page1.add(page1_3);
        
        page1_3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PageImage1_3();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        page1_4 = new JLabel();
        page1_4.setFont(font1);
        page1_4.setBorder(new LineBorder(Color.black,3));
        page1_4.setBounds(0,330,780,100);
        page1_4.setText("능동 홍보물 보기");
        page1.add(page1_4);
        
        page1_4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PageImage1_4();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
               
        page2_1 = new JLabel();
        page2_1.setFont(font1);
        page2_1.setBorder(new LineBorder(Color.black,3));
        page2_1.setBounds(0,0,780,100);
        page2_1.setText("와우시날 홍보물 보기");
        page2.add(page2_1);

        page2_1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PageImage2_1();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        page2_2 = new JLabel();
        page2_2.setFont(font1);
        page2_2.setBorder(new LineBorder(Color.black,3));
        page2_2.setBounds(0,110,780,100);
        page2_2.setText("라이더스 홍보물 보기");
        page2.add(page2_2);
        
        page2_2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PageImage2_2();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        page2_3 = new JLabel();
        page2_3.setFont(font1);
        page2_3.setBorder(new LineBorder(Color.black,3));
        page2_3.setBounds(0,220,780,100);
        page2_3.setText("미팅놈들 홍보물 보기");
        page2.add(page2_3);
        
        page2_3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PageImage2_3();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        page2_4 = new JLabel();
        page2_4.setFont(font1);
        page2_4.setBorder(new LineBorder(Color.black,3));
        page2_4.setBounds(0,330,780,100);
        page2_4.setText("Write-up 홍보물 보기");
        page2.add(page2_4);
        
        page2_4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PageImage2_4();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        
        picture2 = new JPanel() {
	        public void paintComponent(Graphics g) {
	    		super.paintComponent(g);
	    		int x = 0; // 배경 이미지를 그릴 x 좌표
			    int y = 0; // 배경 이미지를 그릴 y 좌표
			    int width = 580; // 배경 이미지의 가로 크기
			    int height = 460; // 배경 이미지의 세로 크기
			    g.drawImage(picF2, x, y, width, height, null);
	    	}
	    };
        picture2.setLayout(null);
        picture2.setBackground(Color.white);
        picture2.setSize(580, 460);
        picture2.setLocation(10, 10);
        picture2.setVisible(false);
        Center3.add(picture2);
        
        picture1 = new JPanel() {
	        public void paintComponent(Graphics g) {
	    		super.paintComponent(g);
	    		int x = 0; // 배경 이미지를 그릴 x 좌표
			    int y = 0; // 배경 이미지를 그릴 y 좌표
			    int width = 580; // 배경 이미지의 가로 크기
			    int height = 460; // 배경 이미지의 세로 크기
			    g.drawImage(picF1, x, y, width, height, null);
	    	}
	    };
        picture1.setLayout(null);
        picture1.setBackground(Color.white);
        picture1.setSize(580, 460);
        picture1.setLocation(10, 10);
        picture1.setVisible(false);
        Center3.add(picture1);
        
        pictureB1 = new JPanel() {
	        public void paintComponent(Graphics g) {
	    		super.paintComponent(g);
	    		int x = 0; // 배경 이미지를 그릴 x 좌표
			    int y = 0; // 배경 이미지를 그릴 y 좌표
			    int width = 580; // 배경 이미지의 가로 크기
			    int height = 460; // 배경 이미지의 세로 크기
			    g.drawImage(picFB1, x, y, width, height, null);
	    	}
	    };		
        pictureB1.setLayout(null);
        pictureB1.setBackground(Color.white);
        pictureB1.setSize(580, 460);
        pictureB1.setLocation(10, 10);
        pictureB1.setVisible(false);
        Center3.add(pictureB1);
        
        club1 = new JButton();
        club1.setSize(170, 50);
        club1.setLocation(450, 60);
        club1.setText("홍보 게시판");
        club1.setFont(font1);
        club1.setBackground(new Color(0xE6F0FF));
        All.add(club1);
        
        club1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Center.setVisible(false);
				Center1.setVisible(true);
				Center2.setVisible(false);
				Center3.setVisible(false);
				Center4.setVisible(false);
			}
	        	
	   });
        

        
        /*JLabel additionalMessageLabel = new JLabel("Additional Message");

        // 폰트 설정
        Font font = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 14);
        additionalMessageLabel.setFont(font);
        
        Promoteboard.add(additionalMessageLabel);
        Promoteboard.setVisible(true);*/
        
        club2 = new JButton();
        club2.setSize(170, 50);
        club2.setLocation(640, 60);
        club2.setText("모집중인 동아리");
        club2.setFont(font1);
        club2.setBackground(new Color(0xE6F0FF));
        All.add(club2);
        
        club2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Center.setVisible(false);
				Center1.setVisible(false);
				Center2.setVisible(true);
				Center3.setVisible(false);
				Center4.setVisible(false);
			}
	        	
	   });

        RecruitList = new JList<>(Recruitclub);
        JScrollPane Recruitclub = new JScrollPane(RecruitList);
        Center2.add(Recruitclub);
        Recruitclub.setSize(180,460);
        Recruitclub.setLocation(10,10);
        Color Recruit = new Color(204, 206, 208);
        Center2.setBackground(Recruit);
        Center2.setBorder(new LineBorder(Color.black, 6, false));
        
        recruit = new JPanel() {
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		int x = 180; // 배경 이미지를 그릴 x 좌표
    		    int y = 140; // 배경 이미지를 그릴 y 좌표
    		    int width = 200; // 배경 이미지의 가로 크기
    		    int height = 200; // 배경 이미지의 세로 크기
    		    g.drawImage(img, x, y, width, height, null);
        	}
        };
        
        recruit.setSize(570,450);
        recruit.setLocation(195,15);
        recruit.setBackground(Color.white);
        recruit.setVisible(true);
        Center2.add(recruit);
        
        ssgpage = new JPanel();
        ssgpage.setSize(570,450);
        ssgpage.setLocation(195,15);
        ssgpage.setBackground(Color.white);
        ssgpage.setLayout(null);
        ssgpage.setVisible(false);
        Center2.add(ssgpage);
        
        ssgtext1 = new JLabel();
        ssgtext1.setSize(570,100);
        ssgtext1.setLocation(95,10);
        ssgtext1.setFont(font2);
        ssgtext1.setText("현재 SSG 동아리는");
        ssgpage.add(ssgtext1);
        
        ssgtext2 = new JLabel();
        ssgtext2.setSize(570,100);
        ssgtext2.setLocation(150,100);
        ssgtext2.setFont(font2);
        ssgtext2.setText("모집중이 아님");
        ssgpage.add(ssgtext2);
        
        ssgimg1 = new JLabel(chagneO);
        ssgimg1.setSize(300, 300);
        ssgimg1.setLocation(20, 150); // 정확한 위치 설정
        ssgpage.add(ssgimg1);
        
        ssgimg2 = new JLabel(chagneRed);
        ssgimg2.setSize(250,250);
        ssgimg2.setLocation(290, 190);
        ssgpage.add(ssgimg2);

        wowsinalpage = new JPanel();
        wowsinalpage.setSize(570,450);
        wowsinalpage.setLocation(195,15);
        wowsinalpage.setLayout(null);
        wowsinalpage.setBackground(Color.white);
        wowsinalpage.setVisible(false);
        Center2.add(wowsinalpage);
        
        wowsinaltext1 = new JLabel();
        wowsinaltext1.setSize(570,100);
        wowsinaltext1.setLocation(55,10);
        wowsinaltext1.setFont(font2);
        wowsinaltext1.setText("현재 와우시날 동아리는");
        wowsinalpage.add(wowsinaltext1);
        
        wowsinaltext2 = new JLabel();
        wowsinaltext2.setSize(570,100);
        wowsinaltext2.setLocation(220,100);
        wowsinaltext2.setFont(font2);
        wowsinaltext2.setText("모집중!");
        wowsinalpage.add(wowsinaltext2);
        
        wowsinalimg1 = new JLabel(chagneO);
        wowsinalimg1.setSize(300, 300);
        wowsinalimg1.setLocation(20, 150); // 정확한 위치 설정
        wowsinalpage.add(wowsinalimg1);
        
        wowsinalimg2 = new JLabel(chagneGreen);
        wowsinalimg2.setSize(250,250);
        wowsinalimg2.setLocation(290, 190);
        wowsinalpage.add(wowsinalimg2);
        
        flagpage = new JPanel();
        flagpage.setSize(570,450);
        flagpage.setLocation(195,15);
        flagpage.setBackground(Color.white);
        flagpage.setVisible(false);
        Center2.add(flagpage);
        
        flagpage = new JPanel();
        flagpage.setSize(570,450);
        flagpage.setLocation(195,15);
        flagpage.setBackground(Color.white);
        flagpage.setVisible(false);
        Center2.add(flagpage);
        
        flagtext1 = new JLabel();
        flagtext1.setSize(570,100);
        flagtext1.setLocation(95,10);
        flagtext1.setFont(font2);
        flagtext1.setText("현재 FLAG 동아리는");
        flagpage.add(flagtext1);
        
        flagtext2 = new JLabel();
        flagtext2.setSize(570,100);
        flagtext2.setLocation(220,100);
        flagtext2.setFont(font2);
        flagtext2.setText("모집인원이 꽉참");
        flagpage.add(flagtext2);
        
        flagimg1 = new JLabel(changeX);
        flagimg1.setSize(300, 300);
        flagimg1.setLocation(20, 150); // 정확한 위치 설정
        flagpage.add(flagimg1);
        
        flagimg2 = new JLabel(chagneGreen);
        flagimg2.setSize(250,250);
        flagimg2.setLocation(290, 190);
        flagpage.add(flagimg2);
        
        club3 = new JButton();
        club3.setSize(170, 50);
        club3.setLocation(830, 60);
        club3.setText("동방 안내도");
        club3.setFont(font1);
        club3.setBackground(new Color(0xE6F0FF));
        All.add(club3);
        
        club3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Center.setVisible(false);
				Center1.setVisible(false);
				Center2.setVisible(false);
				Center3.setVisible(true);
				Center4.setVisible(false);
				
			}
	        	
	   });
        
        floor2 = new JButton();
        floor2.setSize(150, 50);
        floor2.setLocation(600, 150);
        floor2.setText("학생회관 2층");
        floor2.setFont(font1);
        Center3.add(floor2);
        
        floor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				picture2.setVisible(true);
				picture1.setVisible(false);
				pictureB1.setVisible(false);
			}
	        	
	   });
        
        floor1 = new JButton();
        floor1.setSize(150, 50);
        floor1.setLocation(600, 220);
        floor1.setText("학생회관 1층");
        floor1.setFont(font1);
        Center3.add(floor1);
        
        floor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				picture2.setVisible(false);
				picture1.setVisible(true);
				pictureB1.setVisible(false);
			}
	        	
	   });
        
        floorB1 = new JButton();
        floorB1.setSize(150, 50);
        floorB1.setLocation(600, 290);
        floorB1.setText("학생회관 B1층");
        floorB1.setFont(font1);
        Center3.add(floorB1);
        
        floorB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				picture2.setVisible(false);
				picture1.setVisible(false);
				pictureB1.setVisible(true);
			}
	        	
	   });
        
        imgSend = new JButton();
        imgSend.setSize(150,50);
        imgSend.setLocation(600, 400);
        imgSend.setText("이미지 확대 및 컴퓨터에 저장");
        imgSend.setFont(font1);
        Center3.add(imgSend);
        
        imgSend.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(pictureB1.isVisible()) {
        			imgViewB1 imgviewb1 = new imgViewB1();
        			Thread thread = new Thread(imgviewb1); // imgViewB1을 Runnable로 사용하기 위해 스레드에 전달
        			thread.start(); // 스레드 시작
        		}
        		else if(picture1.isVisible()) {
        			imgViewF1 imgviewf1 = new imgViewF1();
        			Thread thread = new Thread(imgviewf1); // imgViewB1을 Runnable로 사용하기 위해 스레드에 전달
        			thread.start(); // 스레드 시작
        		}
        		else if(picture2.isVisible()) {
        			imgViewF2 imgviewf2 = new imgViewF2();
        			Thread thread = new Thread(imgviewf2); // imgViewB1을 Runnable로 사용하기 위해 스레드에 전달
        			thread.start(); // 스레드 시작
        		}
        	}
        });
        
        club4 = new JButton();
        club4.setSize(170, 50);
        club4.setLocation(1020, 60);
        club4.setText("모임 추천 장소");
        club4.setFont(font1);
        club4.setBackground(new Color(0xE6F0FF));
        All.add(club4);
        
        club4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Center.setVisible(false);
				Center1.setVisible(false);
				Center2.setVisible(false);
				Center3.setVisible(false);
				Center4.setVisible(true);
			}  	
	   });
        
        RecommendList = new JList<>(Recommendplace);
        
        JScrollPane Recommendplace = new JScrollPane(RecommendList);
        Center4.add(Recommendplace);
        Recommendplace.setSize(180,460);
        Recommendplace.setLocation(590,10);
        Color place = new Color(204, 206, 208);
        Recommendplace.setBackground(place);
        Center4.setBackground(Color.white);
        Center4.setBorder(new LineBorder(Color.black, 6, false));
        
        classificationList = new JList<>(Classification);
        
        JScrollPane classification = new JScrollPane(classificationList);
        leftAll = new JPanel();
        leftAll.add(classification);
        classification.setSize(285,210);
        classification.setLocation(30,30);
        leftAll.setSize(350, 580);
        leftAll.setLocation(25, 23);
        leftAll.setLayout(null);
        //Color main = new Color(204, 206, 208);setForeground(Color.lightGray);
        leftAll.setBackground(new Color(0x6E7B8B));
        leftAll.setBorder(new LineBorder(Color.black, 2, false));
        All.add(leftAll);
        
        /* test
        Leftall = new JTextField("left all 테스트");
        leftAll.add(Leftall);
        */
        classificationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        clubList = new JList<>();
        classificationList.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftAll.setFont(font1);
             
        classificationList.addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent event) { 
                if (!event.getValueIsAdjusting()) {
                    String selectedCategory = classificationList.getSelectedValue();
                    switch (selectedCategory) {
                        case "중앙동아리":
                        	
                            clubList.setListData(Centralclub);
                            break; 
                        case "가동아리":
                        	
                            clubList.setListData(Temporaryclub);
                            break;
                        case "연합동아리":
                        	
                            clubList.setListData(Federatedclub);
                            break;
                        case "과동아리":
                        	
                            clubList.setListData(Departmentclub);
                            break;
                    }
                }
            }
        });
        
        RecommendList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event1) { 
                   if (!event1.getValueIsAdjusting()) {
                       String selectedCategory1 = RecommendList.getSelectedValue();
                       switch (selectedCategory1) {
                           case "신동랩":
                        	   mealplan.setVisible(false);
                        	   mapsAll.setVisible(false);
                        	   sindong.setVisible(true);
                               break;
                           case "기본 지도":
                        	   mapsAll.setVisible(true);
                        	   sindong.setVisible(false);
                        	   mealplan.setVisible(false);
                        	   break;
                           case "밀플랜비":
                        	   mapsAll.setVisible(false);
                        	   sindong.setVisible(false);
                        	   mealplan.setVisible(true);
                        	   break;
                           default:
                        	   mapsAll.setVisible(true);
                        	   sindong.setVisible(false);
                        	   mealplan.setVisible(false);
                        	   break;
                       }
                   }
               }
           });
        
        RecruitList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event2) { 
                   if (!event2.getValueIsAdjusting()) {
                       String selectedCategory2 = RecruitList.getSelectedValue();
                       switch (selectedCategory2) {
                       	   case "기본 동아리":
                       		   recruit.setVisible(true);
                       		   ssgpage.setVisible(false);
                       		   wowsinalpage.setVisible(false);
                       		   flagpage.setVisible(false);
                       		   break;
                           case "SSG":
                        	   recruit.setVisible(false);
                       		   ssgpage.setVisible(true);
                       		   wowsinalpage.setVisible(false);
                       		   flagpage.setVisible(false);
                               break;
                           case "와우시날":
                        	   recruit.setVisible(false);
                       		   ssgpage.setVisible(false);
                       		   wowsinalpage.setVisible(true);
                       		   flagpage.setVisible(false);
                        	   break;
                           case "FLAG":
                        	   recruit.setVisible(false);
                       		   ssgpage.setVisible(false);
                       		   wowsinalpage.setVisible(false);
                       		   flagpage.setVisible(true);
                        	   break;
                           default:
                        	   recruit.setVisible(true);
                       		   ssgpage.setVisible(false);
                       		   wowsinalpage.setVisible(false);
                       		   flagpage.setVisible(false);
                        	   break;
                       }
                   }
               }
           });
        Font font = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 26);
        classificationList.setFont(font);
        
        JScrollPane club = new JScrollPane(clubList);
        club.setSize(285,210);
        club.setLocation(30,265);
        classificationList.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftAll.add(club);

        classificationList.addMouseListener(new MouseAdapter() {
            	private int pressIndex;

            public void mousePressed(MouseEvent e) {
                pressIndex = classificationList.locationToIndex(e.getPoint());
                classificationList.setSelectedIndex(pressIndex);
            }

            public void mouseDragged(MouseEvent e) {
                int currentIndex = classificationList.locationToIndex(e.getPoint());
                classificationList.setSelectionInterval(pressIndex, currentIndex);
            }
        });    
        
        clubList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        Chatbutton = new JButton();
        Chatbutton.setSize(120, 50);
        Chatbutton.setLocation(110, 500);
        Chatbutton.setText("1:1 문의");
        Chatbutton.setFont(font1);
        Chatbutton.setBackground(new Color(0xE6F0FF));
        Chatbutton.setBorder(new LineBorder(Color.black, 2, false));
        leftAll.add(Chatbutton);
        
        Inquiry test = new Inquiry();
        
		Chatbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test.TestMessage();
			}
	        	
	   });				
		
    } 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Play();
            }
        });
    }
}

    	
    