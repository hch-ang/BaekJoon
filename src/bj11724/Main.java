package bj11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static List<LinkedList <Integer>> arr = new LinkedList<LinkedList<Integer>>();
	static boolean[] sig;
	static Queue<Integer> Q = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= N; i++)
			arr.add(new LinkedList<Integer>());
		sig = new boolean[N+1];
		int fr, to;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			fr = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			arr.get(fr).add(to);
			arr.get(to).add(fr);
		}
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			if(sig[i] == false) {
				result++;
				sig[i] = true;
				Q.offer(i);
				int cur, next;
				List<Integer> templist;
				while(!Q.isEmpty()) {
					cur = Q.poll();
					templist = arr.get(cur);
					for(int idx = 0; idx < templist.size(); idx++) {
						next = templist.get(idx);
						if(sig[next] == false) {
							sig[next] = true;
							Q.offer(next);
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
