import java.io.*;
import java.util.*;
public class NumberBaseball {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("���� �߱��� ���� ���� ȯ���մϴ�.");
		
		while(true)
		{
			//3�ڸ����� 4�ڸ����� ����
			System.out.println("�� �ڸ� ���ھ߱��� ���� �������ּ���.(3 or 4)");
			int selectnum = Integer.parseInt(bf.readLine());						
			if(!(selectnum==3 || selectnum==4))
			{
				System.out.println("���ڸ� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			else {
				System.out.println(selectnum+"�ڸ� ���ھ߱��� �����ϼ̽��ϴ�.");
			}
			
			Baseball bs = new Baseball();
			bs.setNum(selectnum);
			
			//���� �ٸ� ��������
			int[] ansarr = bs.makeRand();
			int cnt = 0;
			//�� �Է�, ���������� �ݺ�.
			while(true)
			{
				System.out.println("9 ������ �ڿ����� "+ansarr.length+"�� �Է����ּ���.");
				cnt++;
				int[] inputarr = new int[ansarr.length];
				String input = bf.readLine();
				input = input.replace(" ","");
				if(input.length()!=ansarr.length)
				{
					System.out.println("���� "+ansarr.length+"������ŭ �Է����� �����̽��ϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
				boolean err = false;
				for(int i=0;i<input.length();i++)
				{
					if(input.charAt(i)<'1' || input.charAt(i)>'9')
					{
						err = true;
						break;
					}
					else
					{
						inputarr[i] = input.charAt(i)-'0';
					}
				}
				if(err)
				{
					System.out.println("1 �̻� 9 ������ �ڿ����� �Է����� �����̽��ϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
				
				//�� �� ���
				boolean result = compare(ansarr, inputarr);
				
				//��� strike�̸� ����.
				if(result)
				{
					System.out.println(cnt+"�� ���� ��� ���߼̽��ϴ�. �̹� ������ �����մϴ�.");
					break;
				}
			}
			//�ٽ� ������ ���� ����
			System.out.println("�̹� ������ ����Ǿ����ϴ�. �ٽ� �Ͻðڽ��ϱ�?(y or others)");
			if(bf.readLine().charAt(0)=='y')
			{
				System.out.println("���� ������ �����մϴ�.");
				System.out.println();
				continue;
			}
			else
			{
				System.out.println("������ ������ �����մϴ�.");
				break;
			}
		}
		
		
		
		bf.close();
		
	}
	
	//�� �� ����ϴ� �Լ�
	public static boolean compare(int[] ans, int[] input)
	{
		boolean result = false;
		int cntball = 0;
		int cntstrike = 0;
		for(int i=0;i<ans.length;i++)
		{
			if(ans[i] == input[i])
			{
				cntstrike++;
			}
			else
			{
				for(int j=0;j<ans.length;j++)
				{
					if(i!=j && ans[i] == input[j])
					{
						cntball++;
					}
				}
			}
		}
		System.out.println("Strike: "+cntstrike+", Ball: "+cntball);
		//��� ������ �� true ��ȯ
		if(cntstrike == ans.length)
		{
			result = true;
		}
		return result;
	}
	
	
	

}


