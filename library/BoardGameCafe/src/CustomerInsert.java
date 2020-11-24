import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerInsert implements ActionListener{
	JFrame frame = new JFrame();
	JTextField cusnumtxt = new JTextField(8);
	JLabel numbers = new JLabel("인원: ");
	JButton btn1 = new JButton("확인");
	JButton btn2 = new JButton("취소");
	int cnum = 0;
	int tablenum = 0;
	Font font = new Font("맑은 고딕", Font.BOLD, 20);
	Font font1 = new Font("맑은 고딕", Font.PLAIN, 20);
	
	public CustomerInsert(int tablenum) {
		this.tablenum = tablenum;
		frame.setTitle("인원수 입력");
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
		cusnumtxt.registerKeyboardAction(this, "확인", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_FOCUSED);
		//cusnumtxt.requestFocus();
		c.add(panel);

		//
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		btn1.setPreferredSize(new Dimension(90, 50));
		btn2.setPreferredSize(new Dimension(90, 50));
		btn1.setActionCommand("확인");
		btn2.setActionCommand("취소");
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
		switch (cmd) { // 메뉴 아이템의 종류 구분
		case "확인":
			
			String cusnum = cusnumtxt.getText();
			cnum = 0;
			// 숫자인지 확인
			for (int i = 0; i < cusnum.length(); i++) {
				if (cusnum.charAt(i) > '9' || cusnum.charAt(i) < '0') {
					JOptionPane.showMessageDialog(null, "숫자가 아닙니다. 다시 입력하세요", "오류!", JOptionPane.ERROR_MESSAGE);
					break;
				} else {
					cnum = Integer.parseInt(cusnum);
				}
			}
			if (cnum != 0) {
				MainScreen.setCnum(tablenum, cnum);
				MainScreen.timers[tablenum].CustomerNumber.setText(Integer.toString(cnum)+"명");;
				frame.dispose();
			}

			break;
		case "취소":
			MainScreen.timers[tablenum].resetTimes();
			MainScreen.tables[tablenum].isActive = false;
			MainScreen.tables[tablenum].table.setBackground(new Color(204, 255, 153));
			frame.dispose();
			break;
		}
	}

	
}
