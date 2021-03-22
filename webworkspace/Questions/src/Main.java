import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 1;
		Queue<String> q = new LinkedList<String>();
		Scanner input = new Scanner(System.in);
		
		String word = input.next();
		
		while(!word.equals("0"))
		{
			if(cnt%2==1)
			{
				q.offer(word);
			}
			word = input.next();
			cnt++;
		}
		System.out.println(cnt-1);
		for(int i=0;i<cnt/2;i++)
		{
			System.out.println(q.poll());
		}
	}

}
