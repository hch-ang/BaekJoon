package bj9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			arr = new int[N+2][2];
			int[][] dist = new int[N+2][N+2];
			boolean[] dp = new boolean[N+2];
			int x, y;
			for(int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(in.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				arr[i][0] = x;
				arr[i][1] = y;
			}
			for(int i = 0; i < N+1; i++) {
				for(int j = i+1; j < N+2; j++) {
					dist[i][j] = finddist(i, j);
					dist[j][i] = dist[i][j];
				}
			}
			Queue<Integer> Q = new LinkedList<Integer>();
			dp[0] = true;
			Q.add(0);
			boolean result = false;
			int cur;
mywhile:		while(!Q.isEmpty()) {
				cur = Q.poll();
				if(cur == N+1) {
					result = true;
					break mywhile;
				}
				for(int next = 1; next < N+2; next++) {
					if(!dp[next] && dist[cur][next] <= 1000) {
						dp[next] = true;
						Q.add(next);
					}
				}
			}
			if(result)
				sb.append("happy").append("\n");
			else
				sb.append("sad").append("\n");
		}
		System.out.print(sb.toString());
	}
	static int finddist(int i, int j) {
		int xdiff = arr[i][0] > arr[j][0] ? arr[i][0] - arr[j][0] : arr[j][0] - arr[i][0];
		int ydiff = arr[i][1] > arr[j][1] ? arr[i][1] - arr[j][1] : arr[j][1] - arr[i][1];
		return xdiff + ydiff;
	}
}
