import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import java.awt.FlowLayout;

public class MenuManagement extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	String[] tablename = {"메뉴 이름", "메뉴 요금"};
	MenuVO[] chart;
	ArrayList<MenuVO> list;
	private JPopupMenu popup = new JPopupMenu("삭제 컨트롤");
	JMenuItem m_delete = new JMenuItem("삭제");
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
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
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
		//
		PopupMouseListener listener = new PopupMouseListener();
		table.addMouseListener(listener);
		table.setComponentPopupMenu(popup);
		popup.add(m_delete);
		m_delete.addActionListener(this);
		m_delete.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		//
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setPreferredSize(new Dimension(0, -330));
		JButton btnNewButton = new JButton("\uCD94\uAC00");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB2EB\uAE30");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel_2.add(btnNewButton_1);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		
		setVisible(true);
	}

	class PopupMouseListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			JTable t = (JTable)arg0.getSource();
			int column = table.columnAtPoint(arg0.getPoint());
			int row = table.rowAtPoint(arg0.getPoint());
			table.changeSelection(row, column, false, false);
			//테이블 수정 삭제 부분 추가해야한다.
			//데이터베이스에서 선택된 테이블 열의 시간 값을 기준으로 값을 찾아서 삭제해야한다.
			
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel tm = (DefaultTableModel) table.getModel();
		String cmd = e.getActionCommand();
		
		switch(cmd) {
		case "추가":
			new MenuInsert(tm);
			break;
		case "닫기":
			dispose();
			break;
		case "삭제":
			String menu = table.getValueAt(table.getSelectedRow(), 0).toString();
			CheckEmpAuth cea = new CheckEmpAuth(tm, table.getSelectedRow(),"menu",menu);
			
			break;
		}
	}

}
