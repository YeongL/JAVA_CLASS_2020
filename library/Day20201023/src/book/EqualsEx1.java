package book;

public class EqualsEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		if(v1.equals(v2))
		{
			System.out.println("���� ����");
		}
		else
		{
			System.out.println("���� �ٸ���");
		}
		
	}

}


class Value{
	int value;
	public Value(int num )
	{
		this.value = num;
		
	}
}