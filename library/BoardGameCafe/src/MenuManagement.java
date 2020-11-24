import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;

public class MenuManagement extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	String[] tablename = {"∏ﬁ¥∫ ¿Ã∏ß", "∏ﬁ¥∫ ø‰±›"};
	MenuVO[] chart;
	ArrayList<MenuVO> list;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MenuManagement() {
		setTitle("\uBA54\uB274 \uAD00\uB9AC");
		setBounds(100, 100, 397, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		DefaultTableModel model = new DefaultTableModel(tablename,0);
		panel_1.setLayout(null);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 371, 384);
		
		panel_1.add(scrollPane);
		table.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20));
		
		//
		MenuDAO dao = new MenuDAO();
		list = dao.list();
		chart = new MenuVO[list.size()];
		DefaultTableModel m = (DefaultTableModel)table.getModel();
		for(int i=0;i<list.size();i++)
		{
			chart[i] = (MenuVO) list.get(i);
			
		}

		
		for(int i=0;i<list.size();i++)
		{
			m.addRow(new Object[] {chart[i].getMname(),chart[i].getMcost()});
			
		}
		//
		table.setRowHeight(30);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(1).setCellRenderer(celAlignRight);
		
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setPreferredSize(new Dimension(0, -330));
		JButton btnNewButton = new JButton("\uCD94\uAC00");
		btnNewButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB2EB\uAE30");
		btnNewButton_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		panel_2.add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		switch(cmd) {
		case "√ﬂ∞°":
			new MenuInsert();
			break;
		case "¥›±‚":
			dispose();
			break;
		}
	}

}
