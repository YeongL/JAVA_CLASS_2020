import java.util.*;
public class Jeongol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int cs = input.nextInt();
		int arr[][] = new int[100][100];
		for(int i=0;i<cs;i++)
		{
			int num1 = input.nextInt();
			int num2 = input.nextInt();
			for(int j=num1;j<num1+10;j++)
			{
				for(int k=num2;k<num2+10;k++)
				{
					arr[j][k]=1;
				}
			}
			
		}
		int cnt = 0;
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				if(arr[i][j]==1)
				{
					cnt++;
				}
			}
		}
		
		
		
		System.out.println(cnt);
	}

}
