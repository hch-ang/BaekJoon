package bj2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Object system;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int res = -100000000;
		int tempres;
		for(int i = 0; i <= N-K; i++) {
			tempres = 0;
			for(int j = i; j < i + K; j++)
				tempres += arr[j];
			res = res > tempres ? res : tempres;
		}
		System.out.println(res);
	}
}
