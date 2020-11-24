import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerInsert implements ActionListener{
	JFrame frame = new JFrame();
	JTextField cusnumtxt = new JTextField(8);
	JLabel numbers = new JLabel("�ο�: ");
	JButton btn1 = new JButton("Ȯ��");
	JButton btn2 = new JButton("���");
	int cnum = 0;
	int tablenum = 0;
	Font font = new Font("���� ���", Font.BOLD, 20);
	Font font1 = new Font("���� ���", Font.PLAIN, 20);
	
	public CustomerInsert(int tablenum) {
		this.tablenum = tablenum;
		frame.setTitle("�ο��� �Է�");
		numbers.setFont(font);
		cusnumtxt.setFont(font1);
		btn1.setFont(font);
		btn2.setFont(font);

		Container c = frame.getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//
		panel.add(numbers);
		panel.add(cusnumtxt);
		cusnumtxt.setHorizontalAlignment(SwingConstants.RIGHT);
		cusnumtxt.registerKeyboardAction(this, "Ȯ��", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_FOCUSED);
		//cusnumtxt.requestFocus();
		c.add(panel);

		//
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		btn1.setPreferredSize(new Dimension(90, 50));
		btn2.setPreferredSize(new Dimension(90, 50));
		btn1.setActionCommand("Ȯ��");
		btn2.setActionCommand("���");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		panel.add(btn1);
		panel.add(btn2);
		c.add(panel);
		//

		frame.setSize(240, 200);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public int getCnum()
	{
		return this.cnum; 
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		switch (cmd) { // �޴� �������� ���� ����
		case "Ȯ��":
			
			String cusnum = cusnumtxt.getText();
			cnum = 0;
			// �������� Ȯ��
			for (int i = 0; i < cusnum.length(); i++) {
				if (cusnum.charAt(i) > '9' || cusnum.charAt(i) < '0') {
					JOptionPane.showMessageDialog(null, "���ڰ� �ƴմϴ�. �ٽ� �Է��ϼ���", "����!", JOptionPane.ERROR_MESSAGE);
					break;
				} else {
					cnum = Integer.parseInt(cusnum);
				}
			}
			if (cnum != 0) {
				MainScreen.setCnum(tablenum, cnum);
				MainScreen.timers[tablenum].CustomerNumber.setText(Integer.toString(cnum)+"��");;
				frame.dispose();
			}

			break;
		case "���":
			MainScreen.timers[tablenum].resetTimes();
			MainScreen.tables[tablenum].isActive = false;
			MainScreen.tables[tablenum].table.setBackground(new Color(204, 255, 153));
			frame.dispose();
			break;
		}
	}

	
}
