package kr.co.green;

public class ReferenceCoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strvar1 = "KSJ";
		String strvar2 = "KSJ";
		if(strvar1 == strvar2)
		{
			System.out.println("���� ����");
		}
		else {
			System.out.println("���� �ٸ���");
		}
		
		if(strvar1.equals(strvar2))
		{
			System.out.println("���ڿ� ����");
		}
		
		String strvar3 = new String("KSJ");
		String strvar4 = new String("KSJ");
		
		if(strvar3 == strvar4)
		{
			System.out.println("���� ����");
		}
		else {
			System.out.println("���� �ٸ���");
		}
		
		if(strvar3.equals(strvar4))
		{
			System.out.println("���ڿ� ����");
		}
	}

}