package pptslides;

public class StaticMemberClassExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C.D c = new C.D();
		c.field1 = 4;
		c.method1();
		System.out.println("c.field1 : "+c.field1);
		
		C.D.field2 = 5;
		
		System.out.println("C.D.field2 : "+C.D.field2);
		C.D.method2();
	}

}
