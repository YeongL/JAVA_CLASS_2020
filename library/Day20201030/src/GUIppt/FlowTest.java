package GUIppt;
import java.awt.*;
public class FlowTest {
	
	private Frame frame;
	private Button but1,but2,but3;
	private TextField tf1;
	public FlowTest()
	{
		frame = new Frame("FlowLayout example");
		tf1 = new TextField();
		but1 = new Button("Ȯ��");
		but2 = new Button("����");
		but3 = new Button("�ݱ�");
		
	}
	
	public void startFrame() {
        
		frame.add(tf1,BorderLayout.NORTH);
		frame.setLayout(new FlowLayout());
        
        frame.add(but1);
        frame.add(but2);
        frame.add(but3);
        
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlowTest flow = new FlowTest();
		flow.startFrame();
		
		
		
		
	}

}
