package bj1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int K, N, M;
//	static LinkedList <Integer>[] arr = new LinkedList[20001];
	static int arr[][] = new int[20001][20000];
	static int index[] = new int[20001];
	static int[] sig = new int[20001];
	static Queue<Integer> Q = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(in.readLine());
		for(int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for(int i = 1; i <= N; i++) {
//				arr[i] = new LinkedList<Integer>();
				index[i] = 0;
				sig[i] = 0;
			}
			int fr, to;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				fr = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
//				arr[fr].add(to);
//				arr[to].add(fr);
				arr[fr][index[fr]++] = to;
				arr[to][index[to]++] = fr;
			}

			Q.clear();
			boolean flag = true;
			int cur, next, len, cursig;
			for(int i = 1; i <= N; i++) {
				if(flag == false)
					break;
				if(sig[i] == 0) {
					sig[i] = 1;
					Q.offer(i);
					while(!Q.isEmpty()) {
						if(flag == false)
							break;
						cur = Q.poll();
						cursig = sig[cur];
						len = index[cur];
						for(int j = 0; j < len; j++) {
							next = arr[cur][j];
							if(sig[next] == cursig) {
								flag = false;
								break;
							}
							else if(sig[next] == 0) {
								sig[next] = -cursig;
								Q.offer(next);
							}
						}
					}
				}
			}
			if(flag == true)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.print(sb.toString());
	}
}
