import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SalesTableTime extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JPanel panel_1;
	private JPanel panel_2;
	Choice cdate = new Choice();
	Choice cname = new Choice();
	CalculateTimeVO[] chart;
	String[] arr;
	String[] tablename = {"³¯Â¥/½Ã°£", "Table","Á¤»êÀÚ","½Ã°£(ºÐ)","ÀÎ¿ø¼ö","¿ä±Ý"};
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
		contentPane.setBackground(Color.WHITE);
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
		for(int i=0;i<list.size();i++)
		{
			String[] arr1 = chart[i].getDate().split(" ");
			
			if(!arr[cnt].equals(arr1[0]))
			{
				arr[cnt] = arr1[0];
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
		//choice °ü·Ã ÄÚµå
		cdate.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		cdate.setBounds(12, 10, 130, 35);
		panel_2.add(cdate);
		
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
		
		
		for(int i=0;i<elist.size();i++)
		{
			cname.add(members[i].getEname());
		}
		
		//
		cname.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		cname.setBounds(193, 10, 130, 35);
		cname.addItemListener(this);
		panel_2.add(cname);
		panel_2.setPreferredSize(new Dimension(0, -330));

		//
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 255));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 5, 935, 378);
		panel_1.add(scrollPane);
		
		table.getColumnModel().getColumn(3).setPreferredWidth(87);
		table.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		table.setBounds(37, 131, 902, 354);
		table.setRowHeight(30);
		
		
		for(int i=0;i<list.size();i++)
		{
			m.addRow(new Object[] {chart[i].getDate(),chart[i].getTablenum(),new EmpDBSelectPW(chart[i].getEPW()).getEname(),chart[i].getTimeused(),chart[i].getCusnum(),chart[i].getSales()});
			
		}
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 153));
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
		String item = e.getItem().toString();
		if(e.getSource() == cname)
		{
			for(int i=0;i<list.size();i++)
			{
				String[] arr1 = chart[i].getDate().split(" ");
				
				if(item.equals(arr1[0]))
				{
					model.addRow(new Object[] {chart[i].getDate(),chart[i].getTablenum(),new EmpDBSelectPW(chart[i].getEPW()).getEname(),chart[i].getTimeused(),chart[i].getCusnum(),chart[i].getSales()});
				}
			}
		}
		else
		{
			for(int i=0;i<list.size();i++)
			{
				
				if(item.equals(chart[i].getEPW()))
				{
					model.addRow(new Object[] {chart[i].getDate(),chart[i].getTablenum(),new EmpDBSelectPW(chart[i].getEPW()).getEname(),chart[i].getTimeused(),chart[i].getCusnum(),chart[i].getSales()});
				}
			}
		}
		
		
		
		table.setModel(model);
		table.getColumnModel().getColumn(3).setPreferredWidth(87);
		table.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		table.setBounds(37, 131, 902, 354);
		table.setRowHeight(30);
	}
	
	
}
