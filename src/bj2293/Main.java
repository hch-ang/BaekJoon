package bj2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(in.readLine());
		Arrays.sort(arr);
		int[] dp = new int[K+1];
		dp[0] = 1;
		for(int i = 0; i < N; i++) {
			int coin = arr[i];
			for(int j = K; j >= 0; j--) {
				int num = dp[j];
				for(int k = j+coin; k <= K; k += coin) {
					dp[k] += num;
				}
			}
		}
		System.out.println(dp[K]);
	}
}
