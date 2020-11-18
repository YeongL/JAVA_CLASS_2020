import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SalesTableTime extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesTableTime frame = new SalesTableTime();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SalesTableTime() {
		
		setBounds(100, 100, 1004, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		String[] tablename = {"³¯Â¥/½Ã°£", "Table","Á¤»êÀÚ","½Ã°£(ºÐ)","ÀÎ¿ø¼ö","¿ä±Ý"};
		DefaultTableModel model = new DefaultTableModel(tablename,0);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 153, 153));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		comboBox.setBounds(12, 10, 130, 35);
		panel_2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		comboBox_1.setBounds(193, 10, 130, 35);
		panel_2.add(comboBox_1);
		panel_2.setPreferredSize(new Dimension(0, -330));

		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 5, 935, 378);
		panel_1.add(scrollPane);
		
		table.getColumnModel().getColumn(3).setPreferredWidth(87);
		table.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		table.setBounds(37, 131, 902, 354);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(12, 10, 927, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(0, -300));
		
		JLabel lblNewLabel = new JLabel("\uC694\uAE08 \uD569\uACC4: ");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel.setBounds(729, 10, 99, 39);
		//contentPane.add(table);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setEditable(false);
		textField.setBounds(831, 10, 116, 37);
		textField.setColumns(10);
	}
}
