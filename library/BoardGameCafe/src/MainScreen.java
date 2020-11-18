import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class MainScreen extends JFrame implements ActionListener{
	// font 설정
	Font font = new Font("맑은 고딕", Font.BOLD, 20);
	Font font1 = new Font("맑은 고딕", Font.PLAIN, 20);

	
	
	
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
	private JPanel panel;
	public static Table[] tables = new Table[15];
	public static Timer[] timers = new Timer[15];
	
	
	private JPopupMenu popup = new JPopupMenu("초기 팝업");
	private JPopupMenu popup2 = new JPopupMenu("true일때 팝업");
	private JButton tmpbtn;
	
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
		panel = new JPanel();
		for(int i=0;i<15;i++)
		{
			tables[i] = new Table();
			timers[i] = new Timer();
		}
		
		for(int i=0;i<15;i++)
		{
			tables[i].table = new JButton(Integer.toString(i));
			tables[i].table.setFont(font);
			tables[i].tableNum = i;
			timers[i].tableNum = i;
			timers[i].Lstopwatch.setFont(font);
		}
		
		popup.add(m_start);
		popup2.add(m_calc);
		popup2.add(m_people);
		popup2.add(m_order);
		popup2.add(m_delete);

		// 각 버튼에 대한 이벤트 설정
		PopupMouseListener listener = new PopupMouseListener();
		
		for(int i=0;i<15;i++)
		{
			tables[i].table.addMouseListener(listener);
			timers[i].timerPanel.add(timers[i].Lstopwatch);
		}
//		
//       
		

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
		timers[0].timerPanel.setBounds(100, 225, 200, 80);
		timers[1].timerPanel.setBounds(400, 225, 200, 80);
		timers[2].timerPanel.setBounds(700, 225, 200, 80);
		timers[3].timerPanel.setBounds(1000, 225, 200, 80);
		timers[4].timerPanel.setBounds(1300, 225, 200, 80);
		timers[5].timerPanel.setBounds(100, 530, 200, 80);
		timers[6].timerPanel.setBounds(400, 530, 200, 80);
		timers[7].timerPanel.setBounds(700, 530, 200, 80);
		timers[8].timerPanel.setBounds(1000, 530, 200, 80);
		timers[9].timerPanel.setBounds(1300, 530, 200, 80);
		timers[10].timerPanel.setBounds(100, 835, 200, 80);
		timers[11].timerPanel.setBounds(400, 835, 200, 80);
		timers[12].timerPanel.setBounds(700, 835, 200, 80);
		timers[13].timerPanel.setBounds(1000, 835, 200, 80);
		timers[14].timerPanel.setBounds(1300, 835, 200, 80);
		for(int i=0;i<15;i++)
		{
			
			this.add(tables[i].table);
			this.add(timers[i].timerPanel);
			
		}
		

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
				if (tmpbtn == tables[i].table) {
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
				
				break;
			case "정산":
				System.out.println(tables[tablenum].tableNum+"번 테이블 "+tables[tablenum].customerNumber+"명 요금을 정산합니다.");
				//시간 스탑
				timers[tablenum].isActive = false;
				timers[tablenum].listnum=(timers[tablenum].shour+":"+timers[tablenum].smin+":"+timers[tablenum].ssec+"\n");
				new Calculate();
				//사용 끝났으면 초기화
				timers[tablenum].resetTimes();
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
				//시간 관련
				timers[tablenum].resetTimes();
				//사용 끝났으면 초기화
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
			tmpbtn = new JButton();
			tmpbtn = (JButton) e.getSource();
			for(int i=0;i<15;i++)
			{
				if (tmpbtn == tables[i].table) {
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

				break;
			case "직원 권한변경":
				new AuthChange();
				break;
			case "시간당 요금":

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

