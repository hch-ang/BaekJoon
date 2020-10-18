package bj13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int N, K, S, Y;
		int[][] arr = new int[7][2];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			S = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			arr[Y][S]++;
		}
		int result = 0, popu;
		for(int y = 1; y <= 6; y++) {
			for(int s = 0; s <= 1; s++) {
				popu = arr[y][s];
				result += popu%K == 0 ? popu/K : popu/K + 1;
			}
		}
		System.out.println(result);
	}
}
