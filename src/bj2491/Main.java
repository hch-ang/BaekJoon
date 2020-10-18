package bj2491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int temp;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
		}
		int max = 1, tempmax;

		tempmax = 1;
		for(int i = 0; i < N-1; i++) {
			if(arr[i] <= arr[i+1])
				tempmax++;
			else {
				max = max > tempmax ? max : tempmax;
				tempmax = 1;
			}
		}
		max = max > tempmax ? max : tempmax;
		
		tempmax = 1;
		for(int i = 0; i < N-1; i++) {
			if(arr[i] >= arr[i+1])
				tempmax++;
			else {
				max = max > tempmax ? max : tempmax;
				tempmax = 1;
			}
		}
		max = max > tempmax ? max : tempmax;
		System.out.println(max);
	}
}
