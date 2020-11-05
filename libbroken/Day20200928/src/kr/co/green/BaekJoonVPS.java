package kr.co.green;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class BaekJoonVPS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
			
		Stack<Character> stackList = new Stack<Character>();

		for (int i = 0; i < num; i++) {
			String temp = br.readLine();
			boolean result = true;
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == '(')// '('�� Ǫ���ض�
				{
					stackList.push(temp.charAt(j));
				} else if (temp.charAt(j) == ')')// ')'�� ���� �տ� ���� (�� ���ض�
				{
					if (!stackList.empty()) {
						stackList.pop();
					} else // ��? '('�� �ȳ־��µ� ')'�� ���Ծ�? �� Ʋ�Ⱦ�!
					{
						result = false;
						break;
					}
				}

			}

			if (stackList.size() != 0)// '('�� �־��µ� �Ȼ���
			{
				result = false;
			}

			stackList.clear();

			if (result == false) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}

	}

}