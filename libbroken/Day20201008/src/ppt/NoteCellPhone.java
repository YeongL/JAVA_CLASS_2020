package ppt;

public class NoteCellPhone extends CellPhone{
	NoteCellPhone(String model, String color, int channel) {
        this.model = model;
        this.color = color;
        
    }
	
	void Drawing(boolean[] draw)
	{
		if(draw[0])
		{
			System.out.println("�̹� ���� �ֽ��ϴ�");
		}
		else
		{
			draw[0] = true;
			System.out.println("�׸����� �������ϴ�.");
		}
		
	}
	
	void penDrawing(boolean[] draw, boolean[] drawing)
	{
		if(!draw[0])
		{
			System.out.println("�׸����� �������� �ʽ��ϴ�.");
		}
		else
		{
			System.out.println("������ �׸��� �׷Ƚ��ϴ�.");
			drawing[0] = true;
		}
		
	}
	
	void deleteDrawing(boolean[] draw, boolean[] drawing)
	{
		if(!draw[0])
		{
			System.out.println("�׸����� �������� �ʽ��ϴ�.");
		}
		else
		{
			System.out.println("�׸��� �������ϴ�.");
			drawing[0] = false;
		}
		
	}
	
	void endDrawing(boolean[] draw)
	{
		if(draw[0])
		{
			System.out.println("�׸����� �ݾҽ��ϴ�.");
			draw[0] = false;
		}
		else
		{
			System.out.println("�̹� �����ֽ��ϴ�.");
		}
		
	}
	
}