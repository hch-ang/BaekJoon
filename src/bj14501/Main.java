package bj14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] T;
	static int[] P;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		T = new int[N];
		P = new int[N];
		dp = new int[N+1];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		int profit;
		for(int i = 0; i < N; i++) {
			profit = dp[i] + P[i];
			for(int j = i + T[i]; j < N+1; j++) {
				dp[j] = dp[j] > profit ? dp[j] : profit;
			}
		}
		System.out.println(dp[N]);
	}
}
