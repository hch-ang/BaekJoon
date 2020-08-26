package bj1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			String temp = in.readLine();
			for(int j = 0; j < N; j++)
				arr[i][j] = temp.charAt(j) - '0';
		}
		recur(N, 0, 0);
		System.out.println(sb.toString());
	}
	
	static void recur(int size, int R, int C) {
//		System.out.println("(" + R + ", " + C + ") with size " + size);
		if(check(size, R, C)) {
			sb.append(arr[R][C]);
			return;
		}
		if(size == 2) {
			sb.append("(");
			sb.append(arr[R][C]);
			sb.append(arr[R][C+1]);
			sb.append(arr[R+1][C]);
			sb.append(arr[R+1][C+1]);
			sb.append(")");
			return;
		}
		sb.append("(");
		if(check(size/2, R, C))
			sb.append(arr[R][C]);
		else
			recur(size/2, R, C);
		
		if(check(size/2, R, C + size/2))
			sb.append(arr[R][C + size/2]);
		else
			recur(size/2, R, C + size/2);
		
		if(check(size/2, R + size/2, C))
			sb.append(arr[R + size/2][C]);
		else
			recur(size/2, R + size/2, C);
		
		if(check(size/2, R + size/2, C + size/2))
			sb.append(arr[R + size/2][C + size/2]);
		else
			recur(size/2, R + size/2, C + size/2);
		sb.append(")");
		return;
	}
	
	static boolean check(int len, int R, int C) {
		int stan = arr[R][C];
		for(int i = R; i < R + len; i++) {
			for(int j = C; j < C + len; j++) {
				if(arr[i][j] != stan)
					return false;
			}
		}
		return true;
	}
}
