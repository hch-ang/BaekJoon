package bj3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[N+2][N+2];
		for(int i = 0; i < N+2; i++) {
			arr[0][i] = 1;
			arr[N+1][i] = 1;
			arr[i][0] = 1;
			arr[i][N+1] = 1;
		}
		
		int K = Integer.parseInt(in.readLine());
		int r, c;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr[r][c] = 2;
		}
		
		int[] cdir = new int[10001];
		int L = Integer.parseInt(in.readLine());
		int n;
		char ch;
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			ch = st.nextToken().charAt(0);
			cdir[n] = ch == 'D' ? 1 : -1;
		}
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		Queue<Node> Q = new LinkedList<Node>();
		arr[1][1] = 1;
		Q.add(new Node(1, 1));
		Node temp;
		int time;
		int dir = 1;
		r = 1;
		c = 1;
		for(time = 1; time <= 10000; time++) {
			r += dr[dir];
			c += dc[dir];
			if(arr[r][c] == 1)
				break;
			else if(arr[r][c] == 0) {
				temp = Q.peek();
				Q.poll();
				arr[temp.r][temp.c] = 0; 
			}
			arr[r][c] = 1;
			Q.add(new Node(r, c));
			
			if(cdir[time] != 0)
				dir = (dir + 4 + cdir[time])%4;
		}
		System.out.println(time);
	}
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
