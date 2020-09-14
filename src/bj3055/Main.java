package bj3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R][];
		for(int i = 0; i < R; i++) 
			arr[i] = in.readLine().toCharArray();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}
