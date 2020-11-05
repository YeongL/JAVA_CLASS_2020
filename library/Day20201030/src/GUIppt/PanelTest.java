package GUIppt;
import java.awt.*;
public class PanelTest {

	
	private Frame f;
    private Panel p;
    private Button ok, cancel;
    private TextField tf1;
 
    public PanelTest() {
        f = new Frame("panel example");
        ok = new Button("전송");
        cancel = new Button("삭제");
        tf1 = new TextField("Input...");
        p = new Panel();
    }
    public void startFrame() {
        f.add(tf1, BorderLayout.NORTH);
        p.setBackground(Color.CYAN);
        p.add(ok);
        p.add(cancel);
        f.add(p, BorderLayout.CENTER);
 
        f.setSize(400, 400);
        f.setVisible(true);
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PanelTest g = new PanelTest();
        g.startFrame();

	}

}
