package kr.co.green;

import java.util.Scanner;

public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[] = new String[] {"������", "����ġ", "�̵�", "�������","�̹���","�̳���","�̹μ�"};
		Scanner input = new Scanner(System.in);
		int index = -1;
		do {
			System.out.println("�˻��� �̸��� �Է��ϼ���");
			System.out.print("�̸�: ");
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
				System.out.println(name+"�� �迭�� "+index+"������ ã�ҽ��ϴ�.");
				break;
			}
			System.out.println("�ش��ϴ� �̸��� �������� �ʽ��ϴ�.");
			
		}
		while(true);
	}

}