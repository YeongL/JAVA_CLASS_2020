
public class DefaultMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c = new Child();
		c.method1();
		c.method2();
		Myinterface.staticMethod();
		Myinterface2.staticMethod();
	}

}

class Child extends Parent implements Myinterface, Myinterface2
{
	public void method1()
	{
		System.out.println("method1 in child");
	}
}

class Parent{
	public void method2()
	{
		System.out.println("method2 in parent");
	}
	
}

interface Myinterface
{
	default void method1()
	{
		System.out.println("method1 in myinterface");
	}
	default void method2()
	{
		System.out.println("method2 in myinterface");
	}
	static void staticMethod()
	{
		System.out.println("staticmethod in myinterface");
	}
}
interface Myinterface2
{
	default void method1()
	{
		System.out.println("method1 in myinterface2");
	}
	
	static void staticMethod()
	{
		System.out.println("staticmethod in myinterface2");
	}
}