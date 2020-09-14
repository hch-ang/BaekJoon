package bj11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		if(N == 1) {
			System.out.println(1);
			return;
		}
		if(N == 2) {
			System.out.println(2);
			return;
		}
		int[][] dp = new int[N+1][3];
		dp[1][1] = 1;
		dp[1][2] = 0;
		dp[2][1] = 1;
		dp[2][2] = 1;
		for(int i = 3; i <= N; i++) {
			dp[i][1] = (dp[i-1][1] + dp[i-1][2])%10007;
			dp[i][2] = (dp[i-2][1] + dp[i-2][2])%10007;
		}
		System.out.println((dp[N][1] + dp[N][2])%10007);
	}
}
