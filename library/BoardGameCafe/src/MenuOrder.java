import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.util.*;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class MenuOrder extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable purchaseTable;
	String[] tablename = {"메뉴 이름","갯수","합계 가격"};
	private JTable menuTable;
	String[] tablename1 = {"메뉴 이름","가격"};
	MenuVO[] chart;
	ArrayList<MenuVO> list;
	private JTextField textField;
	private JPasswordField passwordField;
	DefaultTableModel tmMenu;
	DefaultTableModel tmPurchase;
	DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
	DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
	String strDate;
	boolean exists = false;
	int tablenum;
	/**
	 * Create the frame.
	 */
	public MenuOrder(int tablenum) {
		this.tablenum = tablenum;
		setTitle("\uC74C\uB8CC \uC8FC\uBB38");
		setBounds(100, 100, 624, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(306, 43, 289, 211);
		contentPane.add(panel);
		
		DefaultTableModel model = new DefaultTableModel(tablename,0);
		DefaultTableModel model1 = new DefaultTableModel(tablename1,0);
		panel.setLayout(null);
		purchaseTable = new JTable(model);
		purchaseTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		JScrollPane scrollPane = new JScrollPane(purchaseTable);
		menuTable = new JTable(model1);
		menuTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		JScrollPane scrollPane1 = new JScrollPane(menuTable);
		scrollPane.setBounds(0, 0, 289, 211);
		tmMenu = (DefaultTableModel) menuTable.getModel();
		tmPurchase = (DefaultTableModel) purchaseTable.getModel();
		//
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		menuTable.getColumnModel().getColumn(1).setCellRenderer(celAlignRight);
		purchaseTable.getColumnModel().getColumn(1).setCellRenderer(celAlignRight);
		purchaseTable.getColumnModel().getColumn(2).setCellRenderer(celAlignRight);
		//
		MenuDAO mdao = new MenuDAO();
		list = mdao.list();
		chart = new MenuVO[list.size()];
		for(int i=0;i<list.size();i++)
		{
			chart[i] = (MenuVO) list.get(i);
			
		}
		
		for(int i=0;i<list.size();i++)
		{
			tmMenu.addRow(new Object[] {chart[i].getMname(), chart[i].getMcost()});
		}
		
		
		//
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 43, 214, 211);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane1.setBounds(0, 0, 213, 211);
		panel_1.add(scrollPane1);
		
		JButton addButton = new JButton("\uCD94\uAC00");
		addButton.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		addButton.setBounds(238, 114, 56, 23);
		contentPane.add(addButton);
		
		JButton deleteButton = new JButton("\uC81C\uAC70");
		deleteButton.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		deleteButton.setBounds(238, 147, 56, 23);
		contentPane.add(deleteButton);
		
		JLabel lblNewLabel = new JLabel("\uCD1D \uC694\uAE08:");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(387, 264, 72, 27);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		textField.setBounds(468, 264, 127, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("0");
		
		Date TimeNow = new Date(new java.util.Date().getTime());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		strDate = dateFormat.format(TimeNow);
		
		JLabel TimeLabel = new JLabel(strDate);
		TimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		TimeLabel.setBounds(12, 6, 224, 30);
		contentPane.add(TimeLabel);
		
		JLabel TableNumLabel = new JLabel(Integer.valueOf(tablenum).toString());
		TableNumLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TableNumLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		TableNumLabel.setBounds(569, 10, 26, 23);
		contentPane.add(TableNumLabel);
		
		JLabel lblTable = new JLabel("Table #");
		lblTable.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTable.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblTable.setBounds(468, 10, 89, 23);
		contentPane.add(lblTable);
		
		JButton disposeButton = new JButton("\uCDE8\uC18C");
		disposeButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		disposeButton.setBounds(498, 341, 97, 39);
		contentPane.add(disposeButton);
		
		JButton purchaseButton = new JButton("\uACB0\uC81C");
		purchaseButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		purchaseButton.setBounds(389, 341, 97, 39);
		contentPane.add(purchaseButton);
		
		addButton.addActionListener(this);
		deleteButton.addActionListener(this);
		purchaseButton.addActionListener(this);
		disposeButton.addActionListener(this);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("\uAD8C\uD55C \uC785\uB825:");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_1.setBounds(369, 301, 97, 30);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(468, 301, 127, 30);
		contentPane.add(passwordField);
		
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		DefaultTableModel model = (DefaultTableModel)purchaseTable.getModel();
		
		switch(cmd)
		{
		case "추가":
			exists = false;
			int costcount=0;
			for(int i=0;i<purchaseTable.getRowCount();i++)//이미 리스트에 있는걸 추가하는지 확인
			{
				//리스트에 있는거네? 그러면 숫자만 늘리자.
				if(purchaseTable.getValueAt(i, 0).toString().equals(menuTable.getValueAt(menuTable.getSelectedRow(), 0)))
				{
					//지금 모델 불러온다
					//임시로 저장할 모델 만든다
					DefaultTableModel tmpmodel = new DefaultTableModel(tablename,0);
					//실시간으로 바뀔 값이 두 개다. 가격이랑 갯수
					
					//tmp모델에 값 저장하는 루프
					for(int j=0;j<purchaseTable.getRowCount();j++)
					{
						//가격 설정하는거
						int tmpcost = 0;
						//아까 그 데이터에 도달하면 값을 증가시킬것.
						if(i==j)
						{
							//단위 가격을 알아내야지
							for(int k=0;k<menuTable.getRowCount();k++)
							{
								if(menuTable.getValueAt(menuTable.getSelectedRow(), 0).equals(model.getValueAt(j, 0)))
								{
									//원래가격 설정
									tmpcost = Integer.parseInt(menuTable.getValueAt(menuTable.getSelectedRow(), 1).toString());
								}
							}
							//늘어난 가격이랑 갯수 설정
							tmpmodel.addRow(new Object[] {model.getValueAt(j, 0),(Integer.parseInt(model.getValueAt(j, 1).toString())+1),tmpcost*((Integer.parseInt(model.getValueAt(j, 1).toString())+1))});
						}
						else//아까 그 데이터가 아니면 안 바뀐 행들 추가
						{
							tmpmodel.addRow(new Object[] {model.getValueAt(j, 0),model.getValueAt(j, 1),model.getValueAt(j, 2)});
						}
						
					}
					//기존 모델 초기화
					model.setNumRows(0);
					model = new DefaultTableModel(tablename,0);
					//바꾼 값들 기존 모델에 집어넣기
					for(int j=0;j<tmpmodel.getRowCount();j++)
					{
						model.addRow(new Object[] {tmpmodel.getValueAt(j, 0),tmpmodel.getValueAt(j, 1),tmpmodel.getValueAt(j, 2)});
						//총합 넣기
						costcount+=Integer.parseInt(tmpmodel.getValueAt(j, 2).toString());
					}
					//재설정
					purchaseTable.setModel(model);
					purchaseTable.getColumnModel().getColumn(1).setCellRenderer(celAlignRight);
					purchaseTable.getColumnModel().getColumn(2).setCellRenderer(celAlignRight);
					textField.setText(Integer.toString(costcount));
					exists = true;
					break;
				}
				
				
			}
			//다 체크했는데 리스트에 없었어! 값을 넣자.
			if(!exists)
			{
				model.addRow(new Object[] {menuTable.getValueAt(menuTable.getSelectedRow(), 0),1,menuTable.getValueAt(menuTable.getSelectedRow(), 1)});
				textField.setText(Integer.toString(Integer.parseInt(textField.getText())+Integer.parseInt(menuTable.getValueAt(menuTable.getSelectedRow(), 1).toString())));
			}
			
			
			
			break;
		case "제거":
			int totalcost=0;
			//리스트에 하나만 있는 경우
			if(purchaseTable.getValueAt(purchaseTable.getSelectedRow(), 1).toString().equals("1"))
			{
				model.removeRow(purchaseTable.getSelectedRow());
			}
			else //리스트에 하나보다 많이 있는 경우
			{
				//임시로 저장할 모델 만든다
				DefaultTableModel tmpmodel = new DefaultTableModel(tablename,0);
				//실시간으로 바뀔 값이 두 개다. 가격이랑 갯수
				
				//tmp모델에 값 저장하는 루프
				for(int j=0;j<purchaseTable.getRowCount();j++)
				{
					//가격 설정하는거
					int tmpcost = 0;
					//아까 그 데이터에 도달하면 값을 감소시킬것.
					if(purchaseTable.getSelectedRow()==j)
					{
						//단위 가격을 알아내야지
						for(int k=0;k<menuTable.getRowCount();k++)
						{
							if(menuTable.getValueAt(k, 0).equals(model.getValueAt(purchaseTable.getSelectedRow(), 0)))
							{
								//원래가격 설정
								tmpcost = Integer.parseInt(menuTable.getValueAt(k, 1).toString());
							}
						}
						//늘어난 가격이랑 갯수 설정
						tmpmodel.addRow(new Object[] {model.getValueAt(j, 0),(Integer.parseInt(model.getValueAt(j, 1).toString())-1),tmpcost*((Integer.parseInt(model.getValueAt(j, 1).toString())-1))});
					}
					else//아까 그 데이터가 아니면 안 바뀐 행들 추가
					{
						tmpmodel.addRow(new Object[] {model.getValueAt(j, 0),model.getValueAt(j, 1),model.getValueAt(j, 2)});
					}
					
				}
				//기존 모델 초기화
				model.setNumRows(0);
				model = new DefaultTableModel(tablename,0);
				//바꾼 값들 기존 모델에 집어넣기
				for(int j=0;j<tmpmodel.getRowCount();j++)
				{
					model.addRow(new Object[] {tmpmodel.getValueAt(j, 0),tmpmodel.getValueAt(j, 1),tmpmodel.getValueAt(j, 2)});
				}
				//재설정
				purchaseTable.setModel(model);
				purchaseTable.getColumnModel().getColumn(1).setCellRenderer(celAlignRight);
				purchaseTable.getColumnModel().getColumn(2).setCellRenderer(celAlignRight);
			}
			
			for(int i=0;i<purchaseTable.getRowCount();i++)
			{
				totalcost+=Integer.parseInt(purchaseTable.getValueAt(i, 2).toString());
			}
			textField.setText(Integer.toString(totalcost));
			
			break;
		case "결제":
			String emppw = "";
        	char[] secret_pw = passwordField.getPassword();
        	for(char cha:secret_pw)
        	{
        		Character.toString(cha);
        		emppw+=(emppw.equals(""))? ""+cha+"" : ""+cha+"";
        	}
        	EmpDBSelectPW res = new EmpDBSelectPW(emppw);
        	if(!res.getEauth().equals(""))
        	{
        		String list = "";
        		for(int i=0;i<purchaseTable.getRowCount();i++)
        		{
        			list += (purchaseTable.getValueAt(i, 0)+"-"+purchaseTable.getValueAt(i, 1)+"잔 / ");
        		}
        		System.out.println(list);
        		new CalculateMenuDBInsert(strDate, tablenum, list,emppw,Integer.parseInt(textField.getText()));
        		JOptionPane.showMessageDialog(null, "메뉴 결제를 성공했습니다.","결제완료!",JOptionPane.INFORMATION_MESSAGE);
        		
        		dispose();
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(null, "권한이 부족합니다. 다시 입력해주세요.","오류!",JOptionPane.ERROR_MESSAGE);
        	}
			break;
		case "취소":
			dispose();
			break;
		}
	}
}
