package booknppt;
import java.util.*;
public class StringTokenizerEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "This\\!is\\!tokenizing!proj";
		StringTokenizer st = new StringTokenizer(str,"\\!",true);
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
	}

}
