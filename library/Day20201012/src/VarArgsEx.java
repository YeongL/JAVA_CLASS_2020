
public class VarArgsEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArr = {"100","200","300"};
		
		System.out.println(concantenate("","100","200","300"));
		System.out.println(concantenate("-",strArr));
		System.out.println(concantenate(",",new String[] {"1","2","3"}));
		System.out.println("["+concantenate(",",new String[0])+"]");
		System.out.println("["+concantenate(",")+"]");
		
	}
	
	static String concantenate(String delim, String... args)
	{
		String result = "";
		
		for(String str:args)
		{
			result+=str+delim;
		}
		return result;
	}

}
