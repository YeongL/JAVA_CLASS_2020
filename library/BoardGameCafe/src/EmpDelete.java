import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class EmpDelete extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPasswordField passwordField;
	Choice names = new Choice();
	String auth_item[] = {"사장","매니저","직원"};
	EmpVO[] members;
	String [] epw;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public EmpDelete() {
		setTitle("직원 삭제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 275, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984: ");
		lblNewLabel.setBounds(5, 8, 52, 27);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpVO> list = dao.list();
		members = new EmpVO[list.size()];
		for(int i=0;i<list.size();i++)
		{
			members[i] = (EmpVO) list.get(i);
		}
		epw = new String[list.size()];
		
		for(int i=0;i<list.size();i++)
		{
			names.add(members[i].getEname());
			epw[i] = members[i].getEPW();
		}
		names.setBounds(107, 5, 131, 32);
		names.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		panel.add(names);
		
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\uC0AC\uC7A5 \uC774\uC0C1 \uBE44\uBC00\uBC88\uD638:");
		lblNewLabel_3.setBounds(5, 8, 149, 21);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel_3.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 5, 84, 27);
		passwordField.setColumns(6);
		passwordField.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		passwordField.setEchoChar('*');
		panel_3.add(passwordField);
		
		passwordField.registerKeyboardAction(this, "삭제", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_FOCUSED);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("\uC0AD\uC81C");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(24, 5, 85, 40);
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBounds(139, 5, 85, 40);
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_4.add(btnNewButton_1);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		btnNewButton.setActionCommand("삭제");
		btnNewButton.setActionCommand("취소");
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
    	switch (cmd) { // 메뉴 아이템의 종류 구분
        case "삭제":
        	String deletepw = epw[names.getSelectedIndex()];
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
        		new EmpDBDelete(deletepw);
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
