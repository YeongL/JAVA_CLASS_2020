package ppt;

public class NoteCellPhoneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoteCellPhone NoteCellPhone = new NoteCellPhone("�ڹ���", "����", 10);
        
        System.out.println("model : " + NoteCellPhone.model);
        System.out.println("color : " + NoteCellPhone.color);
        

        
        NoteCellPhone.powerOn();
        NoteCellPhone.bell();
        NoteCellPhone.sendVoice("��������?");
        NoteCellPhone.receiveVoice("�ȳ��ϼ���. ȫ�浿 �Դϴ�");
        NoteCellPhone.sendVoice("��, �ݰ����ϴ�");
        NoteCellPhone.hangUp();
        
        boolean draw[] = {false};
        boolean drawing[] = {false};
        
        NoteCellPhone.Drawing(draw);
        NoteCellPhone.penDrawing(draw,drawing);
        NoteCellPhone.deleteDrawing(draw,drawing);
        NoteCellPhone.endDrawing(draw);
        
	}

}