package bj2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int[][][] dp;
	static int[][] arr;
	static Queue<Node> Q = new LinkedList<Node>();
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M][2];
		
		for(int i = 0; i < N; i++) {
			String tempstr = in.readLine();
			for(int j = 0; j < M; j++)
				arr[i][j] = tempstr.charAt(j) - '0';
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < 2; k++)
					dp[i][j][k] = 100000000;
			}
		}
		dp[0][0][0] = 1;
		Q.add(new Node(0, 0, 0, 1));
		Node temp;
		int r, c, rr, cc, wall, dist;
		while(!Q.isEmpty()) {
			temp = Q.poll();
			r = temp.r;
			c = temp.c;
			wall = temp.wall;
			dist = temp.dist;
			if(dist > dp[r][c][wall])
				continue;
			for(int dir = 0; dir < 4; dir++) {
				rr = r + dr[dir];
				cc = c + dc[dir];
				if(rr < 0 || cc < 0 || rr >= N || cc >= M)
					continue;
				if(arr[rr][cc] == 0) {
					if(dp[rr][cc][wall] > dist + 1) {
						dp[rr][cc][wall] = dist + 1;
						Q.add(new Node(rr, cc, wall, dist+1));
					}
				}
				else {
					if(wall == 1)
						continue;
					else if(dp[rr][cc][1] > dist + 1) {
						dp[rr][cc][1] = dist + 1;
						Q.add(new Node(rr, cc, 1, dist + 1));
					}
				}
			}
		}
		int res = dp[N-1][M-1][0] < dp[N-1][M-1][1] ? dp[N-1][M-1][0] : dp[N-1][M-1][1];
		if(res == 100000000)
			res = -1;
		System.out.println(res);
	}
}

class Node {
	int r;
	int c;
	int wall;
	int dist;
	Node(int r, int c, int wall, int dist) {
		this.r = r;
		this.c = c;
		this.wall = wall;
		this.dist = dist;
	}
}
