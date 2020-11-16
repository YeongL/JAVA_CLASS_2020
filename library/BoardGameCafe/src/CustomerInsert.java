import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerInsert extends JFrame {

	JTextField cusnumtxt = new JTextField(8);
	JLabel numbers = new JLabel("인원: ");
	JButton btn1 = new JButton("확인");
	JButton btn2 = new JButton("취소");
	int cnum = 0;

	Font font = new Font("맑은 고딕", Font.BOLD, 20);
	Font font1 = new Font("맑은 고딕", Font.PLAIN, 20);

	public CustomerInsert() {
		setTitle("인원수 입력");
		numbers.setFont(font);
		cusnumtxt.setFont(font1);
		btn1.setFont(font);
		btn2.setFont(font);

		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//
		panel.add(numbers);
		panel.add(cusnumtxt);

		c.add(panel);

		//
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		btn1.setPreferredSize(new Dimension(90, 50));
		btn2.setPreferredSize(new Dimension(90, 50));
		btn1.addActionListener(new ButtonActionListener());
		btn2.addActionListener(new ButtonActionListener());

		panel.add(btn1);
		panel.add(btn2);
		c.add(panel);
		//

		setSize(240, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public int getCnum()
	{
		return this.cnum; 
	}

	class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) { // 메뉴 아이템의 종류 구분
			case "확인":
//				System.out.println("확인 button" + cusnumtxt.getText());
//				System.out.println(MainScreen.cnum);
				
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
					MainScreen.setCnum(cnum);
					dispose();
				}

				break;
			case "취소":

				dispose();
				break;
			}
		}
	}
}
