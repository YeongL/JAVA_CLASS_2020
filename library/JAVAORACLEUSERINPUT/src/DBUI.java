import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;





public class DBUI extends WindowAdapter{

	private Frame frame;
	private Button btn1, btn2;
	private TextField input;
	private TextArea output;
	
	public DBUI()
	{
		frame = new Frame("Employ Select");
		btn1 = new Button("조회");
		btn2 = new Button("초기화");
		input = new TextField("Input ename...?");
		output = new TextArea("");
	}
	
	public void startFrame()
	{
		output.setEditable(false);
		output.setFocusable(false);
		
		
		
		//버튼동작
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String inp = input.getText();
				MemberDAO dao = new MemberDAO();
				ArrayList<MemberVo> list = dao.list(inp);
				for (int i = 0; i < list.size(); i++) {
					MemberVo data = (MemberVo) list.get(i);
					String empno = data.getEmpno();
					String ename = data.getEname();
					int sal = data.getSal();
					System.out.println(empno + " : " + ename + " : " + sal);
					String word = output.getText();
					output.setText(word+empno + " : " + ename + " : " + sal+"\n");
		 		}
				
			}
		});

		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				output.setText("");
				
			}
		});
		
		btn1.setSize(50, 25);        
		btn1.setLocation(180, 40);
		btn2.setSize(50, 100);        
		btn2.setLocation(180, 70);
		input.setSize(150, 25);
		input.setLocation(20,40);
		output.setSize(150, 100);
		output.setLocation(20,70);
		
		//프레임에 넣기
		frame.addWindowListener(this);
		frame.setSize(250, 190);
		frame.setLayout(null); 
		frame.add(input);
		
		frame.add(output);
		frame.add(btn1); 
		frame.add(btn2); 
		frame.setVisible(true); 
		
		
	}
	
	public void windowClosing(WindowEvent e) {        
		System.exit(0);    
	}    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBUI db = new DBUI();        
		db.startFrame();
	}

}
