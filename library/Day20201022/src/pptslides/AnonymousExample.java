package pptslides;

public class AnonymousExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anonymous anony = new Anonymous();
		
		anony.field.wake();
		anony.method1();
		anony.method2(new Person() {
			void study()
			{
				System.out.println("study");
			}
			
			void wake()
			{
				System.out.println("wakes up at 8");
				study();
			}
			
		});
		
		
		
	}

}
