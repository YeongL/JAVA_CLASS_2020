import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class EmployInsert extends JFrame{
	
	JTextField nametxt = new JTextField(15);
	Choice level = new Choice();
	String ch_item[] = {"����","�Ŵ���","�˹�"};
	JPasswordField pwtxt = new JPasswordField(13);
	Button btn1,btn2;
	
	public EmployInsert()
	{
		setTitle("���� ���");
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//
		panel.add(new JLabel("�̸�: "));
		panel.add(nametxt);
		c.add(panel);
		//
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(new JLabel("����: "));
		
		for(String str:ch_item)
		{
			level.add(str);
		}
		panel.add(level);
		c.add(panel);
		//
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel.add(new JLabel("��й�ȣ: "));
		pwtxt.setEchoChar('*');
		panel.add(pwtxt);
		c.add(panel);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		
		setSize(240,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
