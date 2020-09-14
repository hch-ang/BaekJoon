package bj11057;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[][] arr = new int[1001][10];
		for(int i = 0; i < 10; i++)
			arr[1][i] = 1;
		for(int i = 2; i <= 1000; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k <= j; k++)
					arr[i][j] = (arr[i][j] + arr[i-1][k])%10007;
			}
		}
		int N = Integer.parseInt(new Scanner(System.in).nextLine());
		int result = 0;
		for(int i = 0; i < 10; i++)
			result = (result + arr[N][i])%10007;
		System.out.println(result);
	}
}
