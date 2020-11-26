import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInsert extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	DefaultTableModel tm;
	

	/**
	 * Create the frame.
	 */
	public MenuInsert(DefaultTableModel tm) {
		setTitle("\uBA54\uB274 \uCD94\uAC00 \uB4F1\uB85D");
		this.tm = tm;
		setBounds(100, 100, 334, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uB274 \uC774\uB984: ");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uBA54\uB274 \uAC00\uACA9: ");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("\uAD8C\uD55C \uC785\uB825: ");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_2.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		passwordField.setColumns(10);
		passwordField.setEchoChar('*');
		panel_2.add(passwordField);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_3.add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		
		setVisible(true);
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		switch(cmd)
		{
		case "등록":
			String emppw = "";
        	char[] secret_pw = passwordField.getPassword();
        	for(char cha:secret_pw)
        	{
        		Character.toString(cha);
        		emppw+=(emppw.equals(""))? ""+cha+"" : ""+cha+"";
        	}
        	EmpDBSelectPW res = new EmpDBSelectPW(emppw);
        	boolean isnum = true;
        	for(int i=0;i<textField.getText().length();i++)
        	{
        		if(textField.getText().charAt(i)<'0' || textField.getText().charAt(i)>'9')
        		{
        			isnum = false;
        			break;
        		}
        	}
        	if(!isnum)
        	{
        		JOptionPane.showMessageDialog(null, "숫자를 입력해주세요.","오류!",JOptionPane.ERROR_MESSAGE);
        		break;
        	}
        	if(res.getEauth().equals("사장"))
        	{
        		
        		new MenuDBInsert(textField_1.getText(),Integer.parseInt(textField.getText()));
        		JOptionPane.showMessageDialog(null, "메뉴 추가를 성공했습니다.","추가완료!",JOptionPane.ERROR_MESSAGE);
        		tm.addRow(new Object[] {textField_1.getText().toString(),textField.getText().toString()});
        		dispose();
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(null, "권한이 부족합니다. 다시 입력해주세요.","오류!",JOptionPane.ERROR_MESSAGE);
        	}
        	break;
		case "취소":
			dispose();
			break;
		}
	}

}
