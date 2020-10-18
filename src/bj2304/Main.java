package bj2304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[1001];
		int[] arr1 = new int[1001];
		int[] arr2 = new int[1001];
		int L, H;
		int minidx = 1000, maxidx = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			L = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr[L] = H;
			minidx = minidx < L ? minidx : L;
			maxidx = maxidx > L ? maxidx : L;			
		}
		int max = 0;
		for(int idx = minidx; idx <= maxidx; idx++) {
			if(arr[idx] > max) {
				max = arr[idx];
			}
			arr1[idx] = max;
		}
		max = 0;
		for(int idx = maxidx; idx >= minidx; idx--) {
			if(arr[idx] > max) {
				max = arr[idx];
			}
			arr2[idx] = max;
		}
		int res = 0;
		for(int idx = minidx; idx <= maxidx; idx++)
			res += arr1[idx] < arr2[idx] ? arr1[idx] : arr2[idx];
		System.out.println(res);
	}
}
