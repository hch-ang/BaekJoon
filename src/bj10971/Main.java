package bj10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] arr;
	static int[] tobinary = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
	static int min = 10000000;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++)
			tobinary(i, i, tobinary[i], 0);
		System.out.println(min);
	}
	
	static void tobinary(int line, int cur, int binary, int sum) {
		if(binary == tobinary[N]-1) {
			if(arr[cur][line] > 0) {
				sum += arr[cur][line];
				min = min < sum ? min : sum;
			}
			return;
		}
				
		if(sum > min)
			return;
		
		for(int i = 0; i < N; i++) {
			if(arr[cur][i] == 0 || ((binary & tobinary[i]) > 0))
				continue;
			tobinary(line, i, binary + tobinary[i], sum + arr[cur][i]);
		}
	}
}
