class Data{int x;}

class ReferenceReturnEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data d = new Data();
		
		d.x = 10;
		Data d2 = copy(d);
		System.out.println(d.x);
		System.out.println(d2.x);
	}
	static Data copy(Data d)
	{
		Data temp = new Data();
		temp.x = d.x;
		return temp;
	}

}
