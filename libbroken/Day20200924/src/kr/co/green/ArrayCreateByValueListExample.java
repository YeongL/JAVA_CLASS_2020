package kr.co.green;

public class ArrayCreateByValueListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] scores = {83, 90, 87};
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		double sum = 0;
		for(int i=0;i<3;i++)
		{
			sum+=scores[i];
		}
		System.out.println(sum);
		double avg = sum/scores.length;
		System.out.println(avg);
	}

}
