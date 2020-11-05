package booknppt;
import java.io.*;
import java.util.*;
public class ScannerEx3 {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		File filedir = new File(ScannerEx2.class.getResource("").getPath()+"data3.txt");
		Scanner sc = new Scanner(new File(filedir.toString()));
		int cnt = 0;
		int totalSum = 0;
		while(sc.hasNextLine())
		{
			String line = sc.nextLine();
			Scanner sc2 = new Scanner(line).useDelimiter(",");
			
			int sum = 0;
			while(sc2.hasNextInt())
			{
				sum+=sc2.nextInt();
			}
			System.out.println(line+", sum = "+sum);
			totalSum+=sum;
			cnt++;
		}
		System.out.println("Line = "+cnt+", Total = "+totalSum);
	}

}