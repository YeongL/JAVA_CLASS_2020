import java.io.*;
import java.util.*;
public class NumberBaseball {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("숫자 야구에 오신 것을 환영합니다.");
		
		while(true)
		{
			//3자리일지 4자리일지 선택
			System.out.println("몇 자리 숫자야구를 할지 선택해주세요.(3 or 4)");
			int selectnum = Integer.parseInt(bf.readLine());						
			if(!(selectnum==3 || selectnum==4))
			{
				System.out.println("숫자를 잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			else {
				System.out.println(selectnum+"자리 숫자야구를 선택하셨습니다.");
			}
			
			Baseball bs = new Baseball();
			bs.setNum(selectnum);
			
			//서로 다른 난수생성
			int[] ansarr = bs.makeRand();
			int cnt = 0;
			//값 입력, 맞을때까지 반복.
			while(true)
			{
				System.out.println("9 이하의 자연수를 "+ansarr.length+"개 입력해주세요.");
				cnt++;
				int[] inputarr = new int[ansarr.length];
				String input = bf.readLine();
				input = input.replace(" ","");
				if(input.length()!=ansarr.length)
				{
					System.out.println("값을 "+ansarr.length+"갯수만큼 입력하지 않으셨습니다. 다시 입력해주세요.");
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
					System.out.println("1 이상 9 이하의 자연수를 입력하지 않으셨습니다. 다시 입력해주세요.");
					continue;
				}
				
				//비교 후 출력
				boolean result = compare(ansarr, inputarr);
				
				//모두 strike이면 종료.
				if(result)
				{
					System.out.println(cnt+"번 만에 모두 맞추셨습니다. 이번 게임을 종료합니다.");
					break;
				}
			}
			//다시 게임을 할지 선택
			System.out.println("이번 게임이 종료되었습니다. 다시 하시겠습니까?(y or others)");
			if(bf.readLine().charAt(0)=='y')
			{
				System.out.println("다음 게임을 시작합니다.");
				System.out.println();
				continue;
			}
			else
			{
				System.out.println("게임을 완전히 종료합니다.");
				break;
			}
		}
		
		
		
		bf.close();
		
	}
	
	//비교 후 출력하는 함수
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
		//모두 맞췄을 시 true 반환
		if(cntstrike == ans.length)
		{
			result = true;
		}
		return result;
	}
	
	
	

}



