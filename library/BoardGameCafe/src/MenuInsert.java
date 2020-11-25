import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
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

	

	/**
	 * Create the frame.
	 */
	public MenuInsert() {
		setTitle("\uBA54\uB274 \uCD94\uAC00 \uB4F1\uB85D");
		setBounds(100, 100, 334, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uB274 \uC774\uB984: ");
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uBA54\uB274 \uAC00\uACA9: ");
		lblNewLabel_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("\uAD8C\uD55C \uC785\uB825: ");
		lblNewLabel_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_2.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		passwordField.setColumns(10);
		passwordField.setEchoChar('*');
		panel_2.add(passwordField);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton btnNewButton = new JButton("µÓ∑œ");
		btnNewButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("√Îº“");
		btnNewButton_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
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
		case "µÓ∑œ":
			
			break;
		case "√Îº“":
			dispose();
			break;
		}
	}

}
