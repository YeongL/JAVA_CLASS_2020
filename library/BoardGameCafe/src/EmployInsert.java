import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EmployInsert extends JFrame{
	
	
	
	String ch_item[] = {"사장","매니저","알바"};
	JTextField nametxt = new JTextField(8);
	JTextArea memoarea = new JTextArea(4,12);
	Choice level = new Choice();
	
	JPasswordField pwtxt = new JPasswordField(8);
	JButton btn1 = new JButton("등록");
	JButton btn2 = new JButton("취소");
	JLabel name = new JLabel("이름: "); 
	JLabel auth = new JLabel("권한: "); 
	JLabel pw = new JLabel("암호: "); 
	JLabel memo = new JLabel("메모");
	
	Font font = new Font("맑은 고딕", Font.BOLD,20);
	Font font1 = new Font("맑은 고딕", Font.PLAIN,20);
	
	
	public EmployInsert()
	{
		
		setTitle("직원 등록");
		name.setFont(font);
		auth.setFont(font);
		pw.setFont(font);
		nametxt.setFont(font1);
		pwtxt.setFont(font1);
		level.setFont(font1);
		btn1.setFont(font);
		btn2.setFont(font);
		memo.setFont(font);
		
		memoarea.setFont(font1);
		JScrollPane sp = new JScrollPane(memoarea);
		
		
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//
		panel.add(name);
		panel.add(nametxt);
		
		c.add(panel);
		//
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(auth);
		
		for(String str:ch_item)
		{
			level.add(str);
		}
		panel.add(level);
		c.add(panel);
		//
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel.add(pw);
		pwtxt.setEchoChar('*');
		panel.add(pwtxt);
		c.add(panel);
		//
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(memo);
		c.add(panel);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel.add(sp);
		c.add(panel);
		
		
		
		
		
		
		//
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		btn1.setPreferredSize(new Dimension(90,50));
		btn2.setPreferredSize(new Dimension(90,50));
		btn1.addActionListener(new ButtonActionListener());
		btn2.addActionListener(new ButtonActionListener());
		
		panel.add(btn1);
		panel.add(btn2);
		c.add(panel);
		//
		
		
		
		
		setSize(240,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class ButtonActionListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
	        	String cmd = e.getActionCommand();
	        	switch (cmd) { // 메뉴 아이템의 종류 구분
	            case "등록":
	            	String empname = nametxt.getText();
	            	String empauth = level.getSelectedItem();
	            	String emppw = "";
	            	char[] secret_pw = pwtxt.getPassword();
	            	//숫자인지 확인
	            	for(char cha:secret_pw)
	            	{
	            		if(cha>'9' || cha<'0')
	            		{
	            			JOptionPane.showMessageDialog(null, "비밀번호가 숫자가 아닙니다. 다시 입력하세요","오류!",JOptionPane.ERROR_MESSAGE);
	            			break;
	            		}
	            		else
	            		{
	            			Character.toString(cha);
	            			emppw+=(emppw.equals(""))? ""+cha+"" : ""+cha+"";
	            		}
	            	}
	            	//PK 값이 겹치지 않는지 확인
	                if(emppw.length()==secret_pw.length)
	                {
	                	
	                }
	            	dispose();
	            	break;
	            case "취소":
	                dispose();
	            	break;
	        	}
		 }
	}
	
	
}
