package bj10163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[101][101];
		int N = Integer.parseInt(in.readLine());
		int[] res = new int[N+1];
		StringTokenizer st;
		int r, c, R, C;
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(in.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			for(int i = r; i < r + R; i++) {
				for(int j = c; j < c + C; j++) {
					arr[i][j] = n;
				}
			}
		}
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++)
				res[arr[i][j]]++;
		}
		for(int i = 1; i <= N; i++)
			System.out.println(res[i]);
	}
}
