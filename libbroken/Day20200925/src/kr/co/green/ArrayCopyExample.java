package kr.co.green;

public class ArrayCopyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] oldStringArray = {"java","array","copy"};
		String[] newStringArray = new String[5];
		System.arraycopy(oldStringArray, 0, newStringArray, 0, oldStringArray.length);
		for(int i=0;i<newStringArray.length;i++)
		{
			System.out.println(newStringArray[i]);
		}
	}

}
