package bj1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] dp = new boolean[N+1][M+1];
		dp[0][S] = true;
		int volume;
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= N; i++) {
			volume = Integer.parseInt(st.nextToken());
			for(int j = 0; j <= M; j++) {
				if(dp[i-1][j]) {
					if(j - volume >= 0)
						dp[i][j - volume] = true;
					if(j + volume <= M)
						dp[i][j + volume] = true;
				}
			}
		}
		int res = -1;
		for(int j = M; j >= 0; j--) {
			if(dp[N][j]) {
				res = j;
				break;
			}
		}
		System.out.println(res);
	}
}
