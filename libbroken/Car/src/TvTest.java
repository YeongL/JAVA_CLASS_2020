

public class TvTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV [] tvArr = new TV[3];

		for(int i=0;i<3;i++)
		{
			tvArr[i] = new TV();
			tvArr[i].channel = i+10;
		}
		for(int i=0;i<3;i++)
		{
			tvArr[i].channelUp();
			System.out.printf("tvArr[%d].channel =%d\n",i,tvArr[i].channel);
		}
		
	
	}

}
