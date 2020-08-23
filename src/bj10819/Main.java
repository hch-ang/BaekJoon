package bj10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static boolean[] sig;
	static int[] arr;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		sig = new boolean[N];
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			sig[i] = true;
			comb(0, arr[i], 1);
			sig[i] = false;
		}
		
		System.out.println(max);
	}
	
	static void comb(int sum, int target, int iteration) {
		if(iteration == N) {
			max = max > sum ? max : sum;
			return;
		}
		for(int i = 0; i < N; i++) {
			if(sig[i] == false) {
				sig[i] = true;
				int tempnum = arr[i];
				int tempsum = target - tempnum > 0 ? sum + target - tempnum : sum + tempnum - target;
				comb(tempsum, tempnum, iteration + 1);
				sig[i] = false;
			}
		}
	}
}
