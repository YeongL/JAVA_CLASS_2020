import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class CheckEmpAuth extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPasswordField passwordField;
	
	DefaultTableModel tm;
	int row;
	String name;
	String type;
	
	/**
	 * Create the frame.
	 */
	
	
	public CheckEmpAuth(DefaultTableModel tm, int row,String type, String name) {
		setTitle("\uC815\uC0B0 \uAE30\uB85D \uC0AD\uC81C");
		this.type = type;
		this.tm = tm;
		this.row = row;
		this.name = name;
		setBounds(100, 100, 255, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\uAD8C\uD55C: ");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		passwordField.setColumns(8);
		passwordField.setEchoChar('*');
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("\uC0AD\uC81C");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_1.add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		
		
		setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String cmd = arg0.getActionCommand();
    	switch (cmd) { // 메뉴 아이템의 종류 구분
        case "삭제":
        	String emppw = "";
        	char[] secret_pw = passwordField.getPassword();
        	for(char cha:secret_pw)
        	{
        		Character.toString(cha);
        		emppw+=(emppw.equals(""))? ""+cha+"" : ""+cha+"";
        	}
        	EmpDBSelectPW res = new EmpDBSelectPW(emppw);
        	
        	if(res.getEauth().equals("사장"))
        	{
        		
        		
        		JOptionPane.showMessageDialog(null, "삭제를 성공했습니다.","삭제완료!",JOptionPane.ERROR_MESSAGE);
        		tm.removeRow(row);
        		if(type.equals("menu"))
        		{
        			new MenuDBDelete(name);
        		}
        		else if(type.equals("time"))
        		{
        			new CalculateTimeDBDelete(name);
        		}
        		else {
        			new CalculateMenuDBDelete(name);
        		}
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
