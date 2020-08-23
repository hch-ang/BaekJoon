package bj1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int arr[];
	static int res = 0;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++)
			recur(arr[i], i);
		System.out.println(res);
	}
	
	static void recur(int sum, int index) {
		if(sum == S)
			res++;
		for(int i = index+1; i < N; i++) {
			recur(sum + arr[i], i);
		}
	}
}
