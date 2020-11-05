import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = 0;
		double sum = 0;
		int cnt = 0;
		while(true)
		{
			num = input.nextInt();
			if(num<0 || num>100)
			{
				break;
			}
			
			cnt++;
			sum+=num;
		}
		System.out.println("sum : "+sum);
		System.out.println("avg : "+sum/cnt);
	}

}
