package bj6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr;
	static int[] numbers = new int[6];
	static int K;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			K = Integer.parseInt(st.nextToken());
			sb = new StringBuilder();
			if(K == 0)
				return;
			arr = new int[K];
			for(int i = 0; i < K; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			
			for(int i = 0; i < K-5; i++) {
				numbers[0] = arr[i];
				simul(1, i);
			}
			System.out.println(sb.toString());
		}
	}
	
	static void simul(int iteration, int idx) {
		if(iteration == 6) {
			for(int i = 0; i < 6; i++)
				sb.append(numbers[i] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = idx+1; i < K-5+iteration; i++) {
			numbers[iteration] = arr[i];
			simul(iteration+1, i);
		}
		
	}
}
