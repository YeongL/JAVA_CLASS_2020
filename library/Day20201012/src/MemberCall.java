
public class MemberCall {
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
	static int cv2 = new MemberCall().iv;
	
	static void staticMethod()
	{
		System.out.println(cv);
		MemberCall c = new MemberCall();
		System.out.println(c.iv);
	}
	
}
