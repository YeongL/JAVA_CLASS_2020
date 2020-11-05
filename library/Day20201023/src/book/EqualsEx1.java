package book;

public class EqualsEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		if(v1.equals(v2))
		{
			System.out.println("둘은 같다");
		}
		else
		{
			System.out.println("둘은 다르다");
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