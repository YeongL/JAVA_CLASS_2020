import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;


import java.sql.*;
import java.sql.Date;
public class CalculateTime extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtTimeUsed;
	private JTextField txtCusnum;
	private JTextField txtSales;
	private JPasswordField passwordField;
	int tablenum;
	

	/**
	 * Create the frame.
	 */
	public CalculateTime(int tablenum) {
		this.tablenum = tablenum;
		setTitle("\uC815\uC0B0");
		setBounds(100, 100, 333, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\uC774\uC6A9 \uC2DC\uAC04: ");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		
		txtTimeUsed = new JTextField();
		txtTimeUsed.setBackground(new Color(255, 255, 255));
		txtTimeUsed.setEditable(false);
		txtTimeUsed.setText(MainScreen.tables[tablenum].tableTime);
		panel.add(txtTimeUsed);
		txtTimeUsed.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		txtTimeUsed.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("\uC0AC\uC6A9 \uC778\uC6D0: ");
		lblNewLabel_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);
		
		txtCusnum = new JTextField();
		txtCusnum.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCusnum.setBackground(new Color(255, 255, 255));
		txtCusnum.setEditable(false);
		txtCusnum.setText(Integer.toString(MainScreen.tables[tablenum].customerNumber));
		txtCusnum.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		txtCusnum.setColumns(8);
		panel_1.add(txtCusnum);
		
		JLabel lblNewLabel_3_1 = new JLabel(" \uBA85");
		lblNewLabel_3_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_1.add(lblNewLabel_3_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 204));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("\uD569\uACC4 \uC694\uAE08: ");
		lblNewLabel_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_2.add(lblNewLabel_2);
		
		txtSales = new JTextField();
		txtSales.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSales.setBackground(new Color(255, 255, 255));
		txtSales.setEditable(false);
		txtSales.setText(Integer.toString(MainScreen.tables[tablenum].tableMin*(MainScreen.hourlyCost/60)*MainScreen.tables[tablenum].customerNumber));
		txtSales.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		txtSales.setColumns(8);
		panel_2.add(txtSales);
		
		JLabel lblNewLabel_3 = new JLabel(" \uC6D0");
		lblNewLabel_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(204, 255, 204));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uAD8C\uD55C \uC785\uB825: ");
		lblNewLabel_2_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_2_1.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBackground(new Color(245, 255, 250));
		passwordField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		passwordField.setEchoChar('*');
		panel_2_1.add(passwordField);
		passwordField.registerKeyboardAction(this, "∞·¡¶", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_FOCUSED);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(204, 255, 204));
		FlowLayout flowLayout_2 = (FlowLayout) panel_2_2.getLayout();
		contentPane.add(panel_2_2);
		
		JButton btnNewButton = new JButton("\uACB0\uC81C");
		btnNewButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_2_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_2_2.add(btnNewButton_1);
		setLocationRelativeTo(null);
		setVisible(true);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		switch (cmd) { // ∏ﬁ¥∫ æ∆¿Ã≈€¿« ¡æ∑˘ ±∏∫–
		case "∞·¡¶":
			Date TimeNow = new Date(new java.util.Date().getTime());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
			String strDate = dateFormat.format(TimeNow);
			System.out.println(strDate);
			int TimeUsed = MainScreen.tables[tablenum].tableMin;
			String emppw = "";
        	char[] secret_pw = passwordField.getPassword();
        	for(char cha:secret_pw)
        	{
        		Character.toString(cha);
        		emppw+=(emppw.equals(""))? ""+cha+"" : ""+cha+"";
        	}
        	
        	if(new EmpDBSelectPW(emppw).isUnique)
        	{
        		JOptionPane.showMessageDialog(null, "¡∏¿Á«œ¡ˆ æ ¥¬ ªÁøÎ¿⁄¿‘¥œ¥Ÿ. ¥ŸΩ√ ¿‘∑¬«ÿ¡÷ººø‰.","ø¿∑˘!",JOptionPane.ERROR_MESSAGE);
        	}
        	else 
        	{
        		new CalculateTimeDBInsert(tablenum, Integer.parseInt(txtCusnum.getText()), strDate, TimeUsed, emppw, Integer.parseInt(txtSales.getText()));
        		MainScreen.timers[tablenum].resetTimes();
        		//πˆ∆∞ √ ±‚»≠
        		MainScreen.tables[tablenum].isActive = false;
				MainScreen.tables[tablenum].table.setBackground(new Color(204, 255, 153));
        		dispose();
        	}
			

			break;
		case "√Îº“":
			MainScreen.timers[tablenum].isActive = true;
			
			dispose();
			break;
		}
	}
	
	

}
