package bj13549;

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
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N == K) {
			System.out.println(0);
			return;
		}
		else if(K < N) {
			System.out.println((N - K));
			return;
		}
		int[] arr = new int[200001];
		int limit = K*2;
		for(int i = 0; i <= limit; i++)
			arr[i] = 1000000;
		Queue <Integer> Q = new LinkedList<Integer>();
		arr[N] = 0;
		Q.add(N);
		int cur, next, count;
		while(!Q.isEmpty()) {
			cur = Q.poll();
			count = arr[cur];
			if(cur > 0 && cur <= limit / 2) {
				next = cur;
				while(next <= limit/2) {
					next *= 2;
					if(arr[next] > count) {
						arr[next] = count;
						Q.add(next);
					}
				}
			}
			if(cur > 0) {
				next = cur - 1;
				if(arr[next] > count + 1) {
					arr[next] = count + 1;
					Q.add(next);
				}
			}
			if(cur < limit) {
				next = cur + 1;
				if(arr[next] > count + 1) {
					arr[next] = count + 1;
					Q.add(next);
				}
			}
		}
		System.out.println(arr[K]);
	}
}
