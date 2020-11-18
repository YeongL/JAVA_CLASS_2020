import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class AuthChange extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	Choice names = new Choice();
	Choice auths = new Choice();
	String auth_item[] = {"»çÀå","¸Å´ÏÀú","Á÷¿ø"};
	EmpVO[] members;
	/**
	 * Create the frame.
	 */
	public AuthChange() {
		setTitle("\uAD8C\uD55C \uBCC0\uACBD");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 275, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984: ");
		lblNewLabel.setBounds(5, 8, 52, 27);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpVO> list = dao.list();
		members = new EmpVO[list.size()];
		for(int i=0;i<list.size();i++)
		{
			members[i] = (EmpVO) list.get(i);
		}
		
		
		for(int i=0;i<list.size();i++)
		{
			names.add(members[i].getEname());
		}
		names.setBounds(107, 5, 131, 32);
		names.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		panel.add(names);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uD604\uC7AC \uAD8C\uD55C: ");
		lblNewLabel_1.setBounds(5, 8, 99, 27);
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(109, 5, 129, 33);
		textField.setText(members[names.getSelectedIndex()].getEAuth());
		textField.setEditable(false);
		textField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		panel_1.add(textField);
		textField.setColumns(7);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uBCC0\uACBD\uD560 \uAD8C\uD55C: ");
		lblNewLabel_2.setBounds(5, 8, 119, 27);
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		panel_2.add(lblNewLabel_2);
		
		auths.setBounds(129, 8, 109, 33);
		for(String str:auth_item)
		{
			auths.add(str);
		}
		auths.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		panel_2.add(auths);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\uB9E4\uB2C8\uC800 \uC774\uC0C1 \uBE44\uBC00\uBC88\uD638:");
		lblNewLabel_3.setBounds(5, 8, 149, 21);
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		panel_3.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 5, 84, 27);
		passwordField.setColumns(6);
		passwordField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		passwordField.setEchoChar('*');
		panel_3.add(passwordField);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("\uBCC0\uACBD");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(24, 5, 85, 40);
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBounds(139, 5, 85, 40);
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		panel_4.add(btnNewButton_1);
		setLocationRelativeTo(null);
		setVisible(true);
		
		names.addItemListener(this);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
            	
				dispose();
			}
			
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				dispose();
			}
			
		});
		
	}
	
	public void getEmpList()
	{
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		textField.setText(members[names.getSelectedIndex()].getEAuth());
	}
	
	

}
