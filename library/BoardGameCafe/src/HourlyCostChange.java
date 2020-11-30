import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class HourlyCostChange extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	

	/**
	 * Create the frame.
	 */
	public HourlyCostChange() {
		setTitle("\uC694\uAE08\uC81C \uBCC0\uACBD");
		
		setBounds(100, 100, 351, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("\uD604\uC7AC \uC694\uAE08: ");
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);
		
		textField.setText(Integer.valueOf(MainScreen.hourlyCost).toString());
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uBCC0\uACBD \uC694\uAE08: ");
		lblNewLabel_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("\uAD8C\uD55C \uC785\uB825: ");
		lblNewLabel_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_2.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		passwordField.setColumns(10);
		panel_2.add(passwordField);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton btnNewButton = new JButton("∫Ø∞Ê");
		btnNewButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("√Îº“");
		btnNewButton_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_3.add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		switch(cmd)
		{
		case "∫Ø∞Ê":
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
        		MainScreen.hourlyCost = Integer.parseInt(textField_1.getText());
        		JOptionPane.showMessageDialog(null, "Ω√∞£¥Á ø‰±›¿Ã ¿Á º≥¡§µ«æ˙Ω¿¥œ¥Ÿ.","∫Ø∞Ê øœ∑·!",JOptionPane.INFORMATION_MESSAGE);
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

}
