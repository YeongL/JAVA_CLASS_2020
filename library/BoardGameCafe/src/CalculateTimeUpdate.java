import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class CalculateTimeUpdate extends JFrame implements ActionListener, DocumentListener {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JLabel lblNewLabel_1;
	String date;
	int tablenum;
	String emp; 
	int timeUsed; 
	int cusnum;
	DefaultTableModel tm;
	int row;
	/**
	 * Create the frame.
	 */
	public CalculateTimeUpdate(DefaultTableModel tm, int row, String date, int tablenum, String emp, int timeUsed, int cusnum) {
		this.date = date;
		this.tablenum = tablenum;
		this.emp = emp;
		this.timeUsed = timeUsed;
		this.cusnum = cusnum;
		this.tm = tm;
		this.row = row;
		setBounds(100, 100, 367, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		contentPane.add(panel);
		
		lblNewLabel_1 = new JLabel(date);
		lblNewLabel_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uD14C\uC774\uBE14 \uBC88\uD638: ");
		lblNewLabel_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setText(Integer.toString(tablenum));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC815\uC0B0\uC790: ");
		lblNewLabel_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_2.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setEditable(false);
		textField_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(emp);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC774\uC6A9 \uC2DC\uAC04(\uBD84): ");
		lblNewLabel_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_3.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(Integer.toString(timeUsed));
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_4.getLayout();
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_4);
		
		
		
		
		JLabel lblNewLabel_5 = new JLabel("\uC778\uC6D0\uC218: ");
		lblNewLabel_5.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_4.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		panel_4.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(Integer.toString(cusnum));
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_5.getLayout();
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_5);
		
		textField_2.getDocument().addDocumentListener(this);
		textField_3.getDocument().addDocumentListener(this);
		
		
		JLabel lblNewLabel_6 = new JLabel("\uC694\uAE08: ");
		lblNewLabel_6.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_5.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setEditable(false);
		textField_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		panel_5.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(Integer.toString(Integer.parseInt(textField_3.getText())*Integer.parseInt(textField_2.getText())*MainScreen.hourlyCost ));
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("\uAD8C\uD55C \uC785\uB825: ");
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_6.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		passwordField.setEchoChar('*');
		passwordField.setColumns(10);
		panel_6.add(passwordField);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_7.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_7.add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
    	switch (cmd) { // ∏ﬁ¥∫ æ∆¿Ã≈€¿« ¡æ∑˘ ±∏∫–
        case "ºˆ¡§":
        	String emppw = "";
        	char[] secret_pw = passwordField.getPassword();
        	for(char cha:secret_pw)
        	{
        		Character.toString(cha);
        		emppw+=(emppw.equals(""))? ""+cha+"" : ""+cha+"";
        	}
        	EmpDBSelectPW res = new EmpDBSelectPW(emppw);
        	if(res.getEauth().equals("ªÁ¿Â"))
        	{
        		new CalculateTimeDBUpdate(lblNewLabel_1.getText(),textField.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText());
        		tm.removeRow(row);
        		tm.addRow(new Object[] {lblNewLabel_1.getText(), Integer.parseInt(textField.getText()), textField_1.getText(), Integer.parseInt(textField_2.getText()),Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_4.getText())});
        		dispose();
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(null, "±««—¿Ã ∫Œ¡∑«’¥œ¥Ÿ. ¥ŸΩ√ ¿‘∑¬«ÿ¡÷ººø‰.","ø¿∑˘!",JOptionPane.ERROR_MESSAGE);
        	}
        	break;
        case "√Îº“":
        	dispose();
        	break;
    	}
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		textField_4.setText(Integer.toString(Integer.parseInt(textField_3.getText())*Integer.parseInt(textField_2.getText())*MainScreen.hourlyCost/60 ));
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
