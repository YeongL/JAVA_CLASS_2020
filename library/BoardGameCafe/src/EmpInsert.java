import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EmpInsert extends JFrame implements ActionListener{
	
	
	
	String ch_item[] = {"����","�Ŵ���","����"};
	JTextField nametxt = new JTextField(8);
	Choice level = new Choice();
	
	JPasswordField pwtxt = new JPasswordField(8);
	JButton btn1 = new JButton("���");
	JButton btn2 = new JButton("���");
	JLabel name = new JLabel("�̸�: "); 
	JLabel auth = new JLabel("����: "); 
	JLabel pw = new JLabel("��ȣ: "); 
	
	Font font = new Font("���� ���", Font.BOLD,20);
	Font font1 = new Font("���� ���", Font.PLAIN,20);
	
	
	public EmpInsert()
	{
		
		setTitle("���� ���");
		name.setFont(font);
		auth.setFont(font);
		pw.setFont(font);
		nametxt.setFont(font1);
		pwtxt.setFont(font1);
		level.setFont(font1);
		btn1.setFont(font);
		btn2.setFont(font);
		
		
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
		c.add(panel);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		c.add(panel);
		
		
		nametxt.registerKeyboardAction(this, "���", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_FOCUSED);
		pwtxt.registerKeyboardAction(this, "���", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_FOCUSED);
		
		
		
		
		//
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		btn1.setPreferredSize(new Dimension(90,50));
		btn2.setPreferredSize(new Dimension(90,50));
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		panel.add(btn1);
		panel.add(btn2);
		c.add(panel);
		//
		
		
		
		
		setSize(240,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
    	switch (cmd) { // �޴� �������� ���� ����
        case "���":
        	String empname = nametxt.getText();
        	String empauth = level.getSelectedItem();
        	String emppw = "";
        	char[] secret_pw = pwtxt.getPassword();
        	for(char cha:secret_pw)
        	{
        		Character.toString(cha);
        		emppw+=(emppw.equals(""))? ""+cha+"" : ""+cha+"";
        	}
        	//PW ���� ��ġ�� �ʴ��� Ȯ��
        	EmpDBSelectPW edbs = new EmpDBSelectPW(emppw);
            if(edbs.getUnique() && !emppw.equals("") && !empname.equals(""))
            {
            	new EmpDBInsert(empname, empauth, emppw);
            	dispose();
            }
            else if(emppw.equals("") || empname.equals(""))
            {
            	JOptionPane.showMessageDialog(null, "�̸� �Ǵ� ��й�ȣ�� �Է����ּ���. �ٽ� �Է��ϼ���","����!",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
            	JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ������ȣ�Դϴ�. �ٽ� �Է��ϼ���","����!",JOptionPane.ERROR_MESSAGE);
            }
        	
        	
        	
        	break;
        case "���":
            dispose();
        	break;
    	}
	}
	
	
}
