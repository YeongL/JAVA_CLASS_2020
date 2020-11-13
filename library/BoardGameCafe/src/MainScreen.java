import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainScreen extends JFrame {

	
	
	
	MainScreen()
	{
		setTitle("���� �ý���");
		createMenu();
		setSize(1600,1000);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	void createMenu()
	{
		JMenuBar mb = new JMenuBar();
		JMenu empMan = new JMenu("���� ����");
		JMenu money = new JMenu("����");
		JMenu menuMan = new JMenu("�޴� ����");
		
		JMenuItem m1 = new JMenuItem("���� ���");
		JMenuItem m2 = new JMenuItem("���� ����");
		JMenuItem m3 = new JMenuItem("���� ���Ѻ���");
		JMenuItem m4 = new JMenuItem("�ð��� ���");
		JMenuItem m5 = new JMenuItem("���� ���");
		JMenuItem m6 = new JMenuItem("���� ����");
		JMenuItem m7 = new JMenuItem("����� ����");
		
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
	        	switch (cmd) { // �޴� �������� ���� ����
	            case "���� ���":
	                new EmployInsert();
	            	break;
	            case "���� ����":
	                
	            	break;
	            case "���� ���Ѻ���":
	                
	            	break;
	            case "�ð��� ���":
	                
	            	break;
	            case "���� ���":
	            	break;
	           
	            case "���� ����":
	            	break;
	            case "����� ����":
	            	break;
	            	
	        	}
		 }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainScreen();
	}

}
