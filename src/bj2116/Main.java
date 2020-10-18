package bj2116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][][] arr = new int[N][7][2];
		int[] temparr = new int[7];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 6; j++)
				temparr[j] = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= 6; j++) {
				arr[i][j][0] = findmax(temparr, j);
				arr[i][j][1] = pair(temparr, j);
			}
		}
//		for(int i = 0; i < N; i++) {
//			System.out.println(i + "th : ");
//			for(int j = 1; j <= 6; j++) {
//				System.out.println("num " + j + ", pair : " + arr[i][j][1] + ", max : " + arr[i][j][0]);
//			}
//		}
		
		int max = 0;
		int tempmax, cur;
		for(int start = 1; start <= 6; start++) {
			tempmax = arr[0][start][0];
			cur = arr[0][start][1];
			for(int n = 1; n < N; n++) {
				tempmax += arr[n][cur][0];
				cur = arr[n][cur][1];
			}
			max = max > tempmax ? max : tempmax;
		}
		System.out.println(max);
	}
	
	static int pair(int[] temparr, int num) {
		int idx;
		for(idx = 0; idx < 6; idx++) {
			if(temparr[idx] == num)
				break;
		}

		switch(idx) {
		case 0:
			return temparr[5];
		case 1:
			return temparr[3];
		case 2:
			return temparr[4];
		case 3:
			return temparr[1];
		case 4:
			return temparr[2];
		case 5:
			return temparr[0];
		}
		return 0;
	}
	
	static int findmax(int[] temparr, int num) {
		int num2 = pair(temparr, num);
		int max = 1;
		if(num != 6 && num2 != 6)
			return 6;
		else if(num != 5 && num2 != 5)
			return 5;
		else
			return 4;
	}
}
