package pptslides;

public class Anonymous {
	Person field = new Person() {
	
	void work()
	{
		System.out.println("go to work");
	}
	
	void wake()
	{
		System.out.println("wakes up at 6 a.m.");
	}
	
	};
	
	void method1()
	{
		Person localVar = new Person()
		{
			void walk()
			{
				System.out.println("walks");
			}
			
			void wake()
			{
				System.out.println("wakes up at 7");
				walk();
			}
			
		};
		
		
		localVar.wake();
	}
	
	
	void method2(Person person)
	{
		person.wake();
	}
	
	
}
