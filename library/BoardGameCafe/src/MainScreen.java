import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class MainScreen extends JFrame implements ActionListener{
	// font 설정
	Font font = new Font("맑은 고딕", Font.BOLD, 20);
	Font font1 = new Font("맑은 고딕", Font.PLAIN, 20);

	//요금제 인트값
	public static int hourlyCost = 3000;
	
	// menubar 관련 아이템 설정
	private JMenuBar mb = new JMenuBar();
	private JMenu empMan = new JMenu("직원 관리");
	private JMenu money = new JMenu("정산");
	private JMenu menuMan = new JMenu("메뉴 관리");

	private JMenuItem m1 = new JMenuItem("직원 등록");
	private JMenuItem m2 = new JMenuItem("직원 해제");
	private JMenuItem m3 = new JMenuItem("직원 권한변경");
	private JMenuItem m4 = new JMenuItem("시간당 요금");
	private JMenuItem m5 = new JMenuItem("음료 요금");
	private JMenuItem m6 = new JMenuItem("음료 관리");
	private JMenuItem m7 = new JMenuItem("요금제 관리");

	// table 관련 아이템 설정
	public static Table[] tables = new Table[15];
	public static Timer[] timers = new Timer[15];
	
	
	private JPopupMenu popup = new JPopupMenu("초기 팝업");
	private JPopupMenu popup2 = new JPopupMenu("true일때 팝업");
	private JPanel tmpPanel;
	
	// 팝업메뉴 아이템
	JMenuItem m_start = new JMenuItem("시작");
	JMenuItem m_calc = new JMenuItem("정산");
	JMenuItem m_people = new JMenuItem("인원 수정");
	JMenuItem m_order = new JMenuItem("음료 주문");
	JMenuItem m_delete = new JMenuItem("취소");

	// 시간 관련 아이템
	Runnable threads[] = new TimerThread[15];

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainScreen();
	}
	
	MainScreen() {
		setTitle("정산 시스템");
		
		createMenu();
		createTable();
		setSize(1600, 1000);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i=0;i<15;i++)
		{
			threads[i] = new TimerThread(i);
			
		}
		for(int i=0;i<15;i++)
		{
			Thread t = new Thread(threads[i]);
			t.start();
			
		}
		
		
		

	}

	void createMenu() {
		
		empMan.setFont(font);
		money.setFont(font);
		menuMan.setFont(font);
		m1.setFont(font1);
		m2.setFont(font1);
		m3.setFont(font1);
		m4.setFont(font1);
		m5.setFont(font1);
		m6.setFont(font1);
		m7.setFont(font1);

		m1.addActionListener(new MenuActionListener());
		m2.addActionListener(new MenuActionListener());
		m3.addActionListener(new MenuActionListener());
		m4.addActionListener(new MenuActionListener());
		m5.addActionListener(new MenuActionListener());
		m6.addActionListener(new MenuActionListener());
		m7.addActionListener(new MenuActionListener());

		empMan.add(m1);
		empMan.add(m2);
		empMan.add(m3);

		money.add(m4);
		money.add(m5);

		menuMan.add(m6);
		menuMan.add(m7);

		mb.add(empMan);
		mb.add(money);
		mb.add(menuMan);

		setJMenuBar(mb);

	}

	void createTable() {
		//초기화
		for(int i=0;i<15;i++)
		{
			tables[i] = new Table();
			timers[i] = new Timer();
		}
		//정의
		LineBorder tb = new LineBorder(Color.black,5,true);
		//tb.setTitleColor(Color.black);
		
		// 각 버튼에 대한 이벤트 설정
		PopupMouseListener listener = new PopupMouseListener();
		for(int i=0;i<15;i++)
		{	
			tables[i].table.setBackground(new Color(204, 255, 153));
			tables[i].tnum.setText(Integer.toString(i));
			tables[i].tnum.setFont(font);
			tables[i].tableNum = i;
			
			timers[i].tableNum = i;
			timers[i].Lstopwatch.setFont(font);
			timers[i].CustomerNumber.setFont(font);
			tables[i].table.addMouseListener(listener);
			tables[i].table.add(tables[i].one);
			tables[i].table.add(tables[i].two);
			tables[i].table.add(tables[i].three);
			tables[i].one.add(tables[i].tnum);
			tables[i].two.add(timers[i].Lstopwatch);
			tables[i].three.add(timers[i].CustomerNumber);
			tables[i].table.setBorder(tb);
			this.add(tables[i].table);
		}
		
		popup.add(m_start);
		popup2.add(m_calc);
		popup2.add(m_people);
		popup2.add(m_order);
		popup2.add(m_delete);

		

		PopupActionListener listener1 = new PopupActionListener();

		m_start.addActionListener(listener1);
		m_calc.addActionListener(listener1);
		m_people.addActionListener(listener1);
		m_order.addActionListener(listener1);
		m_delete.addActionListener(listener1);

		// 레이아웃 설정
		this.setLayout(null);
		tables[0].table.setBounds(100, 25, 200, 200);
		tables[1].table.setBounds(400, 25, 200, 200);
		tables[2].table.setBounds(700, 25, 200, 200);
		tables[3].table.setBounds(1000, 25, 200, 200);
		tables[4].table.setBounds(1300, 25, 200, 200);
		tables[5].table.setBounds(100, 330, 200, 200);
		tables[6].table.setBounds(400, 330, 200, 200);
		tables[7].table.setBounds(700, 330, 200, 200);
		tables[8].table.setBounds(1000, 330, 200, 200);
		tables[9].table.setBounds(1300, 330, 200, 200);
		tables[10].table.setBounds(100, 635, 200, 200);
		tables[11].table.setBounds(400, 635, 200, 200);
		tables[12].table.setBounds(700, 635, 200, 200);
		tables[13].table.setBounds(1000, 635, 200, 200);
		tables[14].table.setBounds(1300, 635, 200, 200);

		
		

	}

	public static void setCnum(int tablenum, int customernum) {
		tables[tablenum].customerNumber = customernum;
	}

	class PopupActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int tablenum = 0;
			for(int i=0;i<15;i++)
			{
				if (tmpPanel == tables[i].table) {
					tablenum = i;
				}
			}
			
			String cmd = e.getActionCommand();
			switch (cmd) { // 메뉴 아이템의 종류 구분
			case "시작":
				System.out.println("start " + tables[tablenum].tableNum);
				new CustomerInsert(tablenum);
				tables[tablenum].isActive = true;
				//시간 관련
				timers[tablenum].isActive = true;
				
				//버튼 색깔 변화시킴.
				tables[tablenum].table.setBackground(new Color(255,153,153));
				
				break;
			case "정산":
				System.out.println(tables[tablenum].tableNum+"번 테이블 "+tables[tablenum].customerNumber+"명 요금을 정산합니다.");
				//시간 스탑
				timers[tablenum].isActive = false;
				timers[tablenum].listnum=(String.format("%02d", timers[tablenum].shour)+":"+String.format("%02d", timers[tablenum].smin)+":"+String.format("%02d", timers[tablenum].ssec)+"\n");
				tables[tablenum].tableTime = timers[tablenum].listnum;
				tables[tablenum].tableMin = timers[tablenum].smin+timers[tablenum].shour*60;
				new CalculateTime(tablenum);
				//사용 끝났으면 초기화, 시간 이벤트는 버튼 안에 넣어놨다.
				
				break;
			case "인원 수정":
				System.out.println("인원을 변경합니다.");
				new CustomerInsert(tablenum);
				break;
			case "음료 주문":
				System.out.println("order");
				break;
			case "취소":
				System.out.println("delete reached customernum: " + tables[tablenum].customerNumber);
				tables[tablenum].isActive = false;
				//안쓰니까 초기화
				//시간 관련
				timers[tablenum].resetTimes();
				//버튼 관련
				tables[tablenum].table.setBackground(new Color(204, 255, 153));
				break;

			}
			

		}

	}

	class PopupMouseListener implements MouseListener {

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			tmpPanel = new JPanel();
			tmpPanel = (JPanel) e.getSource();
			for(int i=0;i<15;i++)
			{
				if (tmpPanel == tables[i].table) {
					if (!tables[i].isActive) {
						tables[i].table.setComponentPopupMenu(popup);
						
					} else {
						tables[i].table.setComponentPopupMenu(popup2);
					}
				}
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}



	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String cmd = e.getActionCommand();
			switch (cmd) { // 메뉴 아이템의 종류 구분
			case "직원 등록":
				new EmpInsert();
				break;
			case "직원 해제":
				new EmpDelete();
				break;
			case "직원 권한변경":
				new AuthChange();
				break;
			case "시간당 요금":
				new SalesTableTime();
				break;
			case "음료 요금":
				break;

			case "음료 관리":
				break;
			case "요금제 관리":
				break;

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


	
	
}

