package kr.co.green;

import java.util.Scanner;

public class BaekJoonRGB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int houses = input.nextInt();
		int[][] array = new int[3][houses];
		
		for (int j = 0; j < houses; j++) {
			for (int i = 0; i < 3; i++) {
				array[i][j] = input.nextInt();
			}
		}

	}

}
