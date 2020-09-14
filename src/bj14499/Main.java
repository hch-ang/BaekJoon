package bj14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][]arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		int dr[] = {0, 0, 0, -1, 1};
		int dc[] = {0, 1, -1, 0, 0};
		Dice dice = new Dice(0, 0, 0, 0, 0, 0);
		int r = R;
		int c = C;
		int rr, cc;
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			rr = r + dr[dir];
			cc = c + dc[dir];
			if(rr < 0 || cc < 0 || rr >= N || cc >= M)
				continue;
			r = rr;
			c = cc;
			moving(dice, dir);
			if(arr[r][c] == 0)
				arr[r][c] = dice.down;
			else {
				dice.down = arr[r][c];
				arr[r][c] = 0;
			}
			sb.append(dice.up).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void moving(Dice dice, int dir) {
		int temp = dice.up;
		if(dir == 1) {
			dice.up = dice.left;
			dice.left = dice.down;
			dice.down = dice.right;
			dice.right = temp;
		}
		else if (dir == 2) {
			dice.up = dice.right;
			dice.right = dice.down;
			dice.down = dice.left;
			dice.left = temp;
		}
		else if(dir == 3) {
			dice.up = dice.front;
			dice.front = dice.down;
			dice.down = dice.back;
			dice.back = temp;
		}
		else {
			dice.up = dice.back;
			dice.back = dice.down;
			dice.down = dice.front;
			dice.front = temp;
		}
		return;
	}
	
	static class Dice {
		int up;
		int down;
		int front;
		int back;
		int left;
		int right;
		public Dice(int up, int down, int front, int back, int left, int right) {
			this.up = up;
			this.down = down;
			this.front = front;
			this.back = back;
			this.right = right;
			this.left = left;
		}
	}
}
