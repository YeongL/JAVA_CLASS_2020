package kr.co.green;

import java.util.Scanner;

public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[] = new String[] {"윤종혁", "전우치", "이도", "세종대왕","이민지","이나라","이민수"};
		Scanner input = new Scanner(System.in);
		int index = -1;
		do {
			System.out.println("검색할 이름을 입력하세요");
			System.out.print("이름: ");
			String name = input.next();
			for(int i = 0; i<names.length; i++)
			{
				if(name.equals(names[i]))
				{
					index = i;
					break;
				}
			}
			if(index!=-1)
			{
				System.out.println(name+"은 배열의 "+index+"번에서 찾았습니다.");
				break;
			}
			System.out.println("해당하는 이름이 존재하지 않습니다.");
			
		}
		while(true);
	}

}
