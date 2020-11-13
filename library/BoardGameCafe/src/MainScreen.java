import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainScreen extends JFrame {

	
	
	
	MainScreen()
	{
		setTitle("정산 시스템");
		createMenu();
		setSize(1600,1000);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	void createMenu()
	{
		JMenuBar mb = new JMenuBar();
		JMenu empMan = new JMenu("직원 관리");
		JMenu money = new JMenu("정산");
		JMenu menuMan = new JMenu("메뉴 관리");
		
		JMenuItem m1 = new JMenuItem("직원 등록");
		JMenuItem m2 = new JMenuItem("직원 해제");
		JMenuItem m3 = new JMenuItem("직원 권한변경");
		JMenuItem m4 = new JMenuItem("시간당 요금");
		JMenuItem m5 = new JMenuItem("음료 요금");
		JMenuItem m6 = new JMenuItem("음료 관리");
		JMenuItem m7 = new JMenuItem("요금제 관리");
		
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

}
