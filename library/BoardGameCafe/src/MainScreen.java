import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class MainScreen extends JFrame implements ActionListener {

	Vo v = new Vo();
	class Vo{
		Vo()
		{
			
		}
	}
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
	private JButton tab1, tab2, tab3, tab4, tab5, tab6, tab7, tab8, tab9, tab10, tab11, tab12, tab13, tab14, tab15;
	private JPopupMenu popup = new JPopupMenu("초기 팝업");
	private JPopupMenu popup2 = new JPopupMenu("true일때 팝업");
	public static int cnum = 0;
	// 테이블이 가동중이지 않다
	private boolean t1 = false;
	private boolean t2 = false;
	private boolean t3 = false;
	private boolean t4 = false;
	private boolean t5 = false;
	private boolean t6 = false;
	private boolean t7 = false;
	private boolean t8 = false;
	private boolean t9 = false;
	private boolean t10 = false;
	private boolean t11 = false;
	private boolean t12 = false;
	private boolean t13 = false;
	private boolean t14 = false;
	private boolean t15 = false;
	// 팝업메뉴 아이템
	JMenuItem m_start = new JMenuItem("시작");
	JMenuItem m_calc = new JMenuItem("정산");
	JMenuItem m_people = new JMenuItem("인원 수정");
	JMenuItem m_order = new JMenuItem("음료 주문");
	JMenuItem m_delete = new JMenuItem("취소");

	// 시간 관련 아이템
	private JPanel times;
	private JLabel hour_jl;
	private JLabel min_jl;
	private JLabel sec_jl;
	private JLabel colon_t1;
	private JLabel colon_t2;
	private JLabel colon_comma;
	private long hour = 0;
	private long min = 0;
	private long sec = 0;
	private String hour_str = "";
	private String min_str = "";
	private String sec_str = "";
	private boolean is;
	Date start_date = new Date();
	long start_time = 0;
	long check_time = 0;
	long compare_time = 0;

	// 나중에 지울거
	private JButton start;
	private JButton end;
	private JButton reset;
	private JButton tmpbtn;

	MainScreen() {
		setTitle("정산 시스템");

		createMenu();
		createTable();
		setSize(1600, 1000);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		tab1 = new JButton("1");
		tab2 = new JButton("2");
		tab3 = new JButton("3");
		tab4 = new JButton("4");
		tab5 = new JButton("5");
		tab6 = new JButton("6");
		tab7 = new JButton("7");
		tab8 = new JButton("8");
		tab9 = new JButton("9");
		tab10 = new JButton("10");
		tab11 = new JButton("11");
		tab12 = new JButton("12");
		tab13 = new JButton("13");
		tab14 = new JButton("14");
		tab15 = new JButton("15");

		popup.add(m_start);
		popup2.add(m_calc);
		popup2.add(m_people);
		popup2.add(m_order);
		popup2.add(m_delete);

		// 각 버튼에 대한 이벤트 설정
		PopupMouseListener listener = new PopupMouseListener();
		tab1.addMouseListener(listener);
		tab2.addMouseListener(listener);
		tab3.addMouseListener(listener);
		tab4.addMouseListener(listener);
		tab5.addMouseListener(listener);
		tab6.addMouseListener(listener);
		tab7.addMouseListener(listener);
		tab8.addMouseListener(listener);
		tab9.addMouseListener(listener);
		tab10.addMouseListener(listener);
		tab11.addMouseListener(listener);
		tab12.addMouseListener(listener);
		tab13.addMouseListener(listener);
		tab14.addMouseListener(listener);
		tab15.addMouseListener(listener);

		PopupActionListener listener1 = new PopupActionListener();

		m_start.addActionListener(listener1);
		m_calc.addActionListener(listener1);
		m_people.addActionListener(listener1);
		m_order.addActionListener(listener1);
		m_delete.addActionListener(listener1);

		// 레이아웃 설정
		this.setLayout(new GridLayout(3, 5));
		this.getContentPane().add(tab1);
		this.getContentPane().add(tab2);
		this.getContentPane().add(tab3);
		this.getContentPane().add(tab4);
		this.getContentPane().add(tab5);
		this.getContentPane().add(tab6);
		this.getContentPane().add(tab7);
		this.getContentPane().add(tab8);
		this.getContentPane().add(tab9);
		this.getContentPane().add(tab10);
		this.getContentPane().add(tab11);
		this.getContentPane().add(tab12);
		this.getContentPane().add(tab13);
		this.getContentPane().add(tab14);
		this.getContentPane().add(tab15);

	}

	public static void setCnum(int num) {
		cnum = num;
	}

	class PopupActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int tablenum = 0;
			if (tmpbtn == tab1) {
				tablenum = 1;
			} else if (tmpbtn == tab2) {
				tablenum = 2;
			} else if (tmpbtn == tab3) {
				tablenum = 3;
			} else if (tmpbtn == tab4) {
				tablenum = 4;
			} else if (tmpbtn == tab5) {
				tablenum = 5;
			} else if (tmpbtn == tab6) {
				tablenum = 6;
			} else if (tmpbtn == tab7) {
				tablenum = 7;
			} else if (tmpbtn == tab8) {
				tablenum = 8;
			} else if (tmpbtn == tab9) {
				tablenum = 9;
			} else if (tmpbtn == tab10) {
				tablenum = 10;
			} else if (tmpbtn == tab11) {
				tablenum = 11;
			} else if (tmpbtn == tab12) {
				tablenum = 12;
			} else if (tmpbtn == tab13) {
				tablenum = 13;
			} else if (tmpbtn == tab14) {
				tablenum = 14;
			} else if (tmpbtn == tab15) {
				tablenum = 15;
			}
			String cmd = e.getActionCommand();
			switch (cmd) { // 메뉴 아이템의 종류 구분
			case "시작":
				System.out.println("start " + tablenum);

				CustomerInsert c = new CustomerInsert();
				//if (!c.isActive()) {
			    //    throw new RuntimeException("Test Failed: frame isn't active");
			    //}
				System.out.println("고객 수: " + cnum + ", 테이블 번호: " + tablenum);
				
				
				//if (cnum != 0) {
				//	t1 = !t1;
				//}
				
				break;
			case "정산":
				System.out.println("calc");
				break;
			case "인원 수정":
				System.out.println("people");
				break;
			case "음료 주문":
				System.out.println("order");
				break;
			case "취소":
				System.out.println("delete reached " + tablenum);
				switch (tablenum) {
				case 1:
					t1 = !t1;
					break;
				case 2:
					t2 = !t2;
					break;
				case 3:
					t3 = !t3;
					break;
				case 4:
					t4 = !t4;
					break;
				case 5:
					t5 = !t5;
					break;
				case 6:
					t6 = !t6;
					break;
				case 7:
					t7 = !t7;
					break;
				case 8:
					t8 = !t8;
					break;
				case 9:
					t9 = !t9;
					break;
				case 10:
					t10 = !t10;
					break;
				case 11:
					t11 = !t11;
					break;
				case 12:
					t12 = !t12;
					break;
				case 13:
					t13 = !t13;
					break;
				case 14:
					t14 = !t14;
					break;
				case 15:
					t15 = !t15;
					break;
				}
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
			if (tmpbtn == tab1) {
				if (!t1) {
					tab1.setComponentPopupMenu(popup);
					t1 = !t1;
				} else {
					tab1.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab2) {
				if (!t2) {
					tab2.setComponentPopupMenu(popup);
					t2 = !t2;
				} else {
					tab2.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab3) {
				if (!t3) {
					tab3.setComponentPopupMenu(popup);
					t3 = !t3;
				} else {
					tab3.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab4) {
				if (!t4) {
					tab4.setComponentPopupMenu(popup);
					t4 = !t4;
				} else {
					tab4.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab5) {
				if (!t5) {
					tab5.setComponentPopupMenu(popup);
					t5 = !t5;
				} else {
					tab5.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab6) {
				if (!t6) {
					tab6.setComponentPopupMenu(popup);
					t6 = !t6;
				} else {
					tab6.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab7) {
				if (!t7) {
					tab7.setComponentPopupMenu(popup);
					t7 = !t7;
				} else {
					tab7.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab8) {
				if (!t8) {
					tab8.setComponentPopupMenu(popup);
					t8 = !t8;
				} else {
					tab8.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab9) {
				if (!t9) {
					tab9.setComponentPopupMenu(popup);
					t9 = !t9;
				} else {
					tab9.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab10) {
				if (!t10) {
					tab10.setComponentPopupMenu(popup);
					t10 = !t10;
				} else {
					tab10.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab11) {
				if (!t11) {
					tab11.setComponentPopupMenu(popup);
					t11 = !t11;
				} else {
					tab11.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab12) {
				if (!t12) {
					tab12.setComponentPopupMenu(popup);
					t12 = !t12;
				} else {
					tab12.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab13) {
				if (!t13) {
					tab13.setComponentPopupMenu(popup);
					t13 = !t13;
				} else {
					tab13.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab14) {
				if (!t14) {
					tab14.setComponentPopupMenu(popup);
					t14 = !t14;
				} else {
					tab14.setComponentPopupMenu(popup2);
				}
			}
			if (tmpbtn == tab15) {
				if (!t15) {
					tab15.setComponentPopupMenu(popup);
					t15 = !t15;
				} else {
					tab15.setComponentPopupMenu(popup2);
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

	public void resetTimes() {
		hour_jl.setText("00");
		min_jl.setText("00");
		sec_jl.setText("00");
		is = false;
		repaint();

	}

	public void setTimes() {
		hour = Integer.parseInt(hour_jl.getText());
		min = Integer.parseInt(min_jl.getText());
		sec = Integer.parseInt(sec_jl.getText());

		while (is) {

			Date check_date = new Date();
			check_time = check_date.getTime();

			// time 처리 부분
			compare_time = check_time - start_time;
			String one = compare_time / 1000 + "";
			int totalsec = Integer.parseInt(one, 10);
			String two = totalsec / 60 + "";
			int totalmin = Integer.parseInt(two, 10);
			sec = totalsec % 60;
			String three = totalmin / 60 + "";
			hour = Integer.parseInt(three, 10);
			min = totalmin % 60;

			if (sec == 60) {
				sec = 0;
				min++;
			}

			if (min == 60) {
				min = 0;
				hour++;
			}

			hour_str = String.format("%02d", hour);
			min_str = String.format("%02d", min);
			sec_str = String.format("%02d", sec);

			hour_jl.setText(hour_str);
			min_jl.setText(min_str);
			sec_jl.setText(sec_str);
		}

	}

	class TimeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton) e.getSource();
			if (jb == start) {
				start_time = start_date.getTime();
				is = true;
				reset.setEnabled(false);
				end.setEnabled(true);
			} else if (jb == end) {
				is = false;
				reset.setEnabled(true);
				end.setEnabled(false);
			} else if (jb == reset) {
				start_date = new Date();
				start_time = start_date.getTime();
				resetTimes();
				reset.setEnabled(false);
			}
		}
	}

	public void init() {

		// String 값을 담을 Panel을 생성
		times = new JPanel();

		// 시간 정보를 담을 Label 생성
		hour_jl = new JLabel();
		min_jl = new JLabel();
		sec_jl = new JLabel();
		colon_t1 = new JLabel(":");
		colon_t2 = new JLabel(":");
		colon_comma = new JLabel(".");

		// String font 설정
		Font font2 = new Font("굴림", Font.PLAIN, 50); // font name, font type, font size
		Font font_sub = new Font("굴림", Font.PLAIN, 30);

		// font 설정
		hour_jl.setFont(font2);
		min_jl.setFont(font2);
		sec_jl.setFont(font2);
		colon_t1.setFont(font2);
		colon_t2.setFont(font2);
		colon_comma.setFont(font_sub);

		// JLabel 에 각각의 입력 값(String)을 배치 (.setText)
		hour_str = String.format("%02d", hour);
		min_str = String.format("%02d", min);
		sec_str = String.format("%02d", sec);

		hour_jl.setText(hour_str);
		min_jl.setText(min_str);
		sec_jl.setText(sec_str);

		// String 내용을 패널에 담는다.
		times.add(hour_jl);
		times.add(colon_t1);
		times.add(min_jl);
		times.add(colon_t2);
		times.add(sec_jl);
		times.add(colon_comma);

		// frm.add("North", times);

	}

	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String cmd = e.getActionCommand();
			switch (cmd) { // 메뉴 아이템의 종류 구분
			case "직원 등록":
				new EmployInsert();
				break;
			case "직원 해제":

				break;
			case "직원 권한변경":

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
