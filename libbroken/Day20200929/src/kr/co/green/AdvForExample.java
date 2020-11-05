package kr.co.green;

public class AdvForExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = {9,7,8,9,8};
		int sum =0;
		for(int s:scores) {
			sum+=s;
		}
		System.out.println(sum);
		
		sum=0;
		for(int i=0;i<scores.length;i++)
		{
			sum+=scores[i];
		}
		System.out.println(sum);
	}

}
