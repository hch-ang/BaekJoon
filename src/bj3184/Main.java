package bj3184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R+2][C+2];
		boolean[][] sig = new boolean[R+2][C+2];
		for(int i = 0; i < R+2; i++) {
			arr[i][0] = '#';
			arr[i][C+1] = '#';
		}
		for(int j = 0; j < C+2; j++) {
			arr[0][j] = '#';
			arr[R+1][j] = '#';
		}
		String tempstr;
		int resv = 0;
		int reso = 0;
		for(int i = 1; i <= R; i++) {
			tempstr = in.readLine();
			for(int j = 1; j <= C; j++) {
				arr[i][j] = tempstr.charAt(j-1);
				if(arr[i][j] == 'o')
					reso++;
				else if(arr[i][j] == 'v')
					resv++;
			}
		}
		
		int dr[] = {-1, 0, 1, 0};
		int dc[] = {0, 1, 0, -1};
		int tempv, tempo, r, c, rr, cc;
		Node temp;
		Queue<Node> Q = new LinkedList<Node>();
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				if(!sig[i][j]) {
					sig[i][j] = true;
					tempv = arr[i][j] == 'v' ? 1 : 0;
					tempo = arr[i][j] == 'o' ? 1 : 0;
					Q.add(new Node(i, j));
					while(!Q.isEmpty()) {
						temp = Q.peek();
						Q.poll();
						r = temp.r;
						c = temp.c;
						for(int dir = 0; dir < 4; dir++) {
							rr = r + dr[dir];
							cc = c + dc[dir];
							if(sig[rr][cc])
								continue;
							if(arr[rr][cc] == '#')
								continue;
							sig[rr][cc] = true;
							tempv += arr[rr][cc] == 'v' ? 1 : 0;
							tempo += arr[rr][cc] == 'o' ? 1 : 0;
							Q.add(new Node(rr, cc));
						}
					}
					if(tempv >= tempo)
						reso -= tempo;
					else
						resv -= tempv;
				}
			}
		}
		System.out.println(reso + " " + resv);
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
