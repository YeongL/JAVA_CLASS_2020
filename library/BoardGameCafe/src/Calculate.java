import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.sql.*;
public class Calculate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	

	/**
	 * Create the frame.
	 */
	public Calculate(int tablenum) {
		setTitle("\uC815\uC0B0");
		setBounds(100, 100, 333, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\uC774\uC6A9 \uC2DC\uAC04: ");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		panel.add(textField);
		textField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("\uC0AC\uC6A9 \uC778\uC6D0: ");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setEditable(false);
		textField_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("\uD569\uACC4 \uC694\uAE08: ");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		panel_2.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setEditable(false);
		textField_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JPanel panel_2_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uAD8C\uD55C \uC785\uB825: ");
		lblNewLabel_2_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		panel_2_1.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBackground(new Color(255, 240, 245));
		passwordField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		passwordField.setEchoChar('*');
		panel_2_1.add(passwordField);
		
		JPanel panel_2_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2_2.getLayout();
		contentPane.add(panel_2_2);
		
		JButton btnNewButton = new JButton("\uACB0\uC81C");
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		panel_2_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		panel_2_2.add(btnNewButton_1);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Timestamp TimeNow = Timestamp.valueOf(new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime()));
				String Time = TimeNow.toString();
				String TimeUsed = MainScreen.tables[tablenum].tableTime;
				String emppw = "";
            	char[] secret_pw = passwordField.getPassword();
            	for(char cha:secret_pw)
            	{
            		Character.toString(cha);
            		emppw+=(emppw.equals(""))? ""+cha+"" : ""+cha+"";
            	}
            	
            	
            	
            	
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
	
	

}
