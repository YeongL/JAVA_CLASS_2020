package kr.co.green;

public class ArrayTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arrayNum[];
		String names[];
		arrayNum = new int[3];
		names = new String[3];
		
		arrayNum[0] = 1;
		arrayNum[1] = 2;
		arrayNum[2] = 3;
		names[0] = "ȫ�浿";
		names[1] = "����ġ";
		names[2] = "������";
		for(int i =0;i<3;i++)
		{
			System.out.println(arrayNum[i] + ": "+names[i]);
		}
	}

}
