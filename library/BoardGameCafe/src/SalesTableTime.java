import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class SalesTableTime extends JFrame implements ItemListener, ActionListener{

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPopupMenu popup = new JPopupMenu("삭제 수정 컨트롤");
	JMenuItem m_change = new JMenuItem("수정");
	JMenuItem m_delete = new JMenuItem("삭제");
	Choice cdate = new Choice();
	Choice cname = new Choice();
	CalculateTimeVO[] chart;
	String[] arr;
	String[] tablename = {"날짜/시간", "Table","정산자","시간(분)","인원수","요금"};
	ArrayList<CalculateTimeVO> list;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public SalesTableTime() {
		setTitle("\uC2DC\uAC04\uB2F9 \uC694\uAE08 \uC815\uC0B0");
		
		setBounds(100, 100, 1004, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel(tablename,0);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		table = new JTable(model);
		
		CalculateTimeDAO dao = new CalculateTimeDAO();
		list = dao.list();
		chart = new CalculateTimeVO[list.size()];
		DefaultTableModel m = (DefaultTableModel)table.getModel();
		for(int i=0;i<list.size();i++)
		{
			chart[i] = (CalculateTimeVO) list.get(i);
			
		}

		int cnt = 0;
		String tmpstr = "";
		for(int i=0;i<list.size();i++)
		{
			String[] arr1 = chart[i].getDate().split(" ");
			
			if(!tmpstr.equals(arr1[0]))
			{
				tmpstr = arr1[0];
				cnt++;
			}
		}
		
		arr = new String[cnt];
		for(int i=0;i<cnt;i++)
		{
			arr[i] = "";
		}
		cnt = 0;
		String tmpstring = arr[0];
		for(int i=0;i<list.size();i++)
		{
			String[] arr1 = chart[i].getDate().split(" ");
			
			if(!tmpstring.equals(arr1[0]))
			{
				arr[cnt] = arr1[0];
				tmpstring = arr[cnt];
				cnt++;
			}
			if(cnt == arr.length)
			{
				break;
			}
		}
		
		
		
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 204));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		//choice 관련 코드
		cdate.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		cdate.setBounds(61, 10, 130, 35);
		panel_2.add(cdate);
		cdate.add("모두");
		for(String str1 : arr)
		{
			cdate.add(str1);
		}
		
		cdate.addItemListener(this);
		//
		EmpDAO edao = new EmpDAO();
		ArrayList<EmpVO> elist = edao.list();
		EmpVO[] members = new EmpVO[elist.size()];
		for(int i=0;i<elist.size();i++)
		{
			members[i] = (EmpVO) elist.get(i);
		}
		
		cname.add("모두");
		for(int i=0;i<elist.size();i++)
		{
			cname.add(members[i].getEname());
		}
		
		//
		cname.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		cname.setBounds(247, 10, 130, 35);
		cname.addItemListener(this);
		panel_2.add(cname);
		panel_2.setPreferredSize(new Dimension(0, -330));
		
		JLabel lblNewLabel_1 = new JLabel("\uB0A0\uC9DC:");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_1.setBounds(12, 10, 57, 33);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC774\uB984:");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(197, 10, 57, 33);
		panel_2.add(lblNewLabel_1_1);

		//
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 5, 935, 378);
		panel_1.add(scrollPane);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(5).setCellRenderer(celAlignRight);
		
		PopupMouseListener listener = new PopupMouseListener();
		table.addMouseListener(listener);
		table.setComponentPopupMenu(popup);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		table.setBounds(37, 131, 902, 354);
		table.setRowHeight(30);
		
		
		for(int i=0;i<list.size();i++)
		{
			m.addRow(new Object[] {chart[i].getDate(),chart[i].getTablenum(),new EmpDBSelectPW(chart[i].getEPW()).getEname(),chart[i].getTimeused(),chart[i].getCusnum(),chart[i].getSales()});
			
		}
		m_change.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		m_delete.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		m_change.addActionListener(this);
		m_delete.addActionListener(this);
		
		popup.add(m_change);
		popup.add(m_delete);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 204));
		panel.setBounds(12, 10, 927, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(0, -300));
		
		JLabel lblNewLabel = new JLabel("\uC694\uAE08 \uD569\uACC4: ");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(729, 10, 99, 39);
		//contentPane.add(table);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setEditable(false);
		textField.setBounds(831, 10, 116, 37);
		textField.setColumns(10);
		int tmp = 0;
		for(int i=0;i<list.size();i++)
		{
			tmp+=chart[i].getSales();
			
		}
		textField.setText(Integer.toString(tmp));
		
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setNumRows(0);
		model = new DefaultTableModel(tablename,0);
		int tmp = 0;
		if(cname.getSelectedItem().equals("모두") && cdate.getSelectedItem().equals("모두"))
		{
			for(int i=0;i<list.size();i++)
			{
				
				model.addRow(new Object[] {chart[i].getDate(),chart[i].getTablenum(),new EmpDBSelectPW(chart[i].getEPW()).getEname(),chart[i].getTimeused(),chart[i].getCusnum(),chart[i].getSales()});
				tmp+=chart[i].getSales();
			}
		}
		else if(cname.getSelectedItem().equals("모두"))
		{
			for(int i=0;i<list.size();i++)
			{
				String[] arr1 = chart[i].getDate().split(" ");
				
				if(cdate.getSelectedItem().equals(arr1[0]))
				{
					model.addRow(new Object[] {chart[i].getDate(),chart[i].getTablenum(),new EmpDBSelectPW(chart[i].getEPW()).getEname(),chart[i].getTimeused(),chart[i].getCusnum(),chart[i].getSales()});
					tmp+=chart[i].getSales();
				}
			}
		}
		else if(cdate.getSelectedItem().equals("모두"))
		{
			for(int i=0;i<list.size();i++)
			{
				
				if(cname.getSelectedItem().equals(new EmpDBSelectPW(chart[i].getEPW()).getEname()))
				{
					model.addRow(new Object[] {chart[i].getDate(),chart[i].getTablenum(),new EmpDBSelectPW(chart[i].getEPW()).getEname(),chart[i].getTimeused(),chart[i].getCusnum(),chart[i].getSales()});
					tmp+=chart[i].getSales();
				}
			}
		}
		else
		{
			for(int i=0;i<list.size();i++)
			{
				String[] arr1 = chart[i].getDate().split(" ");
				
				if(cdate.getSelectedItem().equals(arr1[0]) && cname.getSelectedItem().equals(new EmpDBSelectPW(chart[i].getEPW()).getEname()))
				{
					model.addRow(new Object[] {chart[i].getDate(),chart[i].getTablenum(),new EmpDBSelectPW(chart[i].getEPW()).getEname(),chart[i].getTimeused(),chart[i].getCusnum(),chart[i].getSales()});
					tmp+=chart[i].getSales();
				}
			}
		}
		
		
		textField.setText(Integer.toString(tmp));
		table.setModel(model);
		table.getColumnModel().getColumn(3).setPreferredWidth(87);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		table.setBounds(37, 131, 902, 354);
		table.setRowHeight(30);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setCellRenderer(celAlignCenter);
		table.getColumnModel().getColumn(5).setCellRenderer(celAlignRight);
		
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
		String cmd = e.getActionCommand();
		DefaultTableModel tm = (DefaultTableModel) table.getModel();
		String date = table.getValueAt(table.getSelectedRow(), 0).toString();
		switch (cmd) {
		case "수정":
			
			int tablenum = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1).toString());
			String emp = table.getValueAt(table.getSelectedRow(), 2).toString();
			int timeUsed = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 3).toString());
			int cusnum = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 4).toString());
			new CalculateTimeUpdate(tm, table.getSelectedRow(), date, tablenum, emp, timeUsed, cusnum);
			break;
		case "삭제":
			
			System.out.println(date);
			
			
			CheckEmpAuth cea = new CheckEmpAuth(tm, table.getSelectedRow());
			if(cea.IsChecked())
			{
				new CalculateTimeDBDelete(date);
			}
			//new CalculateTimeDBDelete(date);
			break;
		}
	}
	
	
}
