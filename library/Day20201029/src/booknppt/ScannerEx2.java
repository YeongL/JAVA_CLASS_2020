package booknppt;
import java.io.*;
import java.util.*;
public class ScannerEx2 {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		File filedir = new File(ScannerEx2.class.getResource("").getPath()+"data2.txt");
		Scanner sc = new Scanner(new File(filedir.toString()));
		int sum = 0;
		int cnt = 0;
		while(sc.hasNextInt())
		{
			sum+=sc.nextInt();
			cnt++;
		}
		System.out.println("sum = "+sum);
		System.out.println("avg = "+((double)sum)/cnt);
	}

}
