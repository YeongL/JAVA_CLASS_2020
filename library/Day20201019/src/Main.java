
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = 10;
		Calculator calculator = new Calculator();
		System.out.println(calculator.areaCircle(r));
		Computer1 cal = new Computer1();
		System.out.println(cal.areaCircle(r));
	}

}

class Computer1 extends Calculator
{
	double areaCircle(double r)
	{
		System.out.println("��ǻ�� ��ü ������ ����");
		return Math.PI*r*r;
	}
}




class Calculator
{
	double areaCircle(double r)
	{
		System.out.println("���⿡�� ���");
		return 3.14159*r*r;
	}
}