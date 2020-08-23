package bj13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
//	static List<ArrayList<Integer>> arr;
	static int[][]arr = new int[4000][4000];
	static int[]index = new int[4000];
	static int[] sig;
	static Stack<Integer> S = new Stack<Integer>();
	static int result = 0;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		arr = new ArrayList<ArrayList<Integer>>();
//		for(int i = 0; i < N; i++)
//			arr.add(new ArrayList<Integer>());
		sig = new int[N];
		int fr, to;
		StringTokenizer st;
		for(int i = 0; i < M; i++ ) {
			st = new StringTokenizer(in.readLine());
			fr = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			arr[fr][++index[fr]] = to;
			arr[to][++index[to]] = fr;
		}
		for(int i = 0; i < N; i++) {
			sig[i] = 1;
			dfs(i, 1);
			sig[i] = 0;
			if(result == 1)
				break;
		}
		System.out.println(result);
	}
	
	static int dfs(int idx, int iteration) {
		int num = 0, tempnum;
		int next;
		for(int i = 1; i <= index[idx]; i++) {
			next = arr[idx][i];
			if(sig[next] == 0) {
				sig[next] = 1;
				tempnum = dfs(next, iteration + 1);
				num = num > tempnum ? num : tempnum;
				sig[next] = 0;
				if(num > 3)
					result = 1;
				if(result == 1)
					return num + 1;
			}
		}
		return num + 1;
	}
}
