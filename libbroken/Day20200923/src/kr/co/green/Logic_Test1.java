package kr.co.green;

public class Logic_Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = args[0];
		
		String pw = args[1];
		if(!id.contentEquals("java"))
		{
			System.out.println("�츮ȸ�� �ƴϴ�");
		}
		else if(!pw.equals("java"))
		{
			System.out.println("��й�ȣ ����ġ");
		}
		else {
			System.out.println("ȯ���մϴ�");
		}
	}

}
