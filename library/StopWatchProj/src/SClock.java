import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SClock extends JFrame {

	
	//Clock
	private JLabel Lstopwatch = new JLabel();//1초마다 1씩오르는 스톱워치의 숫자를 표시해준다.
	
	private int mouseX, mouseY; //x랑 y의 위치를 저장
	private JButton exitbutton = new JButton("나가기");//상단메뉴의 나가기버튼
	//스탑워치
	private int i=0; //스톱워치에서 사용하며 0일때는 스톱워치가 동작하지 않고 1일때 동작한다.
	int stop=0; //스톱워치에 사용할 변수  msec(1자리)
	int ssec=0;//스톱워치에 사용할 변수  초
	int smin=0;//스톱워치에 사용할 변수  분
	int shour=0;//스톱워치에 사용할 변수 시간
	private JButton stopstart = new JButton();//스톱워치 시작버튼
	private JButton swstop = new JButton();//스톱워치 중지버튼
	private JButton stopreset = new JButton("reset");//스탑워치 리셋
	private JTextArea list=new JTextArea(1,2);
	private String listnum;//스톱워치를 문자열로 표시할 수 있게 해준다.
	private JScrollPane scroll=new JScrollPane(list);//////////////////////////////////////////
	
	//그 외
	private JLabel menuBar = new JLabel("상단 메뉴");//상단메뉴
	private ImageIcon exitprImage = new ImageIcon();//나가기버튼 눌렀을 때 이미지
	private ImageIcon exitunImage = new ImageIcon();//나가기버튼 누르지 않았을때 이미지
	
	private Image screenImage; // 
	private Graphics screenGraphic;//
	private Image background = new ImageIcon().getImage();//배경이미지

	public SClock() //생성자
	{
		// TODO 자동 생성된 생성자 스텁
		set(); //JFrame을 사용하기 위해 사용된 코드들이 들어있음
		
		setTextfield(); //텍스트필드로 구성된 대부분의 코드들이 들어있음 생성자가 실행시킴
      
        action(); //마우스이벤트의 코드들이 들어있으며 생성자에의해 실행됨
		buttonset();//버튼의 설정의 대부분이 들어있음 생성자가 실행시킴
		menu();
		//stopwatch();
		setlabel();//라벨관련 코드들이 들어있으며 생성자가 실행시킴
		//new Clock().start();	 
		gettime();//시간을 얻으며 알람이나 스톱워치등의 기능을 하는 코드들이 들어있고 생성자가 실행함
		
	}
	public void setTextfield() {//텍스트필드의 설정
		Font nfont = new Font("나눔고딕", Font.BOLD, 15);//font설정3(적용이 필요함)
		list.setFont(nfont);//폰트설정
		list.setEditable(false);// textArea에 직접입력 불가
		
		
		list.setBounds(40,120,300,80);//위치와 크기지정
		
        
        list.setVisible(false);//list가 보이지 않게 설정
        
        
        add(scroll);//프레임에 스크롤 추가
        add(list);//프레임에 리스트 추가
        
       }//setTextfield()의 끝
	
	public void gettime() {//시간관련
		String stopwatch;//스톱워치에 사용할 문자열 변수
		Lstopwatch.setVisible(true);//Lstopwatch가 보이지 않게 한다.
		while(true) {//무조건 실행
			
			if(i>=1) {//사용하지 않을때도 스톱워치가 작동하지 않게 하기 위해서 i를 선언했다.
				stop++;//msec를 계속 더한다.(sleep가 100이기때문에 10까지만 카운트한다.)
				if(stop>=10) { //10이상이면 실행 (10까지만 카운트)
					stop=stop-10; //10이 넘어가면 다시 0으로 만든다.
					ssec++;} //초를 하나 올린다.	
				if(ssec>=60) {//60이상이면 실행(60까지만 카운트)
					ssec=ssec-60;//60이상이면 60을 빼서 다시 0으로 만들어준다.
					smin++;}//분을 올린다.
				if(smin>=60) {//60이상이면 실행(60까지만 카운트)
					smin=smin-60;//60이상이면 60을 빼서 다시 0으로 만들어준다.
					shour++;}//시간을 올린다. 사실상 몇시간이상 사용할일이 없다고 판단해서 시간의 제한은 넣지않았다.
			}
			stopwatch=(shour+":"+smin+":"+ssec+"."+stop+" Sec");//스톱워치의 데이트를 문자열로 만든다
			Lstopwatch.setText(stopwatch);//Lstopwatch를 stopwatch(string)으로 설정해준다.
			
			
			add(Lstopwatch);//Lstopwatch를 프레임에 추가한다.
			try { //트라이 
				Thread.sleep(100);//0.1초
		    } catch(Exception e) {} //예외처리
		}//while문 끝
	}//gettime()끝
	public void setlabel() {//시간라벨 설정,알람 설명 라벨
		
		Font font = new Font("digital-7", Font.BOLD, 40);//font설정1(적용이 필요함)
		Font mfont = new Font("Dot Matrix", Font.BOLD, 20);//font설정2(적용이 필요함)
		
		
		
		swstop.setText("stop");//버튼에 stop이라는 문자를 설정한다.
		swstop.setFont(mfont);//mfont를 적용한다.
		swstop.setBackground(new Color(0,0,0,0));//백그라운드를 0,0,0,0으로 설정한다.
		swstop.setForeground(Color.white);//글자색을 하얀색으로 설정한다.
		
		
		stopreset.setFont(mfont);//mfont를 설정한다.
		stopreset.setBackground(new Color(0,0,0,0));//백그라운드를 0,0,0,0으로 설정한다.
		stopreset.setForeground(Color.white);//문자를 하얀색으로 설정한다.
		
		
		
		stopstart.setText("start");//버튼에 start라는 문자를 설정한다.
		stopstart.setFont(mfont);//mfont를 적용한다.
		stopstart.setBackground(new Color(0,0,0,0));//백그라운드를 0,0,0,0으로 설정한다.
		stopstart.setForeground(Color.white);//글자색을 하얀색으로 설정한다.
		
		
		Lstopwatch.setOpaque(true);//라벨을 불투명하게 설정
		Lstopwatch.setFont(font);//font를 적용한다.
		Lstopwatch.setBackground(new Color(0,0,0,0));//백그라운드를 0,0,0,0으로 설정한다.
		Lstopwatch.setBounds(80,70,200,50);//위치와 크기를 설정한다.
		Lstopwatch.setForeground(Color.white);//글자색을 하얀색으로 설정한다.
		
		
	}
	public void buttonset() {//여기부터 버튼설정
		
		
		stopstart.setBorderPainted(false);//버튼 테두리 설정 해제
		stopstart.setContentAreaFilled(false);//이미지 테두리 효과를 없앰
		stopstart.setFocusPainted(false);//선택했던 버튼표시 제거
		
		stopreset.setBorderPainted(false);//버튼 테두리 설정 해제
		stopreset.setContentAreaFilled(false);//이미지 테두리 효과를 없앰
		stopreset.setFocusPainted(false);//선택했던 버튼표시 제거
		
		
		
		swstop.setBorderPainted(false);//버튼 테두리 설정 해제
		swstop.setContentAreaFilled(false);//이미지 테두리 효과를 없앰
		swstop.setFocusPainted(false);//선택했던 버튼표시 제거
		
		exitbutton.setBorderPainted(false);//버튼 테두리 설정 해제
		exitbutton.setContentAreaFilled(false);//이미지 테두리 효과를 없앰
		exitbutton.setFocusPainted(false);//선택했던 버튼표시 제거
		
		//버튼위치 지정
		swstop.setBounds(50,200,100,50);//버튼크기,위치설정
		stopstart.setBounds(220,200,130,50);//버튼크기,위치설정
		exitbutton.setBounds(380, 0, 20, 20);//버튼크기,위치설정
		stopreset.setBounds(120,200,130,50);//버튼크기,위치설정
		//설정(확인버튼)
		
		Lstopwatch.setVisible(true);//버튼이 보이게 해준다.
        stopstart.setVisible(true);//버튼이 보이게 해준다.
        swstop.setVisible(true);//버튼이 보이게 해준다.
        stopreset.setVisible(true);//버튼이 보이지 않게 해준다.
        list.setVisible(true);//버튼이 보이게 해준다.
		
		//버튼추가
		add(stopreset);//JFrame에 추가
		add(swstop);//JFrame에 추가
		add(stopstart);//JFrame에 추가
		add(exitbutton);//JFrame에 추가
		
	}
	public void action() {		//마우스 눌렀을때 올렸을때 내렸을때
		exitbutton.addMouseListener(new MouseAdapter() { //나가기
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 들어갔을때
				exitbutton.setIcon(exitprImage); //이미지 설정
				exitbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));//커서설정
				}//노래 시작
			@Override
			public void mouseExited(MouseEvent e) { //마우스 나왔을때 
				exitbutton.setIcon(exitunImage);//마우스 나왔을때 이미지 설정
				exitbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}//커서설정
			@Override
			public void mousePressed(MouseEvent e) {//마우스 눌렀을때
				//소리 시작
				try {//예외처리문
					Thread.sleep(1000);//1초
				} catch (InterruptedException ex) {//예외처리
					ex.printStackTrace();}//예외처리
				System.exit(0);}});//프로그램 종료
		//
		
		
		//////
		stopstart.addMouseListener(new MouseAdapter() { //셧다운
			//커서설정
			@Override
			public void mousePressed(MouseEvent e) {//마우스 눌렀을때
				//음악 시작
				i=1;}});//i를 1로 설정
		//////
		
		/////////
		
		///
		
		//
		swstop.addMouseListener(new MouseAdapter() { //마우스 이벤트
			
			@Override
			public void mousePressed(MouseEvent e) {//마우스 눌렀을때
				 //버튼음 시작
				if(i>=1)//i가 1보다 클때
					i--;//무한대로 실행되지 않게 해줌
				
				listnum=(shour+":"+smin+":"+ssec+"."+stop+"\n");//listnum으로 모아서 스트링으로 바꿈
				list.append(listnum);//list에 listnum의 내용을 추가
				}});
		//
		stopreset.addMouseListener(new MouseAdapter() { //마우스 이벤트
			
			@Override
			public void mousePressed(MouseEvent e) {//마우스 눌렀을때
				//음악 시작
				if(i>=1)//i가 1보다 크면 실행함
					i--;//0으로 만들어서 무한대로 돌아가지 않게 해줌
				stop=0; //스톱워치에 사용할 변수  msec(1자리)
				ssec=0;//스톱워치에 사용할 변수  초
				smin=0;//스톱워치에 사용할 변수  분
				shour=0;//스톱워치에 사용할 변수 시간
				list.setText("");//list의 내용을 빈칸으로 설정해준다.
				}});
		
		//
		
		//
		
		
		
		
		}
	public void set() {
		setUndecorated(true);//프레임 안보이게 해줌
		setTitle("Y_Clock"); // 타이틀
		setSize(Main.SCREENW, Main.SCREENH); // 메인에서 가로 세로 크기 가져옴
		setLocationRelativeTo(null);// 화면 가운데서 창이 나옴
		setResizable(false);//정해진사이즈에서 변경불가
		setLayout(null);//레이아웃 설정가능
		setBackground(new Color(0, 0, 0, 0));//배경설정
		setVisible(true); // 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 안정적으로 jframe이 종료되게 해줌
		
	}
	
	public void menu() { // 상단메뉴
		menuBar.setBounds(0, 0, 400, 20);//메뉴 위치,크기지정
		menuBar.addMouseListener(new MouseAdapter() {//마우스 이벤트
			@Override
			public void mousePressed(MouseEvent e) {//마우스 눌렀을때
				mouseX = e.getX(); //x좌표를 받아 mousex에 넣는다.
				mouseY = e.getY();}});//y좌표를 받아 mousey에 넣는다.
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {//마우스 이벤트
			@Override
			public void mouseDragged(MouseEvent e) {//마우스로 드래그했을때
				int x = e.getXOnScreen();//스크린 x좌표
				int y = e.getYOnScreen();//스크린 y좌표
				setLocation(x - mouseX, y - mouseY);}}); //위치 계산
		add(menuBar);}//메뉴바를 프레임에 추가
	public void paint(Graphics g) {//그리는 함수(더블버퍼형식)
		screenImage=createImage(Main.SCREENW, Main.SCREENH);//400,300의 크기의 이미지만듬
		screenGraphic=screenImage.getGraphics();//screenGraphic에 넣어줌
		screenDraw(screenGraphic);//screenDraw부름
		g.drawImage(screenImage, 0, 0, null);}//screenimage를 그려줌
	public void screenDraw(Graphics g) {//screendraw함수
		g.drawImage(background, 0 ,0 ,null);//배경그려줌
		paintComponents(g);//add로 추가해준부분을 그려줌
		this.repaint();}}//다시그려줌